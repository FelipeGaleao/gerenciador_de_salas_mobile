package com.meicansoftware.consultamedica.pages.specialities.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.meicansoftware.consultamedica.R;
import com.meicansoftware.consultamedica.models.Speciality;

import java.util.List;

public class specialityAdapter extends BaseAdapter {
    private List<Speciality> specialities;
    private LayoutInflater mInflater;

    public specialityAdapter(Context context, List<Speciality> SpecialityList){
        this.specialities = SpecialityList;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return specialities.size();
    }

    public Speciality getItem(int i) {
        return specialities.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listSpecialitiesView = convertView;
        if (listSpecialitiesView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listSpecialitiesView = mInflater.inflate(R.layout.gridview_layout_specialities, null);
        }
        Speciality specialities = (Speciality) getItem(position);
        TextView speciality_description = listSpecialitiesView.findViewById(R.id.txt_des_speciality);
        speciality_description.setText(specialities.descricao.toString());
        return listSpecialitiesView;
    }


}
