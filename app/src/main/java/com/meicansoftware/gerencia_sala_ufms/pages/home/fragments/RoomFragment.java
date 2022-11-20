package com.meicansoftware.gerencia_sala_ufms.pages.home.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.meicansoftware.gerencia_sala_ufms.R;
import com.meicansoftware.gerencia_sala_ufms.pages.home.fragments.placeholder.PlaceholderContent;
import com.meicansoftware.gerencia_sala_ufms.services.RoomService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * A fragment representing a list of Items.
 */
public class RoomFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RoomFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RoomFragment newInstance(int columnCount) {
        RoomFragment fragment = new RoomFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String rooms = null;
        JSONObject obj = new JSONObject();
        JSONArray jsonArray = null;

        RoomService roomService = new RoomService();
        try {
            rooms = roomService.get_rooms();
        } catch (IOException e) {
            rooms = "Nenhum";
            e.printStackTrace();
        }

        try {
            jsonArray = new JSONArray(rooms);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            obj = jsonArray.getJSONObject(0);
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<PlaceholderContent.PlaceholderItem> items = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                items.add(new PlaceholderContent.PlaceholderItem(jsonObject.getString("id"), jsonObject.getString("nome_sala") + ": " + jsonObject.getString("observacao") , "teste"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // create adapter and set it to the recycler view
        RoomAdapter adapter = new RoomAdapter(items);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(adapter);
        }
    }
}