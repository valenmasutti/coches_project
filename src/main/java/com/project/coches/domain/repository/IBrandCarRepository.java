package com.project.coches.domain.repository;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository  {
    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    List<BrandCarPojo> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return optional del marca coche encontrado
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * Elimina una marca coche dada su id
     * @param idBrandCar Id del marca coche eliminar
     */
    void delete(Integer idBrandCar);

    // no tenogo un update ya que lo vamos hacer con el mismo save //

}
