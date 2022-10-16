package com.meicansoftware.consultamedica.pages.specialities.fragments;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;
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
import com.meicansoftware.consultamedica.models.Doctor;
import com.meicansoftware.consultamedica.models.Speciality;
import com.meicansoftware.consultamedica.pages.doctors.fragments.edit_doctors;
import com.meicansoftware.consultamedica.pages.specialities.Specialities;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add_specialities#newInstance} factory method to
 * create an instance of this fragment.
 */
public class edit_specialities extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ContatoMedicoDatabase db;



    public edit_specialities() {
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
        return inflater.inflate(R.layout.fragment_edit_speciality, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {


        db = ContatoMedicoDatabase.getDatabase(getActivity().getApplicationContext());

        Button btnSaveSpeciality = getActivity().findViewById(R.id.btn_save_speciality);
        Button btnDeleteSpeciality = getActivity().findViewById(R.id.btn_delete_speciality);
        EditText edtSpeciality = getActivity().findViewById(R.id.name_speciality);

        edtSpeciality.setText(getArguments().getString("speciality_description"));

        btnSaveSpeciality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtSpeciality.getText().toString() != "") {
                    Speciality speciality = new Speciality();
                    speciality.descricao = edtSpeciality.getText().toString();
                    speciality.id = getArguments().getInt("speciality_id");

                    try {
                        db.specialityDao().updateSpeciality(speciality);
                        Toast.makeText(getActivity(), "Especialidade inserida com sucesso", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(edit_specialities.this).navigate(R.id.action_edit_specialities_to_home_specialities);
                    } catch (SQLiteConstraintException e) {
                        Toast.makeText(getActivity(), "Erro ao tentar adicionar a modalidade", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Verifique se todos os campos foram preenchidos", Toast.LENGTH_LONG);
                }
            }
        });

        btnDeleteSpeciality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Speciality speciality = new Speciality();
                speciality.id = getArguments().getInt("speciality_id");
                speciality.descricao = getArguments().getString("speciality_description");

                try {
                    db.specialityDao().deleteSpeciality(speciality);
                    Toast.makeText(getActivity(), "Especialidade deletada com sucesso", Toast.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(edit_specialities.this).navigate(R.id.action_edit_specialities_to_home_specialities);
                } catch (SQLiteConstraintException e) {
                    Toast.makeText(getActivity(), "Erro ao tentar deletar uma especialidade", Toast.LENGTH_SHORT).show();
                    Log.d("e", e.toString());
                }
            }
        });

    }


}