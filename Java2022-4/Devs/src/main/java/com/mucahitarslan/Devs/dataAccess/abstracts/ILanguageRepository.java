package com.mucahitarslan.Devs.dataAccess.abstracts;

import com.mucahitarslan.Devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ILanguageRepository {
    List<ProgrammingLanguage> getAll();

    public void add(ProgrammingLanguage language);
    public void update(ProgrammingLanguage language,int id, String name) throws Exception;
    public void delete(int id) throws Exception;
    public ProgrammingLanguage getById(int id) throws Exception;
}
