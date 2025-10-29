package com.htdong.aws.s3;

import java.net.URI;
import java.time.Duration;

import lombok.AllArgsConstructor;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.SdkHttpConfigurationOption;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;
import software.amazon.awssdk.transfer.s3.progress.TransferListener;
import software.amazon.awssdk.utils.AttributeMap;

/**
 * @author dht31261
 * @date 2024年4月3日 14:08:41
 */
public class S3Application {

    public static void main(String[] args) {
        URI endpoint = URI.create("http://127.0.0.1:9000");
        Region region = Region.of("us-east-1");

        AwsBasicCredentials creds = AwsBasicCredentials.create("admin", "admin123");
        // double throughput = 0.5;
        // long MB = 1024L * 1024L;
        // S3AsyncClient s3AsyncClient = S3AsyncClient.crtBuilder()
        // .credentialsProvider(StaticCredentialsProvider.create(creds)).endpointOverride(URI.create(endpoint))
        // .region(region).maxConcurrency(16).maxNativeMemoryLimitInBytes(1024 * MB).minimumPartSizeInBytes(8 * MB)
        // .initialReadBufferSizeInBytes(64 * MB).targetThroughputInGbps(throughput).checksumValidationEnabled(false)
        // .forcePathStyle(false).retryConfiguration(S3CrtRetryConfiguration.builder().numRetries(2).build())
        // .forcePathStyle(true).build();
        // S3TransferManager s3TransferManager = S3TransferManager.builder().s3Client(s3AsyncClient).build();

        SdkHttpClient httpClient = UrlConnectionHttpClient.builder().buildWithDefaults(
            AttributeMap.builder().put(SdkHttpConfigurationOption.TRUST_ALL_CERTIFICATES, true).build());

        S3Client s3Client = S3Client.builder().endpointOverride(endpoint).region(region)
            .credentialsProvider(StaticCredentialsProvider.create(creds)).forcePathStyle(true).httpClient(httpClient)
            .build();

        // String obsPre = "obs://ai-storage-dev/aimaas-llmtraining/models";
        // obsPre = obsPre.replace("obs://ai-storage-dev/", "").trim();
        // if (!obsPre.endsWith("/")) {
        // obsPre += "/";
        // }
        //
        // ListObjectsRequest listObjects =
        // ListObjectsRequest.builder().bucket("ai-storage-dev").prefix(obsPre).build();
        // ListObjectsResponse res = s3Client.listObjects(listObjects);
        // for (S3Object k : res.contents()) {
        // if (k.key().equals(obsPre)) {
        // continue;
        // }
        // System.out.println(k.key());
        // }
        try (S3Presigner presigner = S3Presigner.builder().s3Client(s3Client).region(region)
            .credentialsProvider(StaticCredentialsProvider.create(creds)).endpointOverride(endpoint).build()) {
            PutObjectRequest objectRequest =
                PutObjectRequest.builder().bucket("ai-storage-dev").key("maasresourcemgr-init.sql").build();

            PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(1)).putObjectRequest(objectRequest).build();

            PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(presignRequest);
            String url = presignedRequest.url().toExternalForm();
            System.out.println(url);
        }
    }

    @AllArgsConstructor
    private static class TransfetStatus implements TransferListener {

        private String log;

        @Override
        public void bytesTransferred(Context.BytesTransferred context) {
            System.out.print(log + " ");
            System.out.println(context.progressSnapshot().transferredBytes() / 1024.0 / 1024.0);
        }
    }
}