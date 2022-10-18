package com.meicansoftware.consultamedica.pages.doctors.fragments;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.meicansoftware.consultamedica.R;
import com.meicansoftware.consultamedica.config.ContatoMedicoDatabase;
import com.meicansoftware.consultamedica.models.Doctor;
import com.meicansoftware.consultamedica.models.Speciality;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add_doctors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class add_doctors extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ContatoMedicoDatabase db;
    private int specialitySelected;


    public add_doctors() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static add_doctors newInstance() {
        add_doctors fragment = new add_doctors();
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
        return inflater.inflate(R.layout.fragment_add_doctors, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {


        db = ContatoMedicoDatabase.getDatabase(getActivity().getApplicationContext());

        Button btnAddNewSpeciality = getActivity().findViewById(R.id.btn_save_doctor);
        EditText edtNameDoctor = getActivity().findViewById(R.id.edt_doctor_name);
        EditText edtPhoneDoctor = getActivity().findViewById(R.id.edt_doctor_phone);
        EditText edtAddressDoctor = getActivity().findViewById(R.id.edt_doctor_address);

        Spinner spinner_especialidades = getActivity().findViewById(R.id.spinner_specialities);

        ArrayList<Speciality> specialitiesList = (ArrayList<Speciality>) db.specialityDao().getAll();

        ArrayAdapter<Speciality> adapter = new ArrayAdapter<Speciality>(getActivity(), android.R.layout.simple_spinner_dropdown_item, specialitiesList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_especialidades.setAdapter(adapter);

        spinner_especialidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            specialitySelected = adapter.getItem(i).id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAddNewSpeciality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("e", String.valueOf(specialitySelected));

                String nameDoctor = edtNameDoctor.getText().toString();
                String phoneDoctor = edtPhoneDoctor.getText().toString();
                String addressDoctor = edtAddressDoctor.getText().toString();

                if ((!nameDoctor.equals("")) & (!phoneDoctor.equals("")) & (!addressDoctor.equals(""))) {
                    Doctor doctor = new Doctor(specialitySelected, nameDoctor, phoneDoctor, addressDoctor);

                    try {
                        db.doctorDao().insertAll(doctor);
                        Log.d("e", nameDoctor);
                        Toast.makeText(getActivity(), "Médico inserido com sucesso", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(add_doctors.this).navigate(R.id.action_add_doctors_to_page_doctors);
                    } catch (SQLiteConstraintException e) {
                        Toast.makeText(getActivity(), "Erro ao tentar adicionar um médico", Toast.LENGTH_SHORT).show();
                        Log.d("e", e.toString());
                    }
                }else{
                    Toast.makeText(getActivity(), "Verifique se todos os campos foram preenchidos", Toast.LENGTH_LONG);
                }
            }
        });

    }


}