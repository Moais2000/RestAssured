package API_TESTS_PET_STORE;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class POST_PET_STORE {

    @DataProvider(name = "Pet_Data")
    public Object[][] getPet_Data()
    {

        return new Object[][]{

                {1,12,2,"2026-01-05T12:18:01.416Z","placed","false"},
                {2,11,3,"2026-01-05T12:18:01.416Z","placed","false"},
        };
    }

    @Test(dataProvider = "Pet_Data")
    public void post_pet(int orderID, int petID,int quantity ,String shipdate,String status,String complete)
    {

        JSONObject request = new JSONObject();
        request.put("id",orderID);
        request.put("petID",petID);
        request.put("quantity",quantity);
        request.put("shipDate",shipdate);
        request.put("status",status);
        request.put("complete",complete);


        given().body(request.toJSONString()).contentType(ContentType.JSON).
        when().post("https://petstore.swagger.io/v2/store/order").then().statusCode(200);
    }
}
