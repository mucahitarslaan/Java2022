package com.mucahitarslan.Devs.business.abstracts;


import com.mucahitarslan.Devs.entities.concretes.Technology;

import java.util.List;

public interface ITechnologyService{
    List<Technology> getAll();
    Technology getById(int id);
    Technology add(Technology technology);
    Technology update(int id, Technology technology);
    void delete(int id);
}
