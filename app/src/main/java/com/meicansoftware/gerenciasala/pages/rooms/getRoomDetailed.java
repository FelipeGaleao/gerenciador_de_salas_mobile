package com.meicansoftware.gerenciasala.pages.rooms;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.meicansoftware.gerenciasala.R;
import com.meicansoftware.gerenciasala.services.RoomService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link getRoomDetailed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class getRoomDetailed extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public getRoomDetailed() {
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
    public static getRoomDetailed newInstance(String param1, String param2) {
        getRoomDetailed fragment = new getRoomDetailed();
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
        return inflater.inflate(R.layout.fragment_get_room_detailed, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        String arg_nome_sala = getArguments().getString("nome_sala");
        String arg_observacao = getArguments().getString("observacao");
        String arg_lotacao = getArguments().getString("lotacao");
        String arg_agendavel = getArguments().getString("arg_agendavel");
        String id_sala = getArguments().getString("id_sala");

        TextView txt_name = view.findViewById(R.id.txt_id_sala);
        TextView txt_observacao = view.findViewById(R.id.txt_observacao);
        TextView txt_lotacao = view.findViewById(R.id.txt_lotacao);
        TextView txt_nm_sala = view.findViewById(R.id.txt_id_sala);
        TextView txt_agendavel = view.findViewById(R.id.txt_agendavel);
        TextView txt_nm_sala2 = view.findViewById(R.id.txt_nm_sala);

        Button btn_delete_room = view.findViewById(R.id.btn_delete_room);

        txt_name.setText("Você está visualizando a: " + arg_nome_sala + " " + id_sala);

        txt_observacao.setText("Observação: " + arg_observacao);
        txt_lotacao.setText("Lotação: " + arg_lotacao);
        txt_nm_sala.setText(arg_nome_sala);
        txt_agendavel.setText(arg_agendavel);
        txt_nm_sala2.setText(arg_nome_sala);

        btn_delete_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                RoomService roomService = new RoomService();
                try {
                    String delete_msg = roomService.delete_room(id_sala);
                    Log.d("e", "deletar sala: " + id_sala);
                    Log.d("e", delete_msg);
                    Toast.makeText(getActivity(), "Sala excluída com sucesso!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    Toast.makeText(getActivity(), "Erro ao excluir sala!", Toast.LENGTH_SHORT).show();
                }
                Log.d("e", "voce clicou no botao!!!");
            }
        });
    }

}