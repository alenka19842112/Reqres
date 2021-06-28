package tests;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres_objects.Resource;

import static io.restassured.RestAssured.given;

public class ListResourceTest implements IConstansTest {

    @Test
    public void getDataListResourceTest() {
        Resource resource =
                given().contentType(ContentType.JSON)
                        .log().all()
                .when()
                        .get(BASE_URL + "unknown")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response().as(Resource.class);
        String response = "DataResource(id=2, name=fuchsia rose, year=2001, color=#C74375, pantoneValue=17-2031)";
        Assert.assertEquals(resource.getData().get(1).toString(), response);
    }

    @Test
    public void getSupportListResourceTest() {
        Resource resource =
                given().contentType(ContentType.JSON)
                        .log().all()
                .when()
                        .get(BASE_URL + "unknown")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response().as(Resource.class);
        Assert.assertNotNull(resource.getSupport().getText());
    }
}
