package com.reqres.gerenciador;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.response.Response;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static java.awt.SystemColor.text;
import static org.hamcrest.Matchers.*;

public class GerenciadorTest {
    private ValidatableResponse Response;

    @Test
    public void testDadoUmUsuarioQuandoPreenchoCadastroObtenhoStatusCode201(){
        Empregado empregado = new Empregado("morpheus", "leader");

        String json = "{\n" +
                "    \"name\": \"" + empregado.getName() + "\",\n" +
                "    \"job\": \"" + empregado.getJob() + "\"\n" +
                "}";

        //Configurar caminho comum de acesso a API Rest
        baseURI = "https://reqres.in/";
        port = 443;
        basePath = "/api/users";

        //Request
        Response response = (io.restassured.response.Response) given()
                .body(json)
                .contentType(ContentType.JSON)
                .when()
                        .post("/api/users");

        Assert.assertEquals(response.statusCode(), 201);

        response.then()
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }

}
