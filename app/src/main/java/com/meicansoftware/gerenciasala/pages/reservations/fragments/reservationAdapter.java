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
        TextView txt_sala = listView.findViewById(R.id.txt_nome_sala);
        TextView txt_nome_responsavel = listView.findViewById(R.id.txt_responsavel_agendamento);
        TextView txt_course_event = listView.findViewById(R.id.txt_course_event);
        JSONObject courseObject = null;
        JSONObject userObject = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-ddThh:MM:ss");
            String dateAsString = "25/12/2010";
            try {
                Date date = sourceFormat.parse(dateAsString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        try {
            courseObject = reservation_object.getJSONObject("course");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject eventObject = null;
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

            txt_hora_inicio.setText(reservation_object.getString("hr_inicio_evento"));
            txt_hora_fim.setText(reservation_object.getString("hr_fim_evento"));
            txt_date_inicio.setText(reservation_object.getString("dt_inicio"));
            txt_date_fim.setText(reservation_object.getString("dt_fim"));
            txt_nome_responsavel.setText(userObject.getString("nome") + " " + userObject.getString("sobrenome"));

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
