package com.meicansoftware.gerenciasala.pages.home.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import com.meicansoftware.gerenciasala.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class roomAdapter extends BaseAdapter {
    private JSONArray rooms;
    private LayoutInflater mInflater;

    public roomAdapter(Context context, JSONArray rooms){
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
        View listRoomsView = convertView;
        if (listRoomsView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listRoomsView = mInflater.inflate(R.layout.gridview_layout_rooms, null);
        }
         JSONObject room_object = getItem(position);

        TextView txt_name = listRoomsView.findViewById(R.id.txt_nome_sala);
        TextView txt_obs = listRoomsView.findViewById(R.id.txt_obs_sala);

        try{
            txt_name.setText(room_object.getString("nome_sala"));
            txt_obs.setText(room_object.getString("observacao"));
            Log.d("e", room_object.getString("nome_sala"));
        }catch(Exception e){
            Log.d("e", e.getMessage());
        }

        return listRoomsView;
    }


}
