package org.home.accuweather;


import io.qameta.allure.*;
import io.restassured.http.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;



@Epic(value = "Тестирование проекта accuweather.com")
@Feature(value = "Тестирование API Weather")
public class GetWeatherFiftenDayTest extends AccuweatherAbstractTest{
    @Test
    @DisplayName("Тест get_fiften_day_return_401 (негативный) - поиск погоды за 15 дней ")
    @Description("негативный тест - проверка получения данных о погоде за 15 дней")
    @Link("https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/15day/%7BlocationKey%7D")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Егорова Ольга")
    @Story(value = "Вызов метода получения погоды за 15 дней")
    void get_fiften_day_return_401() {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 290396)
                .when()
                .request(Method.GET,getBaseUrl()+"/forecasts/{version}/daily/15day/{location}")
                .then()
                .statusCode(401);
    }
}
