package com.mucahitarslan.Devs.dataAccess.abstracts;

import com.mucahitarslan.Devs.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageRepository extends JpaRepository<Language,Integer> {
}
