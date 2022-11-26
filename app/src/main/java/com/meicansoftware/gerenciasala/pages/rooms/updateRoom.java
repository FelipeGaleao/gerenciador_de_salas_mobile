package com.meicansoftware.gerenciasala.pages.rooms;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.meicansoftware.gerenciasala.R;
import com.meicansoftware.gerenciasala.services.RoomService;

import org.w3c.dom.Text;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link updateRoom#newInstance} factory method to
 * create an instance of this fragment.
 */
public class updateRoom extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public updateRoom() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment getRoomDetailed.
     */
    // TODO: Rename and change types and number of parameters
    public static updateRoom newInstance(String param1, String param2) {
        updateRoom fragment = new updateRoom();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_room_detailed, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        String arg_nome_sala = getArguments().getString("nome_sala");
        String arg_observacao = getArguments().getString("observacao");
        String arg_lotacao = getArguments().getString("lotacao");
        String arg_agendavel = getArguments().getString("arg_agendavel");
        String id_sala = getArguments().getString("id_sala");

        Log.d("nome_sala", arg_nome_sala);

        ImageView btn_back_room = view.findViewById(R.id.btn_back_room);
        TextView txt_nome_sala = view.findViewById(R.id.txt_update_nome_sala);
        TextView txt_lotacao = view.findViewById(R.id.txt_update_lotacao);
        TextView txt_observacao = view.findViewById(R.id.txt_update_observacao);
        Switch switch_agendavel = view.findViewById(R.id.switch_agendavel);

        txt_nome_sala.setText(arg_nome_sala);
        txt_lotacao.setText(arg_lotacao);
        txt_observacao.setText(arg_observacao);
        switch_agendavel.setChecked(Boolean.parseBoolean(arg_agendavel));

        Button btn_update_room = view.findViewById(R.id.btn_update_room);

        btn_back_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                NavHostFragment.findNavController(updateRoom.this).navigate(R.id.action_updateRoom_to_page_home, b);
            }
        });


        btn_update_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomService roomService = new RoomService();
                try {
                    String response = roomService.update_room(id_sala, txt_nome_sala.getText().toString(), txt_lotacao.getText().toString(), false, txt_observacao.getText().toString());
                    Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    Log.d("response_update_room", response);
                    NavHostFragment.findNavController(updateRoom.this).navigate(R.id.action_updateRoom_to_page_home);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}