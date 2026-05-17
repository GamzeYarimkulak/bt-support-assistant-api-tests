package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class HealthApiTest extends BaseTest {

    @Test
    public void shouldOpenSwaggerDocsSuccessfully() {

        given()

        .when()
                .get("/docs")

        .then()
                .statusCode(200)
                .time(lessThan(5000L));

    }
}