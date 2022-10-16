package com.meicansoftware.consultamedica.pages.doctors.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.meicansoftware.consultamedica.R;
import com.meicansoftware.consultamedica.models.Doctor;
import com.meicansoftware.consultamedica.models.Speciality;

import java.util.List;

public class doctorAdapter extends BaseAdapter {
    private List<Doctor> doctors;
    private LayoutInflater mInflater;

    public doctorAdapter(Context context, List<Doctor> DoctorList){
        this.doctors = DoctorList;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return doctors.size();
    }

    public Doctor getItem(int i) {
        return doctors.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listDoctorsView = convertView;
        if (listDoctorsView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listDoctorsView = mInflater.inflate(R.layout.gridview_layout_doctors, null);
        }
        Doctor doctors = (Doctor) getItem(position);

        TextView txt_name = listDoctorsView.findViewById(R.id.txt_doctor_name);
        TextView txt_phone = listDoctorsView.findViewById(R.id.txt_doctor_phone);
        TextView txt_address = listDoctorsView.findViewById(R.id.txt_doctor_address);

        txt_name.setText(doctors.nome.toString());
        txt_phone.setText(doctors.telefone.toString());
        txt_address.setText(doctors.endereco.toString());

        return listDoctorsView;
    }


}
