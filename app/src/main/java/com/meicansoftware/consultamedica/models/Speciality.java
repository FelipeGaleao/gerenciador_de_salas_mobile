package com.meicansoftware.consultamedica.models;

import android.widget.EditText;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Specialities")
public class Speciality {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name= "descricao")
    public String descricao;

    public Speciality(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public Speciality() {
        this.descricao = descricao;
    }
}