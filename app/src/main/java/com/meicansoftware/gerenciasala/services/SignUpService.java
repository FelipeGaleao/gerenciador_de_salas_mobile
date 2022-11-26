package com.meicansoftware.gerenciasala.services;

import android.util.Log;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class SignUpService {
    public String signUp(String name, String lastName, String email , String password, String capacity) {
        try {
            final OkHttpClient client = new OkHttpClient();

            JSONObject obj = new JSONObject();
            obj.put("nome", name);
            obj.put("sobrenome", lastName);
            obj.put("senha", password);
            obj.put("email", email);
            obj.put("lotacao", capacity);

            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(JSON, obj.toString());

            Request request = new Request.Builder()
                    .url("https://gerencia-sala-backend.azurewebsites.net/api/users/")
                    .header("Content-Type", "application/json")
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
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
