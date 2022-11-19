package com.mucahitarslan.Devs.business.concretes;

import com.mucahitarslan.Devs.business.abstracts.ILanguageService;
import com.mucahitarslan.Devs.business.requests.language.LanguageRequest;
import com.mucahitarslan.Devs.business.responses.language.LanguageListResponse;
import com.mucahitarslan.Devs.business.responses.language.LanguageResponse;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyListResponse;
import com.mucahitarslan.Devs.core.utils.TechnologyModel;
import com.mucahitarslan.Devs.dataAccess.abstracts.ILanguageRepository;
import com.mucahitarslan.Devs.entities.concretes.Language;
import com.mucahitarslan.Devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguageManager implements ILanguageService {
    private final ILanguageRepository languageRepository;

    public LanguageManager(ILanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<LanguageListResponse> getAll()
    {
        return languageRepository.findAll().stream().map(this::toLanguageListResponse).collect(Collectors.toList());
    }

    @Override
    public LanguageResponse getById(int id) {
        Optional<Language> language = languageRepository.findById(id);
        return language.map(this::toLanguageResponse).orElse(null);
    }

    @Override
    public LanguageResponse add(LanguageRequest languageRequest) {
        Language language = new Language();
        language.setName(languageRequest.getName());
        return toLanguageResponse(languageRepository.save(language));
    }

    @Override
    public LanguageResponse update(int id, Language language) {
        Optional<Language> inDbLanguage = languageRepository.findById(id);
        if (inDbLanguage.isPresent())
        {
            Language language1 = inDbLanguage.get();
            language1.setName(language.getName());
            return toLanguageResponse(languageRepository.save(language1));
        }
        return null;
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }

    @Override
    public LanguageListResponse toLanguageListResponse(Language language)
    {
        LanguageListResponse languageListResponse = new LanguageListResponse();
        languageListResponse.setId(language.getId());
        languageListResponse.setName(language.getName());
        return languageListResponse;
    }

    @Override
    public LanguageResponse toLanguageResponse(Language language)
    {
        LanguageResponse languageResponse = new LanguageResponse();
        languageResponse.setId(language.getId());
        languageResponse.setName(language.getName());
        return languageResponse;
    }

    @Override
    public Language getLanguageById(int id) {
        return languageRepository.findById(id).orElse(null);
    }

    @Override
    public List<TechnologyListResponse> getLanguageTechnologyList(int id) {
        Optional<Language> language = languageRepository.findById(id);
        List<TechnologyListResponse> technologyListResponse = new ArrayList<>();
        if (language.isPresent())
        {
            List<Technology> technologyList = language.get().getTechnologies();
            for (Technology technology : technologyList)
            {
                TechnologyListResponse technologyListResponse1 = TechnologyModel.toTechnologyListResponse(technology);
                technologyListResponse.add(technologyListResponse1);
            }
            return technologyListResponse;
        }
        return null;
    }
}
