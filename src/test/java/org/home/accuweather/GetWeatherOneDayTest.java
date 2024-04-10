package org.home.accuweather;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.home.accuweather.AccuweatherAbstractTest;
import org.home.accuweather.weather.Weather;


import java.util.List;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование проекта accuweather.com")
@Feature(value = "Тестирование API Weather")
public class GetWeatherOneDayTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест GetWeatherOneDayTest - поиск погоды за 1 день ")
    @Description("Данный тест предназначен для получения данных о погоде за 1 день")
    @Link("https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/1day/%7BlocationKey%7D")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Егорова Ольга")
    @Story(value = "Вызов метода получения погоды за 1 день")
    void getWeatherOneDay_shouldReturn() {

        Weather response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/daily/1day/290396")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000l))
                .extract()
                .response()
                .body().as(Weather.class);

        Assertions.assertEquals(1,response.getDailyForecasts().size());
    }
}
