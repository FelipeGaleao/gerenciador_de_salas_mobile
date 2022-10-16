package com.meicansoftware.consultamedica.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.meicansoftware.consultamedica.models.Doctor;

import java.util.List;

@Dao
public interface DoctorDao {

    @Insert
    void insertAll(Doctor doctor);

    @Query("SELECT * FROM Doctors")
    List<Doctor> getAll();
}
