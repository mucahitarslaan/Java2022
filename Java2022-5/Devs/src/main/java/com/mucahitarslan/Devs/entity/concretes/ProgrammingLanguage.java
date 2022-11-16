package com.mucahitarslan.Devs.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "programmingLanguage")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "programmingLanguageName")
    private String name;

    @OneToMany(mappedBy = "languageList")
    private List<LanguageTechnology> technologyList;
}
