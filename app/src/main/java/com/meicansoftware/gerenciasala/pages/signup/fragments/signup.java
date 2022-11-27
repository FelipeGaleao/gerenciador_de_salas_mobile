package com.meicansoftware.gerenciasala.pages.signup.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import com.meicansoftware.gerenciasala.R;
import com.meicansoftware.gerenciasala.pages.home.Home;
import com.meicansoftware.gerenciasala.pages.login.Login;
import com.meicansoftware.gerenciasala.services.LoginService;
import com.meicansoftware.gerenciasala.services.SignUpService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add_doctors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class signup extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private int specialitySelected;


    // TODO: Rename and change types and number of parameters
    public static signup newInstance() {
        return new signup();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        AppCompatButton btnAddNewUser = getActivity().findViewById(R.id.btn_add_user);
        EditText edtName = getActivity().findViewById(R.id.edt_first_name);
        EditText edtSirName = getActivity().findViewById(R.id.edt_sir_name);
        EditText edtEmail = getActivity().findViewById(R.id.edt_email);
        EditText edtPassword = getActivity().findViewById(R.id.edt_password);
        EditText edtCapacity = getActivity().findViewById(R.id.edt_capacity);

        btnAddNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtName.getText().toString();
                String sirName = edtSirName.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String capacity = edtCapacity.getText().toString();

                if (name.equals("")) {
                    Toast.makeText(getActivity(), "O campo Nome não pode ser vazio!", Toast.LENGTH_SHORT).show();
                } else if (sirName.equals("")) {
                    Toast.makeText(getActivity(), "O campo Sobrenome não pode ser vazio!", Toast.LENGTH_SHORT).show();
                } else if (email.equals("")) {
                    Toast.makeText(getActivity(), "O campo Email não pode ser vazio!", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(getActivity(), "O campo Senha não pode ser vazio!", Toast.LENGTH_SHORT).show();
                } else if (capacity.equals("")) {
                    Toast.makeText(getActivity(), "O campo Lotação não pode ser vazio!", Toast.LENGTH_SHORT).show();
                } else {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    SignUpService signUpService = new SignUpService();
                    String result = signUpService.signUp(name, sirName, email, password, capacity);
                    Log.d("Teste", result);

                    if (result.equals("{\"message\":\"Usuário não encontrado!\"}")) {
                        Toast.makeText(getActivity(), "Email ou senha estão incorretos!", Toast.LENGTH_LONG).show();
                    }
                    else if(result.equals("{\"message\":\"Usuário já cadastrado!\"}")){
                        Toast.makeText(getActivity(), "Email já cadastrado!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getActivity(), "Cadastro feito!", Toast.LENGTH_LONG).show();
                        Intent intentToRedirect = new Intent(getActivity().getApplicationContext(), Login.class);
                        startActivity(intentToRedirect);
                    }
                }

            }
        });
    }


}