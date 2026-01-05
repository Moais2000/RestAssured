package API_TESTS_TRAINING;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DataProviderExamples {


//    @DataProvider(name = "Postdataprovider")
//    public Object[][] FirstdataproviderTest() {
//
//        Object[][] data = new Object[2][3];
//
//        data[0][0] = 2;
//        data[0][1] = "Moamen";
//        data[0][2] = "ashrafmoamen56@gmail.com";
//
//        data[1][0] = 3;
//        data[1][1]= "Mohamed";
//        data[1][2]= "ma36@gmail.com";
//
//        return data;
//    }
//
//    @Test(dataProvider = "Postdataprovider")
//    public void Post_multiple_test(int id ,String name, String email)
//    {
//        JSONObject request = new JSONObject();
//
//        request.put("id",id);
//        request.put("name",name);
//        request.put("email",email);
//
//        given().
//                contentType(ContentType.JSON).
//                body(request.toJSONString()).
//        when().
//             post("http://localhost:3000/users").
//        then().
//             statusCode(201);
//    }

    @DataProvider(name = "Deletedataprovider")
    public Object[] SeconddataproviderTest() {

        return new Object[]
                {2,3};
    }

    @Test(dataProvider = "Deletedataprovider")
    public void Delete_multiple_test(int id)
    {
            given().pathParam("id",id).
            when().
                delete("http://localhost:3000/users/{id}").
                then().
                statusCode(200);
    }

//    @Test
//    public void get_all_users()
//    {
//        given().
//                get("http://localhost:3000/users").then().statusCode(200).log().all();
//    }

}
