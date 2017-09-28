package com.example.eduac.examenandroideduardoalbano;

/**
 * Created by EduAC on 28/09/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;



public class Contacto implements Parcelable {
    private String nombre;
    private String email;
    private Integer edad;

    public Contacto(String nombre, String email, Integer edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;

        Contacto contacto = (Contacto) o;

        if (getNombre() != null ? !getNombre().equals(contacto.getNombre()) : contacto.getNombre() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(contacto.getEmail()) : contacto.getEmail() != null)
            return false;
        return getEdad() != null ? getEdad().equals(contacto.getEdad()) : contacto.getEdad() == null;

    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getEdad() != null ? getEdad().hashCode() : 0);
        return result;
    }

    protected Contacto(Parcel in) {
        nombre = in.readString();
        email = in.readString();
        edad = in.readInt();
    }

    public static final Parcelable.Creator<Contacto> CREATOR = new Parcelable.Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(email);
        parcel.writeInt(edad);
    }
}
