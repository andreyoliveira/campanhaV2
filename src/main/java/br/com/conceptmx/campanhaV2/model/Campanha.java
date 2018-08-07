package br.com.conceptmx.campanhaV2.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class Campanha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JoinColumn(name = "idTime")
    @ManyToOne(targetEntity = Time.class, fetch = FetchType.EAGER)
    private Time time;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar vigenciaInicial;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar vigenciaFinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Calendar getVigenciaInicial() {
        return vigenciaInicial;
    }

    public void setVigenciaInicial(Calendar vigenciaInicial) {
        this.vigenciaInicial = vigenciaInicial;
    }

    public Calendar getVigenciaFinal() {
        return vigenciaFinal;
    }

    public void setVigenciaFinal(Calendar vigenciaFinal) {
        this.vigenciaFinal = vigenciaFinal;
    }

}
