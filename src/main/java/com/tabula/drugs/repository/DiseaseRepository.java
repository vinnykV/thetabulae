package com.tabula.drugs.repository;

import com.tabula.drugs.model.diseases.Disease;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Vladyslav_Vinnyk on 12/24/2016.
 */
public interface DiseaseRepository extends CrudRepository<Disease, Long> {
}
