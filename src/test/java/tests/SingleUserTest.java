package tests;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres_objects.SingleUser;

import static io.restassured.RestAssured.given;

public class SingleUserTest implements IConstansTest{
    @Test
    public void getEmailSingleUserTest(){
        SingleUser singleUser =
                given().contentType(ContentType.JSON)
                        .log().all()
                .when()
                        .get(USER_URI + "/2")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response().as(SingleUser.class);
        Assert.assertEquals(singleUser.getData().getEmail(),"janet.weaver@reqres.in");
    }

    @Test
    public void getSingleUserNotFoundTest(){
        given().contentType(ContentType.JSON)
                .log().all()
        .when()
                .get(USER_URI + "/23")
        .then()
                .log().all()
                .statusCode(404);
    }
}
