package com.mucahitarslan.Devs.webApi;

import com.mucahitarslan.Devs.business.abstracts.ILanguageTechnologyService;
import com.mucahitarslan.Devs.business.requests.languageTechnology.CreateProgrammingTechnology;
import com.mucahitarslan.Devs.business.requests.languageTechnology.UpdateProgrammingTechnology;
import com.mucahitarslan.Devs.business.responses.languageTechnology.GetAllTechnologies;
import com.mucahitarslan.Devs.business.responses.languageTechnology.GetByIdTechnology;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languageTechnology")
public class LanguageTechnologiesController {
    private ILanguageTechnologyService iLanguageTechnologyService;

    @Autowired
    public LanguageTechnologiesController(ILanguageTechnologyService iLanguageTechnologyService) {
        this.iLanguageTechnologyService = iLanguageTechnologyService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProgrammingTechnology technology)
    {
        iLanguageTechnologyService.add(technology);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateProgrammingTechnology technology)
    {
        iLanguageTechnologyService.update(technology);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id)
    {
        iLanguageTechnologyService.delete(id);
    }

    @GetMapping("/get/all")
    public List<GetAllTechnologies> getAll()
    {
        return iLanguageTechnologyService.getAll();
    }

    @GetMapping("/get/{id}")
    public GetByIdTechnology getById(@PathVariable(name = "id") int id)
    {
        return iLanguageTechnologyService.getById(id);
    }
}
