import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String obsPre = "obs://ai-storage-dev/aimaas-llmtraining/models/t5-base";
        obsPre = obsPre.replace("obs://ai-storage-dev/", "").trim();
        if (!obsPre.endsWith("/")) {
            obsPre += "/";
        }
        System.out.println(obsPre);
    }
}