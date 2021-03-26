import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.reflect.TypeToken;
import com.shinemo.client.util.GsonUtil;

/**
 * @author htdong
 */

public class Main {

    private static TypeToken<TreeMap<String, Object>> type = new TypeToken<TreeMap<String, Object>>() {
    };

    public static void main(String[] args) throws JsonProcessingException {
        TreeMap<String, Object> m1 = GsonUtil.fromGson2Obj(
                "{\"appointTime\":null,\"appointTimeSecond\":null,\"broadBandStatus\":null,\"id\":\"fc58471f4a8c412e8ec25d79def37d6d\",\"ifWaitForSubTask\":\"false\",\"isAppointTimeSecond\":null,\"linkReplyedResults\":null,\"mainAccessNumber\":\"18797801018\",\"mainAccessType\":\"FTTH接入\",\"mainAccessTypeId\":\"mainAccessType\\u003d\\u003d32\",\"mainBookingStartDate\":\"2021-03-26 13:00:00\",\"mainCity\":\"鹰潭市\",\"mainCityId\":\"701\",\"mainCountry\":\"贵溪市\",\"mainCountryId\":\"7011\",\"mainCoverAreaName\":null,\"mainCustomerLevel\":\"四星\",\"mainCustomerLevelId\":\"mainCustLevel\\u003d\\u003d4\",\"mainCustomerName\":\"倪后胜\",\"mainInstallLocation\":\"鹰潭贵溪市塘湾镇塘湾集镇塘湾集镇南25栋39号箱2层203();\",\"mainLinkmanNumbers1\":\"15970285249\",\"mainLinkmanNumbers2\":null,\"mainMyRemark\":null,\"mainPbossOrderType\":\"移机\",\"mainPbossOrderTypeId\":\"mainOrderType\\u003d\\u003d3\",\"mainPbossProductType\":\"有线宽带\",\"mainPbossProductTypeId\":\"mainProdType\\u003d\\u003d19\",\"mainPbossSheetType\":\"外线施工\",\"mainPbossSheetTypeId\":\"mainSheetType\\u003d\\u003d8\",\"mainRemindCount\":null,\"mainReplyInstall\":\"否\",\"mainReplyInstallId\":\"mainReplyInstall\\u003d\\u003d2\",\"mainResponseLevel\":\"1\",\"mainUpdateAppointCount\":null,\"operateRoleId\":\"1\",\"overtimeType\":null,\"preLinkId\":\"db7e1686e7b64105b996549966b75f86\",\"processId\":\"db7e1686e7b64105b996549966b75f86\",\"sendTime\":\"2021-03-26 11:07:02\",\"sheetAcceptLimit\":\"2021-03-26 12:07:02\",\"sheetCompleteLimit\":\"2021-03-29 11:02:39\",\"sheetId\":\"JX-201-210326-00094\",\"sheetKey\":\"db7e1686e7b64105b996549966b75f86\",\"subTaskFlag\":\"false\",\"taskDisplayName\":\"上门施工\",\"taskName\":\"InstallTask\",\"taskOwner\":\"廖志诚\",\"taskStatus\":\"22\",\"title\":\"18797801018有线宽带四星鹰潭贵溪市塘湾镇塘湾集镇塘湾集镇南25栋39号箱2层203();【需正装机】\"}",
                type);
        TreeMap<String, Object> m2 = GsonUtil.fromGson2Obj("{\r\n" + "\"appointTimeSecond\": \"\",\r\n"
                + "\"mainPbossOrderType\": \"新装\",\r\n" + "\"ifWaitForSubTask\": \"false\",\r\n"
                + "\"preLinkId\": \"5a5703c710894d8da3d3860c0f74b713\",\r\n" + "\"taskDisplayName\": \"工单受理\",\r\n"
                + "\"subTaskFlag\": \"false\",\r\n" + "\"mainBookingStartDate\": \"2021-03-26 11:00:00\",\r\n"
                + "\"mainCustomerName\": \"倪后胜\",\r\n" + "\"sheetAcceptLimit\": \"2021-03-26 12:06:05\",\r\n"
                + "\"id\": \"3d09c4d14008450293319ef1a8a3cc67\",\r\n" + "\"linkReplyedResults\": \"\",\r\n"
                + "\"taskStatus\": \"22\",\r\n" + "\"mainCountryId\": \"7011\",\r\n"
                + "\"mainAccessType\": \"FTTH接入\",\r\n" + "\"appointTime\": \"\",\r\n"
                + "\"mainCustomerLevel\": \"四星\",\r\n" + "\"mainRemindCount\": \"\",\r\n"
                + "\"operateRoleId\": \"1\",\r\n" + "\"mainMyRemark\": \"\",\r\n"
                + "\"sendTime\": \"2021-03-26 11:06:05\",\r\n" + "\"mainCityId\": \"701\",\r\n"
                + "\"mainCity\": \"鹰潭市\",\r\n" + "\"mainLinkmanNumbers2\": \"\",\r\n"
                + "\"mainPbossProductType\": \"安防产品\",\r\n" + "\"mainLinkmanNumbers1\": \"18797801018\",\r\n"
                + "\"operateUserId\": \"liaozhicheng1\",\r\n" + "\"taskName\": \"AcceptTask\",\r\n"
                + "\"isAppointTimeSecond\": \"\",\r\n" + "\"taskOwner\": \"廖志诚\",\r\n"
                + "\"mainPbossSheetType\": \"外线施工\",\r\n" + "\"mainCountry\": \"贵溪市\",\r\n"
                + "\"title\": \"18797801018安防产品四星鹰潭贵溪市塘湾镇塘湾集镇塘湾集镇农村46号箱李五奥()\",\r\n"
                + "\"mainCoverAreaName\": \"\",\r\n" + "\"sheetKey\": \"5a5703c710894d8da3d3860c0f74b713\",\r\n"
                + "\"operaterContact\": \"152****2205\",\r\n" + "\"broadBandStatus\": \"\",\r\n"
                + "\"mainReplyInstall\": \"\",\r\n" + "\"mainPbossProductTypeId\": \"mainProdType==42\",\r\n"
                + "\"processId\": \"5a5703c710894d8da3d3860c0f74b713\",\r\n"
                + "\"mainPbossOrderTypeId\": \"mainOrderType==1\",\r\n"
                + "\"sheetCompleteLimit\": \"2021-03-29 11:05:59\",\r\n" + "\"mainAccessNumber\": \"18797801018\",\r\n"
                + "\"mainInstallLocation\": \"鹰潭贵溪市塘湾镇塘湾集镇塘湾集镇农村46号箱李五奥()\",\r\n" + "\"mainResponseLevel\": \"1\",\r\n"
                + "\"overtimeType\": \"\",\r\n" + "\"mainAccessTypeId\": \"mainAccessType==32\",\r\n"
                + "\"mainCustomerLevelId\": \"mainCustLevel==4\",\r\n" + "\"mainUpdateAppointCount\": \"\",\r\n"
                + "\"sheetId\": \"JX-201-210326-00091\",\r\n" + "\"mainPbossSheetTypeId\": \"mainSheetType==8\"\r\n"
                + "}", type);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature());
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        System.out.println(objectMapper.writeValueAsString(m1));
        System.out.println(objectMapper.writeValueAsString(m2));

    }
}