package com.mucahitarslan.Devs.business.concretes;

import com.mucahitarslan.Devs.business.abstracts.ILanguageService;
import com.mucahitarslan.Devs.business.requests.language.CreateLanguageRequest;
import com.mucahitarslan.Devs.business.requests.language.DeleteLanguageRequest;
import com.mucahitarslan.Devs.business.requests.language.UpdateLanguageRequest;
import com.mucahitarslan.Devs.business.responses.language.GetAllLanguagesResponse;
import com.mucahitarslan.Devs.business.responses.language.GetByIdLanguageResponse;
import com.mucahitarslan.Devs.dataAccess.abstracts.ILanguageRepository;
import com.mucahitarslan.Devs.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageManager implements ILanguageService {
    private final ILanguageRepository languageRepository;

    public LanguageManager(ILanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> responseList = new ArrayList<>();

        for (Language language : languages)
        {
            GetAllLanguagesResponse response = new GetAllLanguagesResponse();
            response.setName(language.getName());
            response.setId(language.getId());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        GetByIdLanguageResponse response = new GetByIdLanguageResponse();
        Optional<Language> language = languageRepository.findById(id);
        if (language.isPresent())
        {
            response.setName(language.get().getName());
            return response;
        }
        return null;
    }

    @Override
    public Language add(CreateLanguageRequest createLanguageRequest) {
        Language language = new Language();
        language.setName(createLanguageRequest.getName());
        this.languageRepository.save(language);
        return language;
    }
/*
    @Override
    public Language update(int id,UpdateLanguageRequest updateLanguageRequest) {
        Language language = languageRepository.findById(updateLanguageRequest.getId()).get();
        language.setId(updateLanguageRequest.getId());
        language.setName(updateLanguageRequest.getName());
        languageRepository.save(language);
        return language;
    }

 */

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }
}
