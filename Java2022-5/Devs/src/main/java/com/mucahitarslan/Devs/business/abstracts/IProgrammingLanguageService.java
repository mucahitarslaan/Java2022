package com.mucahitarslan.Devs.business.abstracts;

import com.mucahitarslan.Devs.business.requests.programmingLanguage.CreateProgrammingLanguage;
import com.mucahitarslan.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguage;
import com.mucahitarslan.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguages;
import com.mucahitarslan.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguage;
import com.mucahitarslan.Devs.business.responses.programmingLanguage.GetTechnologiesProgrammingLanguage;

import java.util.List;

public interface IProgrammingLanguageService
{
    void add(CreateProgrammingLanguage language);
    void update(UpdateProgrammingLanguage language);
    void delete(int id);

    List<GetAllProgrammingLanguages> getAll();
    GetByIdProgrammingLanguage getById(int id);
    List<GetTechnologiesProgrammingLanguage> getTechnologies(int id);
}
