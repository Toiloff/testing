package org.example;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

public class Main {
    public static void main(String[] args) {
        get_users();
    }

    public static void get_users() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)
                .build();

        RestAssured.requestSpecification = requestSpec;

        RestAssured
                .get("users/1")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("username", Matchers.equalTo("Bret"));
    }
}