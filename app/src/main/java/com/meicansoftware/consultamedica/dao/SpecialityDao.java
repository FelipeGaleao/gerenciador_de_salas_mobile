package com.meicansoftware.consultamedica.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.meicansoftware.consultamedica.models.Doctor;
import com.meicansoftware.consultamedica.models.Speciality;

import java.util.List;

@Dao
public interface SpecialityDao {

    @Insert
    void insertAll(Speciality specialty);

    @Query("SELECT * FROM Specialities")
    List<Speciality> getAll();

    @Update
    public void updateSpeciality(Speciality speciality);

    @Query("SELECT * FROM Specialities WHERE descricao LIKE  '%' || :specialityName ||  '%'")
    List<Speciality> loadBySpecialityDescription(String specialityName);

    @Delete
    public void deleteSpeciality(Speciality speciality);

}
