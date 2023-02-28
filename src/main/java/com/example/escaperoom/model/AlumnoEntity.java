package com.example.escaperoom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alumno", schema = "escaperoom", catalog = "")
public class AlumnoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAlumno")
    private long idAlumno;
    @Basic
    @Column(name = "apellidos")
    private String apellidos;
    @Basic
    @Column(name = "edad")
    private Integer edad;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "repetidor")
    private Boolean repetidor;

    /*
    @ManyToOne
    @JoinColumn(name = "idAlumno",referencedColumnName = "idAlumno",nullable = false)
    private ExamenEntity alumnos;
*/
    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getRepetidor() {
        return repetidor;
    }

    public void setRepetidor(Boolean repetidor) {
        this.repetidor = repetidor;
    }
/*
    public ExamenEntity getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ExamenEntity alumnos) {
        this.alumnos = alumnos;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlumnoEntity that = (AlumnoEntity) o;

        if (idAlumno != that.idAlumno) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (edad != null ? !edad.equals(that.edad) : that.edad != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (repetidor != null ? !repetidor.equals(that.repetidor) : that.repetidor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAlumno ^ (idAlumno >>> 32));
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (edad != null ? edad.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (repetidor != null ? repetidor.hashCode() : 0);
        return result;
    }
}
