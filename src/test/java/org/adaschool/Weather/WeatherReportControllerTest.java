package org.adaschool.Weather;

import org.adaschool.Weather.controller.WeatherReportController;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WeatherReportControllerTest {

    @Mock
    private WeatherReportService weatherReportService;

    @InjectMocks
    private WeatherReportController weatherReportController;

    @Test
    void testGetWeatherReport() {
        double latitude = 37.8267;
        double longitude = -122.4233;
        WeatherReport mockReport = new WeatherReport();
        mockReport.setTemperature(25.0);
        mockReport.setHumidity(60.0);

        when(weatherReportService.getWeatherReport(latitude, longitude)).thenReturn(mockReport);

        WeatherReport result = weatherReportController.getWeatherReport(latitude, longitude);

        assertNotNull(result);
        assertEquals(25.0, result.getTemperature());
        assertEquals(60.0, result.getHumidity());
        verify(weatherReportService, times(1)).getWeatherReport(latitude, longitude);
    }
}