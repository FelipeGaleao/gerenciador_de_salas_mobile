package com.meicansoftware.gerenciasala.pages.reservations.fragments;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.meicansoftware.gerenciasala.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Date;

public class reservationAdapter extends BaseAdapter {
    private JSONArray rooms;
    private LayoutInflater mInflater;

    public reservationAdapter(Context context, JSONArray rooms){
        this.rooms = rooms;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return rooms.length();
    }

    public JSONObject getItem(int i) {
        try {
            return rooms.getJSONObject(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listView = mInflater.inflate(R.layout.gridview_layout_reservations, null);
        }
         JSONObject reservation_object = getItem(position);


        TextView txt_date_inicio = listView.findViewById(R.id.txt_data_inicio);
        TextView txt_date_fim = listView.findViewById(R.id.txt_data_fim);
        TextView txt_hora_inicio = listView.findViewById(R.id.txt_hora_inicio);
        TextView txt_hora_fim = listView.findViewById(R.id.txt_hora_fim);
        TextView txt_sala_de_aula = listView.findViewById(R.id.txt_sala_de_aula);
        TextView txt_nome_responsavel = listView.findViewById(R.id.txt_responsavel_agendamento);
        TextView txt_course_event = listView.findViewById(R.id.txt_course_event);
        JSONObject courseObject = null;
        JSONObject userObject = null;
        JSONObject roomObject = null;
        JSONObject eventObject = null;


        try {
            courseObject = reservation_object.getJSONObject("course");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            eventObject = reservation_object.getJSONObject("event");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            userObject = reservation_object.getJSONObject("user");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try{
            roomObject = reservation_object.getJSONObject("room");
        }catch(JSONException e){
            e.printStackTrace();
        }

        try{

            txt_hora_inicio.setText(reservation_object.getString("hr_inicio_evento"));
            txt_hora_fim.setText(reservation_object.getString("hr_fim_evento"));
            txt_date_inicio.setText(reservation_object.getString("dt_inicio"));
            txt_date_fim.setText(reservation_object.getString("dt_fim"));
            txt_nome_responsavel.setText(userObject.getString("nome") + " " + userObject.getString("sobrenome"));

            if(roomObject.length() > 0){
                txt_sala_de_aula.setText(roomObject.getString("nome_sala"));
            }

            if(courseObject.length() > 0){
                Log.d("courseObject", courseObject.toString());
                txt_course_event.setText("D: " + courseObject.getString("nome") + " (" + courseObject.getString("lotacao_faculdade") + ")");
                txt_date_inicio.setText(reservation_object.getString("dt_inicio"));
                txt_date_fim.setText(reservation_object.getString("dt_fim"));

            }
            else if(eventObject.length() > 0){
                txt_course_event.setText("E"  + eventObject.getString("nome") + " (" + eventObject.getString("lotacao_faculdade") + ")");

            }else{
                txt_course_event.setText("Sem título");
            }

        }catch(Exception e){
            Log.d("e", e.getMessage());
        }
        return listView;
    }


}
