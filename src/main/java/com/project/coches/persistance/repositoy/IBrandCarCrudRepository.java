package com.project.coches.persistance.repositoy;

import com.project.coches.persistance.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCarCrudRepository extends JpaRepository<BrandCarEntity, Integer> {


}
