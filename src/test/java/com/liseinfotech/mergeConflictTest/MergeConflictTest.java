package com.liseinfotech.mergeConflictTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.nashorn.api.scripting.JSObject;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static io.restassured.RestAssured.*;

public class MergeConflictTest {
    @Test(priority = 1)
    public void getTest(){
        baseURI = "https://reqres.in/api/users?page=2";

        Response response= given().contentType(ContentType.JSON).get();
        System.out.println(response.asString());

        response.prettyPrint();
        JSONObject jsonObject = new JSONObject(response.asString());

        assertThat(response.getStatusCode(), is(HttpStatus.SC_OK));

        assertThat(jsonObject.getInt("total"), is(12));
        assertThat(jsonObject.getInt("page"), is(equalTo(1)));
        assertThat(jsonObject.getInt("per_page"), is(equalTo(6)));
        assertThat(jsonObject.getInt("total_pages"), is(equalTo(2)));
    }
}
