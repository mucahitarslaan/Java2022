package com.mucahitarslan.Devs.business.concretes;

import com.mucahitarslan.Devs.business.abstracts.ILanguageTechnologyService;
import com.mucahitarslan.Devs.business.requests.languageTechnology.CreateProgrammingTechnology;
import com.mucahitarslan.Devs.business.requests.languageTechnology.UpdateProgrammingTechnology;
import com.mucahitarslan.Devs.business.responses.languageTechnology.GetAllTechnologies;
import com.mucahitarslan.Devs.business.responses.languageTechnology.GetByIdTechnology;
import com.mucahitarslan.Devs.dataAccess.abstracts.ILanguageTechnologyRepository;
import com.mucahitarslan.Devs.dataAccess.abstracts.IProgrammingLanguageRepository;
import com.mucahitarslan.Devs.entity.concretes.LanguageTechnology;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class LanguageTechnologyManager implements ILanguageTechnologyService {
    private IProgrammingLanguageRepository iProgrammingLanguageRepository;
    private ILanguageTechnologyRepository iLanguageTechnologyRepository;

    @Override
    public void add(CreateProgrammingTechnology technology) {
        LanguageTechnology languageTechnology = new LanguageTechnology();
        languageTechnology.setName(technology.getName());

        iLanguageTechnologyRepository.save(languageTechnology);
    }

    @Override
    public void update(UpdateProgrammingTechnology technology) {
        LanguageTechnology languageTechnology = new LanguageTechnology();
        languageTechnology.setName(technology.getName());

        iLanguageTechnologyRepository.save(languageTechnology);
    }

    @Override
    public void delete(int id) {
        iLanguageTechnologyRepository.deleteById(id);
    }

    @Override
    public List<GetAllTechnologies> getAll() {
        List<LanguageTechnology> languageTechnologies = iLanguageTechnologyRepository.findAll();
        List<GetAllTechnologies> getAllTechnologies = new ArrayList<>();


        for (LanguageTechnology languageTechnology : languageTechnologies)
        {
            GetAllTechnologies returnList = new GetAllTechnologies();
            returnList.setName(languageTechnology.getName());
            returnList.setId(languageTechnology.getId());

            getAllTechnologies.add(returnList);
        }
        return getAllTechnologies;
    }

    @Override
    public GetByIdTechnology getById(int id) {
        List<LanguageTechnology> languageTechnologies = iLanguageTechnologyRepository.findAll();
        GetByIdTechnology getByIdTechnology = new GetByIdTechnology();

        for (LanguageTechnology languageTechnology : languageTechnologies)
        {
            if (languageTechnology.getId() == id)
            {
                getByIdTechnology.setId(languageTechnology.getId());
                getByIdTechnology.setName(languageTechnology.getName());

                return getByIdTechnology;
            }
        }
        return null;
    }
}
