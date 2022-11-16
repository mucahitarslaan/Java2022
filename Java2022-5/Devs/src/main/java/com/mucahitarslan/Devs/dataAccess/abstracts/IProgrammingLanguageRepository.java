package com.mucahitarslan.Devs.dataAccess.abstracts;

import com.mucahitarslan.Devs.entity.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer> {
}
