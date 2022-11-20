package com.mucahitarslan.Devs.webApi.controllers;

import com.mucahitarslan.Devs.business.abstracts.ILanguageService;
import com.mucahitarslan.Devs.business.requests.language.LanguageRequest;
import com.mucahitarslan.Devs.business.requests.language.LanguageUpdateRequest;
import com.mucahitarslan.Devs.business.responses.language.LanguageListResponse;
import com.mucahitarslan.Devs.business.responses.language.LanguageResponse;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyListResponse;
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
    public ResponseEntity<List<LanguageListResponse>> getAll()
    {
        List<LanguageListResponse> languageListResponse = languageService.getAll();
        if (Objects.nonNull(languageListResponse))
        {
            return new ResponseEntity<>(languageListResponse,HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponse> getById(@PathVariable int id)
    {
        LanguageResponse languageResponse = languageService.getById(id);
        if (Objects.nonNull(languageResponse))
        {
            return new ResponseEntity<>(languageResponse,HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<LanguageResponse> add(@RequestBody LanguageRequest languageRequest)
    {
        LanguageResponse languageResponse = languageService.add(languageRequest);
        if (Objects.nonNull(languageResponse))
        {
            return new ResponseEntity<>(languageResponse,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id)
    {
        languageService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageResponse> update(@PathVariable int id,@RequestBody LanguageUpdateRequest languageUpdateRequest)
    {
        LanguageResponse languageResponse = languageService.update(id,languageUpdateRequest);
        if (Objects.nonNull(languageResponse))
        {
            return new ResponseEntity<>(languageResponse,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}/languagelist")
    public ResponseEntity<List<TechnologyListResponse>> getTechnologyListByLanguageId(@PathVariable int id)
    {
        List<TechnologyListResponse> technologyListResponse = languageService.getLanguageTechnologyList(id);

        if (Objects.nonNull(technologyListResponse))
        {
            return new ResponseEntity<>(technologyListResponse,HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }
}
