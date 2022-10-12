package com.meicansoftware.consultamedica.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.meicansoftware.consultamedica.models.Doctor;
import com.meicansoftware.consultamedica.models.Specialty;

@Database(entities = {Doctor.class, Specialty.class}, version = 1)
public abstract class ContatoMedicoDatabase extends RoomDatabase {

}