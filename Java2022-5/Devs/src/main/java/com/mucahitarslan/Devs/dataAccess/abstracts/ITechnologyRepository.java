package com.mucahitarslan.Devs.dataAccess.abstracts;

import com.mucahitarslan.Devs.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<Technology,Integer> {
    boolean existsByNameIgnoreCase(String name);

}
