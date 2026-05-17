package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class OpenApiTest extends BaseTest {

    @Test
    public void shouldReturnOpenApiDocumentationSuccessfully() {

        given()

        .when()
                .get("/openapi.json")

        .then()
                .statusCode(200)
                .time(lessThan(5000L))
                .body("openapi", notNullValue())
                .body("info.title", notNullValue());
    }
}