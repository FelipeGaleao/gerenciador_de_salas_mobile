package com.meicansoftware.consultamedica.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Specialities")
public class Specialty {
    @PrimaryKey
    public int id;

    @ColumnInfo(name= "descricao")
    public String descricao;

}