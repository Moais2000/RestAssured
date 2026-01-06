package API_TESTS_PET_STORE;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DELETE_PET_STORE {

    @DataProvider(name = "deleted_ids")
    public Object[] DeletedIds() {

        return new Object[]
                {1,2};
    }

    @Test(dataProvider = "deleted_ids")
    public void Delete_order(int orderId)
    {
        given().pathParam("orderId",orderId).
        when().delete("https://petstore.swagger.io/v2/store/order/{orderId}").then().statusCode(200);
    }
}
