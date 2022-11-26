package com.meicansoftware.gerenciasala.services;

import okhttp3.*;

import org.json.JSONArray;

import java.io.IOException;

public class LoginService {

    public String login(String email, String password) {

        try {
            final OkHttpClient client = new OkHttpClient();

            RequestBody formBody = new FormBody.Builder()
                    .add("username", email)
                    .add("password", password)
                    .build();

            Request request = new Request.Builder()
                    .url("https://gerencia-sala-backend.azurewebsites.net/api/users/login")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .post(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException error) {
            error.printStackTrace();
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Usuário não cadastrado";
        }
    }
}
