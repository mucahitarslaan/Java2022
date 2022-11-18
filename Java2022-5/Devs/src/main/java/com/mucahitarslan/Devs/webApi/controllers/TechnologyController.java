package com.mucahitarslan.Devs.webApi.controllers;

import com.mucahitarslan.Devs.business.abstracts.ITechnologyService;
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
    public ResponseEntity<List<Technology>> getAll()
    {
        List<Technology> technologies = technologyService.getAll();
        if (technologies.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(technologies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technology> getById(@PathVariable int id)
    {
        Technology technology = technologyService.getById(id);
        if (Objects.nonNull(technology))
        {
            return new ResponseEntity<>(technology,HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Technology> add(@RequestBody Technology technology)
    {
        Technology technology1 = technologyService.add(technology);
        if (Objects.nonNull(technology1))
        {
            return new ResponseEntity<>(technology1,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id)
    {
        technologyService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technology> update(@PathVariable int id, @RequestBody Technology technology)
    {
        Technology technology1 = technologyService.update(id,technology);
        if (Objects.nonNull(technology1))
        {
            return new ResponseEntity<>(technology1,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
