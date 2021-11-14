package at.htl.Boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.*;

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