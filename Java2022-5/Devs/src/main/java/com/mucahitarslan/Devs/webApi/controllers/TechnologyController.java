package com.mucahitarslan.Devs.webApi.controllers;

import com.mucahitarslan.Devs.business.abstracts.ITechnologyService;
import com.mucahitarslan.Devs.business.requests.technology.CreateTechnologyRequest;
import com.mucahitarslan.Devs.business.requests.technology.UpdateTechnologyRequest;
import com.mucahitarslan.Devs.business.responses.technology.GetAllTechnologiesResponse;
import com.mucahitarslan.Devs.business.responses.technology.GetByIdTechnologyResponse;
import com.mucahitarslan.Devs.entities.concretes.Technology;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
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
    public ResponseEntity<List<GetAllTechnologiesResponse>> getAll()
    {
        List<GetAllTechnologiesResponse> responseList = technologyService.getAll();
        if (responseList.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdTechnologyResponse> getById(int id)
    {
        GetByIdTechnologyResponse response = technologyService.getById(id);
        if (Objects.nonNull(response))
        {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<CreateTechnologyRequest> add(CreateTechnologyRequest createTechnologyRequest)
    {
        Technology technology = technologyService.add(createTechnologyRequest);
        if (Objects.nonNull(technology))
        {
            return new ResponseEntity<>(createTechnologyRequest,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateTechnologyRequest> update(@PathVariable int id, UpdateTechnologyRequest updateTechnologyRequest)
    {
        Technology technology = technologyService.update(id,updateTechnologyRequest);
        if (Objects.nonNull(technology))
        {
            return new ResponseEntity<>(updateTechnologyRequest,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        technologyService.delete(id);
    }
}
