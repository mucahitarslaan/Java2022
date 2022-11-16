package com.mucahitarslan.Devs.business.abstracts;


import com.mucahitarslan.Devs.business.requests.languageTechnology.CreateProgrammingTechnology;
import com.mucahitarslan.Devs.business.requests.languageTechnology.UpdateProgrammingTechnology;
import com.mucahitarslan.Devs.business.responses.languageTechnology.GetAllTechnologies;
import com.mucahitarslan.Devs.business.responses.languageTechnology.GetByIdTechnology;

import java.util.List;

public interface ILanguageTechnologyService
{
    void add(CreateProgrammingTechnology technology);
    void update(UpdateProgrammingTechnology technology);
    void delete(int id);

    List<GetAllTechnologies> getAll();
    GetByIdTechnology getById(int id);
}
