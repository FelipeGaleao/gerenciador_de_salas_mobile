package com.meicansoftware.consultamedica.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.meicansoftware.consultamedica.models.Doctor;

import java.util.List;

@Dao
public interface DoctorDao {

    @Update
    public void updateDoctors(Doctor doctor);

    @Insert
    void insertAll(Doctor doctor);

    @Query("SELECT * FROM Doctors")
    List<Doctor> getAll();

    @Query("SELECT * FROM Doctors WHERE id = :doctorsId")
    List<Doctor> loadAllById(int doctorsId);
}
