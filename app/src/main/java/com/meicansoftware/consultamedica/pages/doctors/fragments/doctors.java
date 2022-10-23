package com.meicansoftware.consultamedica.pages.doctors.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.meicansoftware.consultamedica.R;
import com.meicansoftware.consultamedica.config.ContatoMedicoDatabase;
import com.meicansoftware.consultamedica.models.Doctor;
import com.meicansoftware.consultamedica.models.Speciality;
import com.meicansoftware.consultamedica.pages.specialities.fragments.specialities;
import com.meicansoftware.consultamedica.pages.specialities.fragments.specialityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link doctors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class doctors extends Fragment {

    private ContatoMedicoDatabase db;
    private int specialityId = 0;
    private List<Doctor> doctorsList;
    private String txtSearchSpeciality;

    public doctors() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment doctors.
     */
    // TODO: Rename and change types and number of parameters
    public static doctors newInstance(String param1, String param2) {
        doctors fragment = new doctors();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = ContatoMedicoDatabase.getDatabase(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctors, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        Button btnAddNewDoctor = getActivity().findViewById(R.id.btn_new_doctor);
        try {
            specialityId = getArguments().getInt("speciality_id");
            fillDoctors(specialityId);
        }catch(Exception e){
            fillDoctors(0);
        }
        btnAddNewDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                NavHostFragment.findNavController(doctors.this).navigate(R.id.action_page_doctors_to_add_doctors);
            }
        });
    }

    private void fillDoctors(int specialityId){

        GridView gridDoctors = getActivity().findViewById(R.id.gridview_doctors);
        if(specialityId == 0) {
            doctorsList = db.doctorDao().getAll();
        }else{
            doctorsList = db.doctorDao().loadAllBySpeciality(specialityId);
        }
        doctorAdapter adapter = new doctorAdapter(getActivity(), doctorsList);

        gridDoctors.setAdapter(adapter);

        gridDoctors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Doctor doctor_selected = adapter.getItem(i);

                Bundle b = new Bundle();

                b.putInt("doctor_id", doctor_selected.getId());
                b.putString("doctor_name", doctor_selected.getNome());
                b.putString("doctor_address", doctor_selected.getEndereco());
                b.putString("doctor_phone", doctor_selected.getTelefone());
                b.putInt("doctor_speciality_id", doctor_selected.getId());

                NavHostFragment.findNavController(doctors.this).navigate(R.id.action_page_doctors_to_edit_doctors, b);

            }
        });
    }

}