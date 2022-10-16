package com.meicansoftware.consultamedica.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.meicansoftware.consultamedica.dao.DoctorDao;
import com.meicansoftware.consultamedica.dao.SpecialityDao;
import com.meicansoftware.consultamedica.models.Doctor;
import com.meicansoftware.consultamedica.models.Speciality;

@Database(entities = {Doctor.class, Speciality.class}, version = 1)
public abstract class ContatoMedicoDatabase extends RoomDatabase {
    private static ContatoMedicoDatabase INSTANCE;

    public static ContatoMedicoDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    ContatoMedicoDatabase.class,
                    "ControleDeUsuarios").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public abstract SpecialityDao specialityDao();
    public abstract DoctorDao doctorDao();

}