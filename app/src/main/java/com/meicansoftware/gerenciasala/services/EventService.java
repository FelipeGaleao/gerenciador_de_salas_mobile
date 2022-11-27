package com.meicansoftware.gerenciasala.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class EventService {
    public String addEvent(String access_token, String name, String description, String peopleCapacity , String courseName, String universityName,
                           String inicialDate, String finalDate, String inicialTime, String finalTime) {
        try {
            final OkHttpClient client = new OkHttpClient();

            JSONObject obj = new JSONObject();
            obj.put("nome", name);
            obj.put("descricao", description);
            obj.put("quantidade_de_pessoas", peopleCapacity);
            obj.put("nome_curso", courseName);
            obj.put("nome_faculdade", universityName);
            obj.put("dt_inicio_evento", inicialDate);
            obj.put("dt_fim_evento", finalDate);
            obj.put("hr_inicio_evento", inicialTime);
            obj.put("hr_fim_evento", finalTime);
            obj.put("dt_criacao", "2022-11-27T14:49:15.227140");
            obj.put("dt_modificacao", "2022-11-27T14:49:15.227140");

            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(JSON, obj.toString());

            Request request = new Request.Builder()
                    .url("https://gerencia-sala-backend.azurewebsites.net/api/events/")
                    .header("Authorization", "Bearer " + access_token)
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            Log.d("Teste", response.body().string());
            return response.body().string();
        } catch (IOException error) {
            error.printStackTrace();
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
