package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    
    @GetMapping("/weather")
    public WeatherReport getWeather() {
        WeatherReport report = new WeatherReport();
        report.setHeadlineText("ヘッドラインです");
        report.setPublishingOffice("野崎天文台");
        report.setTargetArea("オランダ");
        report.setText("本日は晴天なり");

        return report;
    }
    
    @GetMapping("/checkWeather/{location}")
    public WeatherReport getWeather(@PathVariable String location) {
        WeatherReport report = new WeatherReport();
        report.setHeadlineText("ヘッドラインです");
        report.setPublishingOffice("野崎天文台");
        report.setTargetArea(location); // パス変数を利用してロケーションを設定
        report.setText("本日は晴天なり");

        return report;
    }
    
    // POSTリクエストを処理するメソッド
    @PostMapping("/weather")
    public WeatherReport postWeather(@RequestBody WeatherReport report) {
        // ここでリクエストボディから受け取ったWeatherReportオブジェクトをそのまま返します
        return report;
    }
}
