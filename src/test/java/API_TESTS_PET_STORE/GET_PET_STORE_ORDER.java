package API_TESTS_PET_STORE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GET_PET_STORE_ORDER {

    @DataProvider(name = "valid_order_ids")
    public Object[] valid_order_ids() {

        return new Object[]
                {
                 1,2
                };
    }

    @Test(dataProvider = "valid_order_ids")
    public void Get_order_by_valid_ids(int orderID)
    {
        baseURI="https://petstore.swagger.io/v2/";

        given().pathParam("orderID",orderID).
        when().
                get("/store/order/{orderID}").
        then().statusCode(200).log().all();

    }


}
