package com.mucahitarslan.Devs.business.concretes;

import com.mucahitarslan.Devs.business.abstracts.ILanguageService;
import com.mucahitarslan.Devs.business.abstracts.ITechnologyService;
import com.mucahitarslan.Devs.business.requests.technology.TechnologyRequest;
import com.mucahitarslan.Devs.business.requests.technology.TechnologyUpdateRequest;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyListResponse;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyResponse;
import com.mucahitarslan.Devs.core.utils.TechnologyModel;
import com.mucahitarslan.Devs.dataAccess.abstracts.ITechnologyRepository;
import com.mucahitarslan.Devs.entities.concretes.Language;
import com.mucahitarslan.Devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TechnologyManager implements ITechnologyService {
    private final ITechnologyRepository technologyRepository;
    private final ILanguageService languageService;

    public TechnologyManager(ITechnologyRepository technologyRepository, ILanguageService languageService) {
        this.technologyRepository = technologyRepository;
        this.languageService = languageService;
    }

    @Override
    public List<TechnologyListResponse> getAll() {
        List<Technology> technologyList = technologyRepository.findAll();
        return technologyList.stream().map(TechnologyModel::toTechnologyListResponse).collect(Collectors.toList());
    }

    @Override
    public TechnologyResponse getById(int id) {
        Optional<Technology> technology = technologyRepository.findById(id);
        return technology.map(TechnologyModel::toTechnologyResponse).orElse(null);
    }

    @Override
    public TechnologyResponse add(TechnologyRequest technologyRequest) {
        if (isNameExist(technologyRequest.getName())) {
            throw new UnsupportedOperationException("name is exist in db");
        }
            Technology technology = new Technology();
            technology.setName(technologyRequest.getName());
            Language language = languageService.getLanguageById(technologyRequest.getLanguageId());
            if (Objects.nonNull(language)) {
                technology.setLanguage(language);
            }
        return TechnologyModel.toTechnologyResponse(technologyRepository.save(technology));
    }

//    @Override
//    public TechnologyResponse update(int id, Technology technology) {
//        Optional<Technology> inDbTechnology = technologyRepository.findById(id);
//        if (inDbTechnology.isPresent())
//        {
//            Technology technology1 = inDbTechnology.get();
//            technology1.setName(technology.getName());
//            return TechnologyModel.toTechnologyResponse(technologyRepository.save(technology1));
//        }
//        return null;
//    }

    @Override
    public TechnologyResponse update(int id, TechnologyUpdateRequest technologyUpdateRequest) {
        if (isNameExist(technologyUpdateRequest.getName()))
        {
            throw new UnsupportedOperationException("name is exist in db");
        }
        Optional<Technology> inDbTechnology = technologyRepository.findById(id);
        if (inDbTechnology.isPresent())
        {
            Technology technology1 = inDbTechnology.get();
            technology1.setName(technologyUpdateRequest.getName());
            return TechnologyModel.toTechnologyResponse(technologyRepository.save(technology1));
        }
        return null;
    }

    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }

    private boolean isNameExist(String name)
    {
        return  technologyRepository.existsByNameIgnoreCase(name);
    }

}
