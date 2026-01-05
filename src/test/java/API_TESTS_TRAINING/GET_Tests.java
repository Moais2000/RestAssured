package API_TESTS_TRAINING;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GET_Tests {

    @Test
    public void SampleTest_GET(){

        JsonPath jp=
              given().
                  when().get("https://api.restful-api.dev/objects?id=3&id=5&id=10").
              then().
                   statusCode(200).extract().jsonPath();

        Assert.assertEquals(jp.getInt("id[0]"),3);
//             body("id[0]",equalTo("3")).
//             body("id[1]",equalTo("5")).
//             body("id[2]",equalTo("10")).
//             body("data.color[1]",equalTo("Brown")).
//             log().all();

        /*Response response = RestAssured.get("https://api.restful-api.dev/objects?id=3&id=5&id=10");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String color = response.jsonPath().getString("data.color[1]");
        Assert.assertEquals(color,"Brown");

        System.out.println(response.getBody().asString());
        System.out.println(response.getTime());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeaders());

        String name = response.jsonPath().getString("name[0]");
        Assert.assertEquals(name,"Apple iPhone 12 Pro Max");*/

    }

}