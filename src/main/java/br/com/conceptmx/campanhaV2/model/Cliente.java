package br.com.conceptmx.campanhaV2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @JoinColumn(name = "idTime")
    @ManyToOne(targetEntity = Time.class, fetch = FetchType.EAGER)
    private Time time;

    @ManyToMany(targetEntity = Campanha.class, fetch = FetchType.EAGER)
    private List<Campanha> campanhas;
}
