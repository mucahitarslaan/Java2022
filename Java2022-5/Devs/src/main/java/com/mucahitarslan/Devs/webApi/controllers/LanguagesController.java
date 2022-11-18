package com.mucahitarslan.Devs.webApi.controllers;

import com.mucahitarslan.Devs.business.abstracts.ILanguageService;
import com.mucahitarslan.Devs.entities.concretes.Language;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private final ILanguageService languageService;

    public LanguagesController(ILanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<Language>> getAll()
    {
        List<Language> languages = languageService.getAll();
        if (languages.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getById(@PathVariable int id)
    {
        Language language = languageService.getById(id);
        if (Objects.nonNull(language))
        {
            return new ResponseEntity<>(language,HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Language> add(@RequestBody Language language)
    {
        Language language1 = languageService.add(language);
        if (Objects.nonNull(language1))
        {
            return new ResponseEntity<>(language1,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id)
    {
        languageService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> update(@PathVariable int id,@RequestBody Language language)
    {
        Language language1 = languageService.update(id,language);
        if (Objects.nonNull(language1))
        {
            return new ResponseEntity<>(language1,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
