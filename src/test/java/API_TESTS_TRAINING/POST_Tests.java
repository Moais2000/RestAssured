package API_TESTS_TRAINING;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POST_Tests {


    @Test
    public void POST_Test(){

        JSONObject data = new JSONObject();
        data.put("year",2019);
        data.put("price",1849.99);
        data.put("CPU model","Intel Core i9");
        data.put("Hard disk size","1 TB");


        JSONObject request = new JSONObject();
        request.put("name","Apple MacBook Pro 16");
        request.put("data",data);


        given().
           header("Content-Type","application/json").
           body(request.toJSONString()).
           contentType(ContentType.JSON).
        when().
            post("https://api.restful-api.dev/objects").
        then().
            statusCode(200).log().all();

    }

}
