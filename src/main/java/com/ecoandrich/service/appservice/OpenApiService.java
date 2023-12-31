package com.ecoandrich.service.appservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class OpenApiService {

    public String weatherCheck() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://data.ex.co.kr/openapi/restinfo/restWeatherList");

        urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "=3778853737");
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("sdate","UTF-8") + "=" + URLEncoder.encode(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")), "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("stdHour","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));

        URL url = new URL(urlBuilder.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;

        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        conn.disconnect();

        return sb.toString();
    }
}

