package com.meicansoftware.consultamedica.pages.specialities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.meicansoftware.consultamedica.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add_specialities#newInstance} factory method to
 * create an instance of this fragment.
 */
public class add_specialities extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


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

        Button btnAddNewSpeciality = getActivity().findViewById(R.id.btn_new_speciality);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_speciality, container, false);
    }


}