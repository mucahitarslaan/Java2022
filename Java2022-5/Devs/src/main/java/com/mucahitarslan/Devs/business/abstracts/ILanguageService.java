package com.mucahitarslan.Devs.business.abstracts;


import com.mucahitarslan.Devs.entities.concretes.Language;

import java.util.List;

public interface ILanguageService{
    List<Language> getAll();
    Language getById(int id);
    Language add(Language language);
    Language update(int id,Language language);
    void delete(int id);
}
