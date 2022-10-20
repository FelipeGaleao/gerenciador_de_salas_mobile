package com.meicansoftware.consultamedica.pages.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.meicansoftware.consultamedica.R;
import com.meicansoftware.consultamedica.config.ContatoMedicoDatabase;
import com.meicansoftware.consultamedica.models.Speciality;
import com.meicansoftware.consultamedica.pages.specialities.fragments.specialities;
import com.meicansoftware.consultamedica.pages.specialities.fragments.specialityAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Homepage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Homepage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String txtSearchInput;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ContatoMedicoDatabase db;
    private List<Speciality> specialitiesList;


    public Homepage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Homepage.
     */
    // TODO: Rename and change types and number of parameters
    public static Homepage newInstance(String param1, String param2) {
        Homepage fragment = new Homepage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        db = ContatoMedicoDatabase.getDatabase(getActivity());


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
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        TextView edt_search_speciality = getActivity().findViewById(R.id.edt_search_speciality);
        txtSearchInput = edt_search_speciality.getText().toString();
        fillSpecialities("");
        edt_search_speciality.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                fillSpecialities(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void fillSpecialities(String specialityName){

        GridView gridSpecialities = getActivity().findViewById(R.id.gridview_home_specialities);
        if(specialityName == "") {
           specialitiesList = db.specialityDao().getAll();
        }else{
           specialitiesList = db.specialityDao().loadBySpecialityDescription(specialityName);

        }
        specialityAdapter adapter = new specialityAdapter(getActivity(), specialitiesList);

        gridSpecialities.setAdapter(adapter);


        gridSpecialities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int cod_medico = adapter.getItem(i).id;

                Speciality speciality_selected = adapter.getItem(i);

                Bundle b = new Bundle();

                b.putInt("speciality_id", speciality_selected.id);
                b.putString("speciality_description", speciality_selected.descricao);

                NavHostFragment.findNavController(Homepage.this).navigate(R.id.action_homepage2_to_doctors, b);

            }
        });


    }
}