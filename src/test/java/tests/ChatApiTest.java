package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ChatApiTest extends BaseTest {

    @Test
    public void shouldReturnChatResponseSuccessfully() {

        String requestBody = """
                {
                    "query": "VPN şifremi unuttum",
                    "session_id": "test-session",
                    "language": "tr"
                }
                """;

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)

        .when()
                .post("/api/v1/chat")

        .then()
                .statusCode(200)
                .time(lessThan(90000L))
                .body("has_answer", equalTo(true))
                .body("confidence", greaterThan(0.0f));
    }
}