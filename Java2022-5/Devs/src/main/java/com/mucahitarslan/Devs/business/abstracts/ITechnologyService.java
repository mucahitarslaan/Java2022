package com.mucahitarslan.Devs.business.abstracts;


import com.mucahitarslan.Devs.business.requests.technology.TechnologyRequest;
import com.mucahitarslan.Devs.business.requests.technology.TechnologyUpdateRequest;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyListResponse;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyResponse;
import com.mucahitarslan.Devs.entities.concretes.Technology;

import java.util.List;

public interface ITechnologyService{
    List<TechnologyListResponse> getAll();
    TechnologyResponse getById(int id);
    TechnologyResponse add(TechnologyRequest technologyRequest);
    TechnologyResponse update(int id, TechnologyUpdateRequest technologyUpdateRequest);
    void delete(int id);
}
