package com.example.escaperoom.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "modulo", schema = "escaperoom", catalog = "")
public class ModuloEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idModulo")
    private long idModulo;
    @Basic
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy="moduls")
    private List<ExamenEntity> examenes;

/*    @ManyToMany(mappedBy = "modulos")
    @JoinTable(
            name = "docencia",
            joinColumns = {@JoinColumn (name = "IdModulo")},
            inverseJoinColumns = {@JoinColumn(name = "idProfesor")}
    )
    private List<ProfesorEntity> profesores;
*/
    public long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(long idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ExamenEntity> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<ExamenEntity> examenes) {
        this.examenes = examenes;
    }
/*
    public List<ProfesorEntity> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<ProfesorEntity> profesores) {
        this.profesores = profesores;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuloEntity that = (ModuloEntity) o;

        if (idModulo != that.idModulo) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idModulo ^ (idModulo >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
