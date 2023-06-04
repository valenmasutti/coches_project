package com.project.coches.persistance.repositoy;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.persistance.entity.BrandCarEntity;
import com.project.coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor // crea constructor con los atributos finals
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    /**
     * Crud de marca coche
     */

    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    /**
     * Mapper marca coche
     */

    private final IBrandCarMapper iBrandCarMapper;

    /** public BrandCarRepository(IBrandCarCrudRepository iBrandCarCrudRepository, IBrandCarMapper iBrandCarMapper) {

        this.iBrandCarCrudRepository = iBrandCarCrudRepository;
        this.iBrandCarMapper = iBrandCarMapper;
    } * Esto no se coloca ya que al utilizar lombook con esta anotacion @RequiredArgsConstructor ya estamos
     */

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarMapper.toMarcasCochePojo(iBrandCarCrudRepository.findAll());
    }

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return optional del marca coche encontrado
     */
    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id).map(iBrandCarMapper::toMarcaCochePojo); // Metodo por referencia
        // brandCarEntity -> iBrandCarMapper.toMarcaCochePojo(brandCarEntity) LAMBDA
    }

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
       BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
     return   iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.save(brandCarEntity));

    }

    /**
     * Elimina una marca coche dada su id
     * @param idBrandCar Id del marca coche eliminar
     */
    @Override
    public void delete(Integer idBrandCar) {
    iBrandCarCrudRepository.deleteById(idBrandCar);
    }
}
