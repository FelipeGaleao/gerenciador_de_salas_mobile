package com.meicansoftware.consultamedica.pages.doctors.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.meicansoftware.consultamedica.R;
import com.meicansoftware.consultamedica.config.ContatoMedicoDatabase;
import com.meicansoftware.consultamedica.models.Doctor;
import com.meicansoftware.consultamedica.models.Speciality;
import com.meicansoftware.consultamedica.pages.specialities.fragments.specialities;
import com.meicansoftware.consultamedica.pages.specialities.fragments.specialityAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link doctors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class doctors extends Fragment {

    private ContatoMedicoDatabase db;

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
        fillDoctors();

        btnAddNewDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                NavHostFragment.findNavController(doctors.this).navigate(R.id.action_page_doctors_to_add_doctors);
            }
        });
    }

    private void fillDoctors(){

        GridView gridDoctors = getActivity().findViewById(R.id.gridview_doctors);

        List<Doctor> doctorsList = db.doctorDao().getAll();

        doctorAdapter adapter = new doctorAdapter(getActivity(), doctorsList);

        gridDoctors.setAdapter(adapter);

    }

}