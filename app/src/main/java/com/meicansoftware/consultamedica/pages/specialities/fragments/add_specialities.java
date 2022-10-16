package com.meicansoftware.consultamedica.pages.specialities.fragments;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import com.meicansoftware.consultamedica.R;
import com.meicansoftware.consultamedica.config.ContatoMedicoDatabase;
import com.meicansoftware.consultamedica.models.Speciality;
import com.meicansoftware.consultamedica.pages.specialities.Specialities;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add_specialities#newInstance} factory method to
 * create an instance of this fragment.
 */
public class add_specialities extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ContatoMedicoDatabase db;



    public add_specialities() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static add_specialities newInstance() {
        add_specialities fragment = new add_specialities();
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
        return inflater.inflate(R.layout.fragment_add_speciality, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {


        db = ContatoMedicoDatabase.getDatabase(getActivity().getApplicationContext());

        Button btnAddNewSpeciality = getActivity().findViewById(R.id.btn_save_speciality);
        EditText edtSpeciality = getActivity().findViewById(R.id.name_speciality);

        btnAddNewSpeciality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtSpeciality.getText().toString() != "") {
                    Speciality speciality = new Speciality();
                    speciality.descricao = edtSpeciality.getText().toString();
                    try {
                        db.specialityDao().insertAll(speciality);
                        Toast.makeText(getActivity(), "Especialidade inserida com sucesso", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(add_specialities.this).navigate(R.id.action_add_specialities_to_home_specialities);
                    } catch (SQLiteConstraintException e) {
                        Toast.makeText(getActivity(), "Erro ao tentar adicionar a modalidade", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Verifique se todos os campos foram preenchidos", Toast.LENGTH_LONG);
                }
            }
        });

    }


}