package com.meicansoftware.gerenciasala.services;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;
import java.io.IOException;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public class RoomService {

  final OkHttpClient client = new OkHttpClient();
  String access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2Njk0ODgzNjgsInN1YiI6Im1heWNvbi5tb3RhQHVmbXMuYnIifQ.2ITPdH87QOuhKVNTYX5s9Ihut0KKqepgAP_b3Hksils";
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
      .url(
        "https://gerencia-sala-backend.azurewebsites.net/api/rooms/delete_room_by_id?room_id=" +
        id
      )
      .header(
        "Authorization",
        "Bearer " +
                access_token
      )
      .delete()
      .build();

    try (Response response = client.newCall(request).execute()) {
      Log.d("e", "executando delete request");
      return response.body().string();
    }
  }

  // call update endpoint and send JSON body and JWT token

  public String update_room(
    String id,
    String name,
    String capacity,
    Boolean agendavel,
    String observacao
  ) throws IOException {
    JSONObject obj = new JSONObject();
    try {
      obj.put("room_id", id);
      obj.put("nome_sala", name);
      obj.put("lotacao", capacity);
      obj.put("agendavel", agendavel);
      obj.put("observacao", observacao);
    } catch (Exception e) {
      Log.d("update_room_request", e.getMessage());
    }
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    RequestBody body = RequestBody.create(JSON, obj.toString());

    Request request = new Request.Builder()
      .url("https://gerencia-sala-backend.azurewebsites.net/api/rooms/")
      .header(
        "Authorization",
        "Bearer " + access_token
      )
      .header("Content-Type", "application/json")
      .put(body)
      .build();

    try (Response response = client.newCall(request).execute()) {
      Log.d("e", "executando update request");
      return response.body().string();
    }
  }


  // call create endpoint and send JSON body and JWT token
  public String create_room(
          String name,
          int capacity,
          Boolean agendavel,
          String observacao
  ) throws IOException {
    JSONObject obj = new JSONObject();
    try {
      obj.put("nome_sala", name);
      obj.put("lotacao", capacity);
      obj.put("agendavel", agendavel);
      obj.put("observacao", observacao);
    } catch (Exception e) {
      Log.d("create_room_request", e.getMessage());
    }
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    RequestBody body = RequestBody.create(JSON, obj.toString());

    Request request = new Request.Builder()
      .url("https://gerencia-sala-backend.azurewebsites.net/api/rooms/")
      .header(
        "Authorization",
        "Bearer " + access_token
      )
      .header("Content-Type", "application/json")
      .post(body)
      .build();

    try (Response response = client.newCall(request).execute()) {
      Log.d("e", "executando update request");
      return response.body().string();
    }
  }
}
