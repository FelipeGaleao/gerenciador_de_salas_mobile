package com.meicansoftware.consultamedica.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.meicansoftware.consultamedica.models.Doctor;

@Database(entities = {Doctor.class}, version = 1)
public abstract class ContatoMedicoDatabase extends RoomDatabase {
//    public abstract UserDao userDao();
}