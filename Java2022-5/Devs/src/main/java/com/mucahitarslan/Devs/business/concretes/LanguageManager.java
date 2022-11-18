package com.mucahitarslan.Devs.business.concretes;

import com.mucahitarslan.Devs.business.abstracts.ILanguageService;
import com.mucahitarslan.Devs.dataAccess.abstracts.ILanguageRepository;
import com.mucahitarslan.Devs.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageManager implements ILanguageService {
    private final ILanguageRepository languageRepository;

    public LanguageManager(ILanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language getById(int id) {
        Optional<Language> language = languageRepository.findById(id);
        return language.orElse(null);
    }

    @Override
    public Language add(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language update(int id, Language language) {
        Optional<Language> inDbLanguage = languageRepository.findById(id);
        if (inDbLanguage.isPresent())
        {
            Language language1 = inDbLanguage.get();
            language1.setName(language.getName());
            return languageRepository.save(language1);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }
}
