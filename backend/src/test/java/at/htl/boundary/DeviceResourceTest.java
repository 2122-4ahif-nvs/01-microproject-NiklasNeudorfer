package at.htl.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
class DeviceResourceTest {


    @Test
    public void getDevice(){
        when()
                .get("/device")
                .then()
                .statusCode(200)
                .body(startsWith("Device{name="));
    }
}