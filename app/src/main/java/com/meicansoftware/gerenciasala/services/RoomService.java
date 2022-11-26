package com.meicansoftware.gerenciasala.services;

import android.os.StrictMode;
import android.util.Log;

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

    // call delete endpoint and send JWT token
    public String delete_room(String id) throws IOException {
        Request request = new Request.Builder()
                .url("https://gerencia-sala-backend.azurewebsites.net/api/rooms/delete_room_by_id?room_id=" + id)
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2Njk0MjQ4OTUsInN1YiI6Im1heWNvbi5tb3RhQHVmbXMuYnIifQ.Y_XjrvaxlvO7E3m-DYGMCp3noPS8Z0QQMlZTV0gEN7I")
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            Log.d("e", "executando delete request");
            return response.body().string();
        }
    }

}
