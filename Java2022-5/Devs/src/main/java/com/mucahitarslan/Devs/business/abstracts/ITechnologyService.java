package com.mucahitarslan.Devs.business.abstracts;


import com.mucahitarslan.Devs.business.requests.technology.CreateTechnologyRequest;
import com.mucahitarslan.Devs.business.requests.technology.DeleteTechnologyRequest;
import com.mucahitarslan.Devs.business.requests.technology.UpdateTechnologyRequest;
import com.mucahitarslan.Devs.business.responses.language.GetByIdLanguageResponse;
import com.mucahitarslan.Devs.business.responses.technology.GetAllTechnologiesResponse;
import com.mucahitarslan.Devs.business.responses.technology.GetByIdTechnologyResponse;
import com.mucahitarslan.Devs.entities.concretes.Technology;

import java.util.List;

public interface ITechnologyService{

    List<GetAllTechnologiesResponse> getAll();
    GetByIdTechnologyResponse getById(int id);

    Technology add(CreateTechnologyRequest createTechnologyRequest);
    Technology update(int id, UpdateTechnologyRequest updateTechnologyRequest);
    void delete(int id);
}
