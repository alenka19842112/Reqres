package tests;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres_objects.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqResUserTest implements IConstansTest {

    @Test
    public void postUserTest() {
        User user = User.builder()
                .name("morpheus")
                .job("leader")
                .build();
        given()
                .body(user)
        .when()
                .post(USER_URI)
        .then()
                .statusCode(201);
    }

    @Test
    public void postCreateTest() {
        User user = User.builder()
                .name("morpheus")
                .job("leader")
                .build();
        user =
                given().contentType(ContentType.JSON)
                        .body(user)
                .when()
                        .post(USER_URI)
                .then()
                        .log().all()
                        .extract().response().as(User.class);
        boolean isCreate = user.getId() != null && user.getJob().equals("leader") && user.getName().equals("morpheus");
        Assert.assertTrue(isCreate);
    }

    @Test
    public void deleteUserTest() {
        given()
                .log().all()
        .when()
                .delete(USER_URI + "/2")
        .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    public void putUpDateUserTest() {
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        given().contentType(ContentType.JSON)
                .log().all()
                .body(user)
        .when()
                .put(USER_URI + "/2")
        .then()
                .log().all()
                .statusCode(200)
                .body("job", equalTo("zion resident"));
    }

    @Test
    public void patchUpDateUserTest() {
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        user =
        given().contentType(ContentType.JSON)
                .log().all()
                .body(user)
        .when()
                .patch(USER_URI + "/2")
        .then()
                .log().all()
                .statusCode(200)
                .extract().response().as(User.class);
        boolean isPatch = user.getJob().equals("zion resident") && user.getName().equals("morpheus");
        Assert.assertTrue(isPatch);
    }
}