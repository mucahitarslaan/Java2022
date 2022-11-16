package com.mucahitarslan.Devs.webApi;

import com.mucahitarslan.Devs.business.abstracts.IProgrammingLanguageService;
import com.mucahitarslan.Devs.business.requests.languageTechnology.UpdateProgrammingTechnology;
import com.mucahitarslan.Devs.business.requests.programmingLanguage.CreateProgrammingLanguage;
import com.mucahitarslan.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguage;
import com.mucahitarslan.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguages;
import com.mucahitarslan.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguage;
import com.mucahitarslan.Devs.business.responses.programmingLanguage.GetTechnologiesProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
    private IProgrammingLanguageService iProgrammingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(IProgrammingLanguageService iProgrammingLanguageService) {
        this.iProgrammingLanguageService = iProgrammingLanguageService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProgrammingLanguage language)
    {
        iProgrammingLanguageService.add(language);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateProgrammingLanguage language)
    {
        iProgrammingLanguageService.update(language);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id)
    {
        iProgrammingLanguageService.delete(id);
    }

    @GetMapping("/get/all")
    public List<GetAllProgrammingLanguages> getAll()
    {
        return iProgrammingLanguageService.getAll();
    }

    @GetMapping("/get/{id}")
    public GetByIdProgrammingLanguage getById(@PathVariable(name = "id") int id)
    {
        return iProgrammingLanguageService.getById(id);
    }

    @GetMapping("/get/{id}/technologies")
    public List<GetTechnologiesProgrammingLanguage> getAllTechnologies(@PathVariable(name = "id") int id)
    {
        return iProgrammingLanguageService.getTechnologies(id);
    }
}
