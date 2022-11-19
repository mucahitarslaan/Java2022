package com.mucahitarslan.Devs.core.utils;

import com.mucahitarslan.Devs.business.responses.technology.TechnologyListResponse;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyResponse;
import com.mucahitarslan.Devs.entities.concretes.Technology;

public class TechnologyModel {

    public static TechnologyListResponse toTechnologyListResponse(Technology technology)
    {
        TechnologyListResponse technologyListResponse = new TechnologyListResponse();
        technologyListResponse.setId(technology.getId());
        technologyListResponse.setName(technology.getName());
        return technologyListResponse;
    }

    public static TechnologyResponse toTechnologyResponse(Technology technology)
    {
        TechnologyResponse technologyResponse = new TechnologyResponse();
        technologyResponse.setId(technology.getId());
        technologyResponse.setName(technology.getName());
        if (technology.getLanguage() != null)
        {
            technologyResponse.setLanguageId(technology.getLanguage().getId());
        }
        return technologyResponse;
    }
}
