package tests;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres_objects.DelayedResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DelayedResponseTest implements IConstansTest {
    @Test
    public void getPageDelayedResponseTest() {

        given().contentType(ContentType.JSON)
                .log().all()
        .when()
                .get(BASE_URL + "users?delay=3")
        .then()
                .log().all()
                .statusCode(200)
                .body("page", equalTo(1));
    }
    @Test
    public void getDataIdDelayedResponseTest() {
        DelayedResponse delayedResponse =
        given().contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(BASE_URL + "users?delay=3")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response().as(DelayedResponse.class);
        Assert.assertEquals(delayedResponse.getData().get(1).getId(), 2);
    }
    @Test
    public void getExistsFirstNameDelayedResponseTest() {
        DelayedResponse delayedResponse =
                given().contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .get(BASE_URL + "users?delay=3")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response().as(DelayedResponse.class);
        Assert.assertNotNull(delayedResponse.getData().get(3).getFirstName());
    }
}

