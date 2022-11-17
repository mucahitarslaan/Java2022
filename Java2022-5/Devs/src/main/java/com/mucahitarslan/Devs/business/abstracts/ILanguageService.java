package com.mucahitarslan.Devs.business.abstracts;


import com.mucahitarslan.Devs.business.requests.language.CreateLanguageRequest;
import com.mucahitarslan.Devs.business.requests.language.DeleteLanguageRequest;
import com.mucahitarslan.Devs.business.requests.language.UpdateLanguageRequest;
import com.mucahitarslan.Devs.business.responses.language.GetAllLanguagesResponse;
import com.mucahitarslan.Devs.business.responses.language.GetByIdLanguageResponse;
import com.mucahitarslan.Devs.entities.concretes.Language;

import java.util.List;

public interface ILanguageService{
    List<GetAllLanguagesResponse> getAll();
    GetByIdLanguageResponse getById(int id);

    Language add(CreateLanguageRequest createLanguageRequest);
    //Language update(int id,UpdateLanguageRequest updateLanguageRequest);
    void delete(int id);
}
