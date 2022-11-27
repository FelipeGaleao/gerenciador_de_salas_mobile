package com.meicansoftware.gerenciasala.pages.reservations.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import com.meicansoftware.gerenciasala.R;
import com.meicansoftware.gerenciasala.pages.home.fragments.roomAdapter;
import com.meicansoftware.gerenciasala.services.LoginService;
import com.meicansoftware.gerenciasala.services.ReservationService;
import com.meicansoftware.gerenciasala.services.RoomService;
import com.meicansoftware.gerenciasala.services.SignUpService;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add_doctors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class reservations extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private int specialitySelected;


    // TODO: Rename and change types and number of parameters
    public static reservations newInstance() {
        return new reservations();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservations, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        SharedPreferences userDetailsPreferences = this.getActivity().getSharedPreferences("users_detail", Context.MODE_PRIVATE);
        String nomeUsuarioLogado = userDetailsPreferences.getString("nome", "");
        String idUsuarioLogado = userDetailsPreferences.getString("id", "");
        String sobrenomeUsuarioLogado = userDetailsPreferences.getString("sobrenome", "");

        fillReservations();

    }

    public void fillReservations(){

        GridView gridReservations = getActivity().findViewById(R.id.gridlayout_reservations_getAll);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String strReservations = null;

        ReservationService reservationService = new ReservationService();
        JSONArray jsonArray = null;
        JSONObject obj = null;

        try {
            strReservations = reservationService.getReservations();
            Log.d("strReservations", strReservations);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            jsonArray = new JSONArray(strReservations);
        }catch(Exception e){
            Log.e("Error", e.getMessage());
        }

        try{
            obj = jsonArray.getJSONObject(0);
            Log.d("e", obj.toString());
        }catch(Exception e){
            Log.e("Error", "Ocorreu um erro!");
        }

        reservationAdapter adapter = new reservationAdapter(getActivity(), jsonArray);
        gridReservations.setAdapter(adapter);


    }

}