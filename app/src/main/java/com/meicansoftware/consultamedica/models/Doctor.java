package com.meicansoftware.consultamedica.models;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctors", foreignKeys = @ForeignKey(entity = Speciality.class, parentColumns = "id", childColumns = "idEspecialidade", onDelete = CASCADE))
public class Doctor {
    public Doctor(int idEspecialidade, String nome, String telefone, String endereco) {
        this.idEspecialidade = idEspecialidade;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "idEspecialidade")
    public int idEspecialidade;

    @ColumnInfo(name= "nome")
    public String nome;

    @ColumnInfo(name= "telefone")
    public String telefone;

    @ColumnInfo(name= "endereco")
    public String endereco;

    public Doctor() {

    }
}