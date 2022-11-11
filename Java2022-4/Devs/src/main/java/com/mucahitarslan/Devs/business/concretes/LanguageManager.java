package com.mucahitarslan.Devs.business.concretes;

import com.mucahitarslan.Devs.business.abstracts.ILanguageService;
import com.mucahitarslan.Devs.dataAccess.abstracts.ILanguageRepository;
import com.mucahitarslan.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements ILanguageService
{
    private final ILanguageRepository languageRepository;


    @Autowired
    public LanguageManager(ILanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public void add(ProgrammingLanguage language) throws Exception {
        if ((language.getName().isEmpty()))
            throw new Exception("Name cannot be empty");
        for (ProgrammingLanguage lang : getAll())
        {
            if (lang.getName().equals(language.getName()))
            {
                throw new Exception("This name exist in languages");
            }
        }
        languageRepository.add(language);
    }

    @Override
    public void update(ProgrammingLanguage language,int id, String name) throws Exception {
        languageRepository.update(language,id,name);
    }

    @Override
    public void delete(int id) throws Exception {
        languageRepository.delete(id);
    }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        for (ProgrammingLanguage lang : getAll())
        {
            if (lang.getId() == id)
                return languageRepository.getById(id);
        }
        throw new Exception("Invalid id");
    }
}
