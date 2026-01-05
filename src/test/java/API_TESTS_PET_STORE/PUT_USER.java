package API_TESTS_PET_STORE;

import io.restassured.http.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PUT_USER {


    @DataProvider(name = "User_Put_data")
    public Object[][] User_Data()
    {

        return new Object[][]{

                {25,"moamen200@@","moamen","ashraf","ashrafmoamen56@gmail.com","moamen123456","10122151",0},
        };
    }

    @Test(dataProvider = "User_Put_data")
    public void putUser(int ID, String username,String fname,String lname ,String email,String password,String phone,int userStatus){

        JSONObject request = new JSONObject();
        request.put("id",ID);
        request.put("username",username);
        request.put("firstName",fname);
        request.put("lastName",lname);
        request.put("email",email);
        request.put("password",password);
        request.put("phone",phone);
        request.put("userStatus",userStatus);

        given().pathParam("username",username).body(request.toJSONString()).contentType(ContentType.JSON).
                when().put("https://petstore.swagger.io/v2/user/{username}").then().statusCode(200);
    }
}
