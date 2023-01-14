package homework.webservice.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import homework.webservice.objects.Response;
import homework.webservice.objects.SearchBody;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Preconditions {

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://178.124.206.46:8001/app/ws/")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final Logger LOGGER =
            Logger.getLogger(Preconditions.class.getName());



    void compareResponses(String searchBody) {
        SearchBody body = null;
        Response expectedResponse = null;
        try {
            body = gson.fromJson(new JsonReader(new FileReader(searchBody)), SearchBody.class);
            expectedResponse = gson.fromJson(new JsonReader(new FileReader("src/test/resources/homework/expectedResponse.json")), Response.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Response actualResponse = getResponse(body);
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    Response getResponse(SearchBody searchBody) {
        return RestAssured
                .given()
                .spec(requestSpec)
                .body(searchBody)
                .when()
                .post()
                .then()
                .extract()
                .body()
                .as(Response.class);
    }
}
