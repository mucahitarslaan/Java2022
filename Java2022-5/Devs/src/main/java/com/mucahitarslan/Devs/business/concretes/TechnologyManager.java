package com.mucahitarslan.Devs.business.concretes;

import com.mucahitarslan.Devs.business.abstracts.ITechnologyService;
import com.mucahitarslan.Devs.business.requests.technology.CreateTechnologyRequest;
import com.mucahitarslan.Devs.business.requests.technology.DeleteTechnologyRequest;
import com.mucahitarslan.Devs.business.requests.technology.UpdateTechnologyRequest;
import com.mucahitarslan.Devs.business.responses.language.GetByIdLanguageResponse;
import com.mucahitarslan.Devs.business.responses.technology.GetAllTechnologiesResponse;
import com.mucahitarslan.Devs.business.responses.technology.GetByIdTechnologyResponse;
import com.mucahitarslan.Devs.dataAccess.abstracts.ILanguageRepository;
import com.mucahitarslan.Devs.dataAccess.abstracts.ITechnologyRepository;
import com.mucahitarslan.Devs.entities.concretes.Language;
import com.mucahitarslan.Devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TechnologyManager implements ITechnologyService {
    private final ITechnologyRepository technologyRepository;
    private final ILanguageRepository languageRepository;

    public TechnologyManager(ITechnologyRepository technologyRepository, ILanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllTechnologiesResponse> getAll() {
        List<GetAllTechnologiesResponse> responseList = new ArrayList<>();
        List<Technology> technologies = technologyRepository.findAll();

        for (Technology technology : technologies)
        {
            GetAllTechnologiesResponse response = new GetAllTechnologiesResponse();
            response.setName(technology.getName());
            response.setLanguageId(technology.getLanguage().getId());
            response.setLanguageName(technology.getLanguage().getName());
            response.setId(technology.getId());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) {
        Optional<Technology> technology = technologyRepository.findById(id);
        GetByIdTechnologyResponse response = new GetByIdTechnologyResponse();
        if (technology.isPresent())
        {
            response.setName(technology.get().getName());
            return response;
        }
        return null;
    }

    @Override
    public Technology add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = new Technology();
        Language language = languageRepository.findById(createTechnologyRequest.getLanguageId()).get();
        technology.setLanguage(language);
        technology.setName(createTechnologyRequest.getName());

        technologyRepository.save(technology);

        return technology;
    }

    @Override
    public Technology update(int id,UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technology = technologyRepository.findById(updateTechnologyRequest.getId()).get();
        Language language = languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();

        technology.setId(updateTechnologyRequest.getId());
        technology.setName(updateTechnologyRequest.getName());
        technology.setLanguage(language);

        technologyRepository.save(technology);
        return technology;
    }

    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }
}
