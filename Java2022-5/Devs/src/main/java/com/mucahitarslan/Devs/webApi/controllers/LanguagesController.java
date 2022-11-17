package com.mucahitarslan.Devs.webApi.controllers;

import com.mucahitarslan.Devs.business.abstracts.ILanguageService;
import com.mucahitarslan.Devs.business.requests.language.CreateLanguageRequest;
import com.mucahitarslan.Devs.business.requests.language.DeleteLanguageRequest;
import com.mucahitarslan.Devs.business.requests.language.UpdateLanguageRequest;
import com.mucahitarslan.Devs.business.requests.technology.UpdateTechnologyRequest;
import com.mucahitarslan.Devs.business.responses.language.GetAllLanguagesResponse;
import com.mucahitarslan.Devs.business.responses.language.GetByIdLanguageResponse;
import com.mucahitarslan.Devs.entities.concretes.Language;
import com.mucahitarslan.Devs.entities.concretes.Technology;
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
    public ResponseEntity<List<GetAllLanguagesResponse>> getAll()
    {
        List<GetAllLanguagesResponse> languages = languageService.getAll();
        if (languages.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(languages,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdLanguageResponse> getById(int id)
    {
        GetByIdLanguageResponse response = languageService.getById(id);
        if (Objects.nonNull(response))
        {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<CreateLanguageRequest> add(@RequestBody CreateLanguageRequest createLanguageRequest)
    {
        Language language = languageService.add(createLanguageRequest);
        if (Objects.nonNull(language))
        {
            return new ResponseEntity<>(createLanguageRequest, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
/*
    @PutMapping("/{id}")
    public ResponseEntity<UpdateLanguageRequest> update(@PathVariable int id,
                                                        @RequestBody UpdateLanguageRequest updateLanguageRequest)
    {
        Language language = languageService.update(id,updateLanguageRequest);
        if (Objects.nonNull(language))
        {
            return new ResponseEntity<>(updateLanguageRequest,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

 */

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id)
    {
        languageService.delete(id);
    }
}
