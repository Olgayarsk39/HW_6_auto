package org.home.accuweather;


import io.qameta.allure.*;
import io.restassured.http.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование проекта accuweather.com")
@Feature(value = "Тестирование API Weather")
public class GetWeatherTenDayTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест get_ten_day_return_401 (негативый) - поиск погоды за 10 дней ")
    @Description("Негативный тест - проверка получения данных о погоде за 10 дней")
    @Link("https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/10day/%7BlocationKey%7D")
    @Severity(SeverityLevel.MINOR)
    @Owner("Егорова Ольга")
    @Story(value = "Вызов метода получения погоды за 10 дней")
    void get_ten_day_return_401() {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 290396)
                .when()
                .request(Method.GET,getBaseUrl()+"/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);
    }
}
