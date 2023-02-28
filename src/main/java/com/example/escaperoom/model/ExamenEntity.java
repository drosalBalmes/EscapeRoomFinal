package com.example.escaperoom.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "examen", schema = "escaperoom", catalog = "")
public class ExamenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idExamen")
    private long idExamen;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @Basic
    @Column(name = "nota")
    private Double nota;
    @Basic
    @Column(name = "idAlumno")
    private Long idAlumno;
    @Basic
    @Column(name = "idModul")
    private Long idModul;
    @ManyToOne
    //@JoinColumn(name = "idModulo",referencedColumnName = "idModulo",nullable = false)
    private ModuloEntity moduls;

/*
    @OneToMany(mappedBy = "alumnos")
    private List<AlumnoEntity> examen;
*/
    public long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(long idExamen) {
        this.idExamen = idExamen;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
/*
    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }
*/
    public ModuloEntity getIdModul() {
        return moduls;
    }

    public void setIdModul(ModuloEntity idModul) {
        this.moduls = idModul;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamenEntity that = (ExamenEntity) o;

        if (idExamen != that.idExamen) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (nota != null ? !nota.equals(that.nota) : that.nota != null) return false;
        if (idAlumno != null ? !idAlumno.equals(that.idAlumno) : that.idAlumno != null) return false;
        if (moduls != null ? !moduls.equals(that.moduls) : that.moduls != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idExamen ^ (idExamen >>> 32));
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (nota != null ? nota.hashCode() : 0);
        result = 31 * result + (idAlumno != null ? idAlumno.hashCode() : 0);
        result = 31 * result + (moduls != null ? moduls.hashCode() : 0);
        return result;
    }
}
