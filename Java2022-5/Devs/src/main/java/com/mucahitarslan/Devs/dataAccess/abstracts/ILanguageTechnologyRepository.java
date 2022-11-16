package com.mucahitarslan.Devs.dataAccess.abstracts;

import com.mucahitarslan.Devs.entity.concretes.LanguageTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageTechnologyRepository extends JpaRepository<LanguageTechnology,Integer> {
}
