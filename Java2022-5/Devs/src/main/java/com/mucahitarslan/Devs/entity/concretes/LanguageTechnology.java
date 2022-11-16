package com.mucahitarslan.Devs.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "languageTechnology")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LanguageTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "technologyName")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "languageForeignKey")
    private ProgrammingLanguage languageList;

}
