package com.mucahitarslan.Devs.business.concretes;

import com.mucahitarslan.Devs.business.abstracts.ITechnologyService;
import com.mucahitarslan.Devs.dataAccess.abstracts.ITechnologyRepository;
import com.mucahitarslan.Devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnologyManager implements ITechnologyService {
    private final ITechnologyRepository technologyRepository;

    public TechnologyManager(ITechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public List<Technology> getAll() {
        return technologyRepository.findAll();
    }

    @Override
    public Technology getById(int id) {
        Optional<Technology> technology = technologyRepository.findById(id);
        return technology.orElse(null);
    }

    @Override
    public Technology add(Technology technology) {
        return technologyRepository.save(technology);
    }

    @Override
    public Technology update(int id, Technology technology) {
        Optional<Technology> inDbTechnology = technologyRepository.findById(id);
        if (inDbTechnology.isPresent())
        {
            Technology technology1 = inDbTechnology.get();
            technology1.setName(technology.getName());
            //technology1.setLanguage();
            return technologyRepository.save(technology1);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }
}
