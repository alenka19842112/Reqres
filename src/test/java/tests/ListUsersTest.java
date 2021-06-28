package tests;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres_objects.ListUsers;

import static io.restassured.RestAssured.given;

public class ListUsersTest implements IConstansTest {

    @Test
    public void getListUserTest() {
        ListUsers listUsers =
                given().contentType(ContentType.JSON)
                        .log().all()
                .when()
                        .get(BASE_URL + "users?page=2")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response().as(ListUsers.class);
        Assert.assertTrue(listUsers.getData().size() > 0);
    }

    @Test
    public void getDataIdListUserTest() {
        ListUsers listUsers =
                given().contentType(ContentType.JSON)
                        .log().all()
                .when()
                        .get(BASE_URL + "users?page=2")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response().as(ListUsers.class);
        Assert.assertEquals(listUsers.getData().get(0).getId(), 7);
    }
}
