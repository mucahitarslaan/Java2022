package com.mucahitarslan.Devs.webApi.controllers;

import com.mucahitarslan.Devs.business.abstracts.ILanguageService;
import com.mucahitarslan.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController
{
    private final ILanguageService languageService;

    @Autowired
    public ProgrammingLanguagesController(ILanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<ProgrammingLanguage> getAll() throws Exception
    {
        return languageService.getAll();
    }


    @PostMapping("/add")
    public void add(@RequestBody ProgrammingLanguage language) throws Exception
    {
        languageService.add(language);
    }

    @PutMapping ("/update")
    public void update(@RequestBody ProgrammingLanguage language, int id, String name) throws Exception
    {
        languageService.update(language,id,name);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) throws Exception
    {
        languageService.delete(id);
    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable("id")int id) throws Exception
    {
        return languageService.getById(id);
    }

}
