package API_TESTS_TRAINING;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PUT_Tests {

    @Test
    public void putTest() {

            JSONObject data = new JSONObject();
            data.put("year", 2019);
            data.put("price", 2049.99);
            data.put("CPU model", "Intel Core i9");
            data.put("Hard disk size", "1 TB");
            data.put("color", "silver");


            JSONObject request = new JSONObject();
            request.put("name", "Apple MacBook Pro 16");
            request.put("data", data);

            given().
                    header("Content-Type", "application/json").
                    body(request.toJSONString()).
                    contentType(ContentType.JSON).

                    when().
                    put("https://api.restful-api.dev/objects/ff8081819782e69e019b7f3b1cb5351d").

                    then().
                    statusCode(200).log().all();
        }
    }

