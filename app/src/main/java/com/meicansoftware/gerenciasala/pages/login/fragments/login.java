package com.meicansoftware.gerenciasala.pages.login.fragments;

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
import com.meicansoftware.gerenciasala.services.LoginService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add_doctors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class login extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private int specialitySelected;


    // TODO: Rename and change types and number of parameters
    public static login newInstance() {
        login fragment = new login();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        AppCompatButton btnLogin = getActivity().findViewById(R.id.btn_login);
        EditText edtEmail = getActivity().findViewById(R.id.edt_email_login);
        EditText edtPassword = getActivity().findViewById(R.id.edt_password_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                if (email.equals("")) {
                    Toast.makeText(getActivity(), "O campo Email não pode ser vazio!", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(getActivity(), "O campo Senha não pode ser vazio!", Toast.LENGTH_SHORT).show();
                } else {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    LoginService loginService = new LoginService();
                    String result = loginService.login(email, password);

                    if (result.equals("{\"message\":\"Usuário não encontrado!\"}")) {
                        Toast.makeText(getActivity(), "Email ou senha estão incorretos!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getActivity(), "Login feito!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

}