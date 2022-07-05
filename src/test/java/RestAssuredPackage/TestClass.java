package RestAssuredPackage;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestClass {
    public static Map<String, String> map = new HashMap<String, String>();
    @BeforeClass
    public static void putData(){
        map.put("userId", "2");
        map.put("id", "19");
        map.put("title", "this is projectdebug.com");
        map.put("body", "i am testing REST api with REST-Assured and sending a PUT request.");
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }
    @Test
    public void AddNewPet(){
        given()
                .contentType("application/json")
                .body(map)
                .when()
                .put("/100")
                .then()
                .statusCode(200);
    }
}
