package org.home.accuweather;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.seminar.accuweather.location.Location;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование проекта accuweather.com")
@Feature(value = "Тестирование API Location")
public class GetLocationTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест  GetLocationTest - поиск обьекта Location ")
    @Description("Данный тест предназначен для поиска Location по ключу Samara")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis/get/locations/v1/cities/autocomplete")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Егорова Ольга")
    @Story(value = "Получение объекта Location по ключу Samara")
    void getLocation_autocomplete_returnSamara() {

        List<org.seminar.accuweather.location.Location> response = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Samara")
                .when()
                .get(getBaseUrl()+"/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000l))
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(10,response.size());
        Assertions.assertEquals("Samara", response.get(0).getLocalizedName());
    }
}
