package com.meicansoftware.gerenciasala.pages.home.fragments;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.meicansoftware.gerenciasala.R;
import com.meicansoftware.gerenciasala.services.RoomService;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add_doctors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private int specialitySelected;


    // TODO: Rename and change types and number of parameters
    public static home newInstance() {
        home fragment = new home();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        fillRooms();

    }

    private void fillRooms(){
        GridView gridRooms = getActivity().findViewById(R.id.gridview_home_rooms);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String strRooms = null;
        RoomService roomService = new RoomService();
        JSONArray jsonArray = null;
        JSONObject obj = null;
        try {
            strRooms = roomService.get_rooms();
            System.out.println(strRooms);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            jsonArray = new JSONArray(strRooms);
        }catch(Exception e){
            Log.e("Error", e.getMessage());
        }

        try{
           obj = jsonArray.getJSONObject(0);
           Log.d("e", obj.getString("id"));
        }catch(Exception e){
            Log.e("Error", "Ocorreu um erro!");
        }

        roomAdapter adapter = new roomAdapter(getActivity(), jsonArray);
        gridRooms.setAdapter(adapter);
        
        
    }
}