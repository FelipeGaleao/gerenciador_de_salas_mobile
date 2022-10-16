package com.meicansoftware.consultamedica.pages.specialities.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.meicansoftware.consultamedica.R;
import com.meicansoftware.consultamedica.config.ContatoMedicoDatabase;
import com.meicansoftware.consultamedica.models.Speciality;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link specialities#newInstance} factory method to
 * create an instance of this fragment.
 */
public class specialities extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ContatoMedicoDatabase db;

    public specialities() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static specialities newInstance() {
        specialities fragment = new specialities();
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


        return inflater.inflate(R.layout.fragment_specialities, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        Button btnAddNewSpeciality = getActivity().findViewById(R.id.btn_new_speciality);
        fillSpecialities();

        btnAddNewSpeciality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                NavHostFragment.findNavController(specialities.this).navigate(R.id.action_home_specialities_to_add_specialities);
            }
        });
    }

    private void fillSpecialities(){

        GridView gridSpecialities = getActivity().findViewById(R.id.gridview_specialities);

        List<Speciality> specialitiesList = db.specialityDao().getAll();

        specialityAdapter adapter = new specialityAdapter(getActivity(), specialitiesList);

        gridSpecialities.setAdapter(adapter);



    }


}