package RestAssuredPackage;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class Chapter1Test {
    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200() {

        given().
                when().
                get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available").
                then().
                assertThat().
                statusCode(200).log().body();;
    }

    //Testcase Find pets by Status = Sold
    @Test
    public void GET_FindPetBySoldStatus() {
        given().log().all().
                when().
                get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=sold").
                then().
                assertThat().
                statusCode(200).log().body().assertThat().body("status", equalTo("[sold]"));
        //TODO we need to verify the verify the individual status value of n no of values
    }
    //Testcase Find pets by Status = Available
    @Test
    public void GET_FindPetByAvailableStatus() {
        given().
                when().
                get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available").
                then().
                assertThat().
                statusCode(200).log().body();

                //body("name",hasItem("Cat 1"));
    }
    //Testcase Find pets by Status = Pending
    @Test
    public void FindPetByPendingStatus() {
        given().
                when().
                get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=pending").
                then().
                assertThat().
                statusCode(200).log().body().assertThat().body("name",hasItem("Dog 3"));
    }

    //Testcases Find pets by Tag = Sold

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given().
                when().
                get("/").
                then().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));

        //     body("places[]", equalTo("'Cat 1', 'Cat 2', 'Dog 1', 'Lion 1', 'Lion 2', 'Lion 3', 'dogJan', 'doggie', 'doggie'"));
    }
}
/*
    <groupId>org.example</groupId>
    <artifactId>Rest-Assured Automation</artifactId>
    <version>1.0-SNAPSHOT</version>
    <groupId>org.example</groupId>
    <artifactId>Rest-Assured Automation</artifactId>
    <version>1.0-SNAPSHOT</version>
    */