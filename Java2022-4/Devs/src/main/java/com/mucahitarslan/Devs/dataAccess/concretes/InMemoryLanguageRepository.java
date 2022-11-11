package com.mucahitarslan.Devs.dataAccess.concretes;

import com.mucahitarslan.Devs.dataAccess.abstracts.ILanguageRepository;
import com.mucahitarslan.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements ILanguageRepository {
    List<ProgrammingLanguage> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<ProgrammingLanguage>();
        languages.add(new ProgrammingLanguage(1, "Java"));
        languages.add(new ProgrammingLanguage(2, "C#"));
        languages.add(new ProgrammingLanguage(3, "Python"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return languages;
    }

    @Override
    public void add(ProgrammingLanguage language) {
        languages.add(language);
    }

    @Override
    public void update(ProgrammingLanguage language,int id, String name) throws Exception {
        for (ProgrammingLanguage lang : getAll())
        {
            if (lang.getId() == id && !name.isBlank()) {
                lang.setName(name);
                break;
            }
        }
        throw new Exception("Invalid name");
    }

    @Override
    public void delete(int id) throws Exception {
        for (ProgrammingLanguage lang : getAll())
        {
            if (lang.getId() == id)
            {
                languages.remove(id -1);
            }
        }
        throw new Exception("Invalid id");
    }
    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        for (ProgrammingLanguage language : languages) {
            if (language.getId() == id) {
                return languages.get(id-1);
            }
        }
        throw new Exception("Invalid id");
    }
}
