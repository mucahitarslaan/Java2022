package com.mucahitarslan.Devs.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "language_id")
    private int id;

    @Column(name = "language_name")
    private String name;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private List<Technology> technologies;
}
