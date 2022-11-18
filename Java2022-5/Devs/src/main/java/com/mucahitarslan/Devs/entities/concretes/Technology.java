package com.mucahitarslan.Devs.entities.concretes;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@RequiredArgsConstructor
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "technology_id")
    private int id;

    @Column(name = "technology_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "join_language_id")
    private Language language;
}
