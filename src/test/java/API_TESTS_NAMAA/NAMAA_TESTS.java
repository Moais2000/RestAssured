package API_TESTS_NAMAA;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NAMAA_TESTS {

    static String transaction_id;
    static String access_token;


    @Test(priority = 0)
    public void POST_REQUEST_to_get_transaction_id()
    {

        JSONObject obj = new JSONObject();
        obj.put("mockRequest",true);
        obj.put("nationalId","1000000008");


        JsonPath jp=
        given().
                contentType("application/json").contentType(ContentType.JSON).body(obj.toJSONString()).
        when().post("https://api.namaa.sumerge.com/auth-svc/api/v1/nafath").
        then().statusCode(200).extract().jsonPath();

        transaction_id = jp.getString("transactionId");

        System.out.println(transaction_id);

    }

    @Test(priority = 1)
    public void GET_REQUEST_With_transaction_id()
    {
        Response response=
                given().pathParam("transaction_id",transaction_id).
                        header("Referer", "https://portal.namaa.sumerge.com/").
                when().get(
                        "https://api.namaa.sumerge.com/auth-svc/api/v1/nafath/status/{transaction_id}?X-Current-Path=%2Flogin");

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        access_token=response.getDetailedCookies().get("accessToken").getValue();
        System.out.println(access_token);
    }

    @Test(priority = 2)
    public void POST_REQUEST_with_access_token()
    {

        JSONArray obj = new JSONArray();
        obj.add("CF_MEMBERS_RATIFICATION");
        obj.add("CF_MEMBERS_RATIFICATION_BANK_DEFINE");
        obj.add("CF_DEFINE_BANK_ACCOUNT");
        obj.add("CF_RETURNED_TO_REQUESTER");
        obj.add("INQUIRY");
        obj.add("MM_MEMBERS_RATIFICATION");
        obj.add("PENDING");
        obj.add("RETURNED");
        obj.add("DELEGATED");
        obj.add("BR_RETURNED_TO_CREATOR");
        obj.add("MM_RETURN_TO_REQUESTER_FOR_EDIT");
        obj.add("EM_RETURN_TO_REQUESTER");
        obj.add("SD_EDIT_COOPERATIVES_BANK_ACCOUNT");
        obj.add("RCPU_RETURNED_TO_REQUESTER");
        obj.add("ELR_APPLICANT_EDIT_REQUEST");
        obj.add("ELR_PENDING_PAYMENT");
        obj.add("ERLR_APPLICANT_EDIT_REQUEST");


        JSONObject req = new JSONObject();
        req.put("requestStatus",obj);


        JsonPath response=
         given()
                 .header("Referer", "https://portal.namaa.sumerge.com/")
                 .cookie("accessToken", access_token).
                 body(req.toJSONString()).contentType("application/json").
                 when().post("https://api.namaa.sumerge.com/bpm-svc/request/current?page=0&size=10").then().statusCode(200).extract().jsonPath();


        Assert.assertEquals(response.getString("content[0].entityName"),"مراسلات15");

    }
}
