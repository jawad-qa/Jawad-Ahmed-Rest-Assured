package RestAssuredPackage;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasItem;


import static io.restassured.RestAssured.given;
@RunWith(DataProviderRunner.class)
public class Locators {
    @DataProvider
    public  static Object [][] Status(){
        return new Object[][]{

                {"available"},
                {"pending"},
                {"sold"}
        };
    }
    @DataProvider
    public  static Object [][] petName(){
        return new Object[][]{

                {"101","doggie1","available"},
                {"pending"},
                {"sold"}
        };
    }

    public static Map<String, String> map = new HashMap<String, String>();



    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://petstore3.swagger.io/api/v3/pet").
                build();
    }


    private static ResponseSpecification responseSpec;
    @BeforeClass
    public static void createResponseSpecification() {

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test

    @UseDataProvider("Status")
    public void UpdateAnExistingPet(String expectedStatus){
     //   String checkStatus =
        given().
                spec(requestSpec).queryParam("status", expectedStatus).
                when().
                get("/findByStatus").
                then().assertThat().body("status",hasItem(expectedStatus));
                //extract().path("status");

      //  Assert.assertEquals(checkStatus, expectedStatus);
    }

    @BeforeClass
    public static void putData(){
        map.put("id","101");
        map.put("name","Doggietommy");
    }

     @Test
    public void AddNewPet(){

        given().contentType("application/json").body(map).when().put("").then().log().body();
//                then().extract().path("status");

        //  Assert.assertEquals(checkStatus, expectedStatus);
    }

}

