package com.meicansoftware.gerenciasala.services;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ReservationService {

  final OkHttpClient client = new OkHttpClient();
  String access_token = null;

  public ReservationService() {
  }

  public ReservationService(String access_token) {
    this.access_token = access_token;
  }


  public String getReservations() throws IOException {
    Request request = new Request.Builder()
      .url("https://gerencia-sala-backend.azurewebsites.net/api/reservation/?limit=20&offset=0")
      .build();

    try (Response response = client.newCall(request).execute()) {
      Log.d("response_res_service", response.toString());
      return response.body().string();
    }
  }
}
