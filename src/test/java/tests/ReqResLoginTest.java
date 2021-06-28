package tests;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres_objects.Login;

import static io.restassured.RestAssured.given;

public class ReqResLoginTest implements IConstansTest{
    @Test
    public void loginUnsuccessfulTest() {
        Login login = Login.builder()
                .email("peter@klaven")
                .build();

        String error =
                given().contentType(ContentType.JSON)
                        .log().all()
                        .body(login)
                .when()
                        .post(LOGIN_URI)
                .then()
                        .log().all()
                        .statusCode(400)
                        .extract().response().path("error");
        Assert.assertEquals(error, "Missing password");
    }

    @Test
    public void loginSuccessfulTest(){
        Login login = Login.builder()
                .email("eve.holt@reqres.in")
                .password("cityslicka")
                .build();
        String token =
        given().contentType(ContentType.JSON)
                .log().all()
                .body(login)
        .when()
                .post(LOGIN_URI)
        .then()
                .log().all()
                .statusCode(200)
                .extract().response().path("token");
        Assert.assertEquals(token,"QpwL5tke4Pnpja7X4");
    }
}
