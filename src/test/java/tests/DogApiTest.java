package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DogApiTest extends BaseTest {

    @Test
    @DisplayName("API should return all breeds with expected response format")
    void shouldReturnAllBreedsSuccessfully() {
        given()
                .spec(requestSpecification)
                .when()
                .get("/breeds/list/all")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", notNullValue())
                .body("message", instanceOf(java.util.Map.class))
                .body("message.keySet()", hasItem("hound"))
                .time(lessThan(3000L));
    }

    @Test
    @DisplayName("API should return random image with expected response format")
    void shouldReturnRandomImageWithExpectedFormat() {
        String imageUrl =
                given()
                        .spec(requestSpecification)
                        .when()
                        .get("/breeds/image/random")
                        .then()
                        .statusCode(200)
                        .body("status", equalTo("success"))
                        .body("message", not(blankOrNullString()))
                        .body("message", startsWith("https://"))
                        .time(lessThan(3000L))
                        .extract()
                        .path("message");

        URI.create(imageUrl);
    }

    @Test
    @DisplayName("API should return akita images with expected response format")
    void shouldReturnAkitaImagesWithExpectedFormat() {
        given()
                .spec(requestSpecification)
                .when()
                .get("/breed/akita/images")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", not(empty()))
                .body("message", instanceOf(java.util.List.class))
                .body("message[0]", startsWith("https://"))
                .time(lessThan(3000L));
    }

    @Test
    @DisplayName("Should return 404 and error message for invalid breed")
    void shouldReturnErrorForInvalidBreed() {
        given()
                .spec(requestSpecification)
                .when()
                .get("/breed/caramelo/images")
                .then()
                .statusCode(404)
                .body("status", equalTo("error"))
                .body("message", equalTo("Breed not found (main breed does not exist)"))
                .body("code", equalTo(404))
                .time(lessThan(3000L));
    }
}
