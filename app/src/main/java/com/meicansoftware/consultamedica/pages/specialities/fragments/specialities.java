package com.meicansoftware.consultamedica.pages.specialities.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.meicansoftware.consultamedica.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link specialities#newInstance} factory method to
 * create an instance of this fragment.
 */
public class specialities extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_specialities, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        Button btnAddNewSpeciality = getActivity().findViewById(R.id.btn_new_speciality);

        btnAddNewSpeciality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                NavHostFragment.findNavController(specialities.this).navigate(R.id.action_home_specialities_to_add_specialities);
            }
        });
    }

}