package com.mucahitarslan.Devs.business.concretes;

import com.mucahitarslan.Devs.business.abstracts.IProgrammingLanguageService;
import com.mucahitarslan.Devs.business.requests.programmingLanguage.CreateProgrammingLanguage;
import com.mucahitarslan.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguage;
import com.mucahitarslan.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguages;
import com.mucahitarslan.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguage;
import com.mucahitarslan.Devs.business.responses.programmingLanguage.GetTechnologiesProgrammingLanguage;
import com.mucahitarslan.Devs.dataAccess.abstracts.ILanguageTechnologyRepository;
import com.mucahitarslan.Devs.dataAccess.abstracts.IProgrammingLanguageRepository;
import com.mucahitarslan.Devs.entity.concretes.LanguageTechnology;
import com.mucahitarslan.Devs.entity.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements IProgrammingLanguageService {
    private IProgrammingLanguageRepository iProgrammingLanguageRepository;
    private ILanguageTechnologyRepository iLanguageTechnologyRepository;


    @Override
    public void add(CreateProgrammingLanguage language) {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(language.getName());

        iProgrammingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void update(UpdateProgrammingLanguage language) {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(language.getName());

        iProgrammingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        iProgrammingLanguageRepository.deleteById(id);
    }

    @Override
    public List<GetAllProgrammingLanguages> getAll() {
        List<ProgrammingLanguage> programmingLanguages = iProgrammingLanguageRepository.findAll();
        List<GetAllProgrammingLanguages> getAllProgrammingLanguages = new ArrayList<GetAllProgrammingLanguages>();

        for (ProgrammingLanguage programmingLanguage : programmingLanguages)
        {
            GetAllProgrammingLanguages returnList = new GetAllProgrammingLanguages();
            returnList.setName(programmingLanguage.getName());
            returnList.setId(programmingLanguage.getId());

            getAllProgrammingLanguages.add(returnList);
        }
        return getAllProgrammingLanguages;
    }

    @Override
    public GetByIdProgrammingLanguage getById(int id) {
        List<ProgrammingLanguage> programmingLanguages = iProgrammingLanguageRepository.findAll();
        GetByIdProgrammingLanguage getByIdProgrammingLanguage = new GetByIdProgrammingLanguage();
        for (ProgrammingLanguage programmingLanguage : programmingLanguages)
        {
            if (programmingLanguage.getId() == id)
            {
                getByIdProgrammingLanguage.setId(programmingLanguage.getId());
                getByIdProgrammingLanguage.setName(programmingLanguage.getName());
                return getByIdProgrammingLanguage;
            }
        }
        return null;
    }

    @Override
    public List<GetTechnologiesProgrammingLanguage> getTechnologies(int id) {
        List<LanguageTechnology> languageTechnologies = iLanguageTechnologyRepository.findAll();
        List<GetTechnologiesProgrammingLanguage> getTechnologiesProgrammingLanguages = new ArrayList<GetTechnologiesProgrammingLanguage>();

        for (LanguageTechnology languageTechnology : languageTechnologies)
        {
            if (languageTechnology.getId() == id)
            {
                return null;
            }
        }
        return null;
    }
}
