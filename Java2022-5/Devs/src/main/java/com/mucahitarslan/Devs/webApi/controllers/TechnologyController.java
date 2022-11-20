package com.mucahitarslan.Devs.webApi.controllers;

import com.mucahitarslan.Devs.business.abstracts.ITechnologyService;
import com.mucahitarslan.Devs.business.requests.technology.TechnologyRequest;
import com.mucahitarslan.Devs.business.requests.technology.TechnologyUpdateRequest;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyListResponse;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyResponse;
import com.mucahitarslan.Devs.business.responses.technology.TechnologyUpdateResponse;
import com.mucahitarslan.Devs.entities.concretes.Technology;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {
    private final ITechnologyService technologyService;

    public TechnologyController(ITechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public ResponseEntity<List<TechnologyListResponse>> getAll()
    {
        List<TechnologyListResponse> technologyListResponses = technologyService.getAll();
        if (technologyListResponses.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(technologyListResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologyResponse> getById(@PathVariable int id)
    {
        TechnologyResponse technologyResponse = technologyService.getById(id);
        if (Objects.nonNull(technologyResponse))
        {
            return new ResponseEntity<>(technologyResponse,HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TechnologyResponse> add(@RequestBody TechnologyRequest technologyRequest)
    {
        TechnologyResponse technologyResponse = technologyService.add(technologyRequest);
        if (Objects.nonNull(technologyResponse))
        {
            return new ResponseEntity<>(technologyResponse,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id)
    {
        technologyService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyResponse> update(@PathVariable int id, @RequestBody TechnologyUpdateRequest technologyUpdateRequest)
    {
        TechnologyResponse technologyResponse = technologyService.update(id,technologyUpdateRequest);
        if (Objects.nonNull(technologyResponse))
        {
            return new ResponseEntity<>(technologyResponse,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
