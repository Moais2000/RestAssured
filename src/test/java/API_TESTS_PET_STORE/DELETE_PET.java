package API_TESTS_PET_STORE;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DELETE_PET {

    @DataProvider(name = "deleted_ids")
    public Object[] DeletedIds() {

        return new Object[]
                {1,2};
    }

    @Test(dataProvider = "deleted_ids")
    public void Delete_order(int petID)
    {
        given().pathParam("petID",petID).
        when().delete("https://petstore.swagger.io/v2/pet/{petID}").then().statusCode(200);
    }
}
