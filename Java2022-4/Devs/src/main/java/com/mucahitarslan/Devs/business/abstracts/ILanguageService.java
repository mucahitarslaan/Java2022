package com.mucahitarslan.Devs.business.abstracts;

import com.mucahitarslan.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILanguageService
{
    List<ProgrammingLanguage> getAll();

    public void add(ProgrammingLanguage language) throws Exception;
    public void update(ProgrammingLanguage language,int id, String name) throws Exception;
    public void delete(int id) throws Exception;
    public ProgrammingLanguage getById(int id) throws Exception;
}
