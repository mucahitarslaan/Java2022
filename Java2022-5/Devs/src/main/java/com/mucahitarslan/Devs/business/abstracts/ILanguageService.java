package com.mucahitarslan.Devs.business.abstracts;


import com.mucahitarslan.Devs.business.requests.language.LanguageRequest;
import com.mucahitarslan.Devs.business.requests.language.LanguageUpdateRequest;
import com.mucahitarslan.Devs.business.responses.language.LanguageListResponse;
import com.mucahitarslan.Devs.business.responses.language.LanguageResponse;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyListResponse;
import com.mucahitarslan.Devs.entities.concretes.Language;

import java.util.List;

public interface ILanguageService{
    List<LanguageListResponse> getAll();
    LanguageResponse getById(int id);
    LanguageResponse add(LanguageRequest languageRequest);
    LanguageResponse update(int id, LanguageUpdateRequest languageUpdateRequest);
    void delete(int id);
    LanguageResponse toLanguageResponse(Language language);
    LanguageListResponse toLanguageListResponse(Language language);

    Language getLanguageById(int languageId);
    List<TechnologyListResponse> getLanguageTechnologyList(int id);
}
