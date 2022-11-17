package com.meicansoftware.gerencia_sala_ufms.services;

import android.os.StrictMode;

import java.io.IOException;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RoomService {
    final OkHttpClient client = new OkHttpClient();

    public String get_rooms() throws IOException {
        Request request = new Request.Builder()
                .url("https://gerencia-sala-backend.azurewebsites.net/api/rooms/")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


}
