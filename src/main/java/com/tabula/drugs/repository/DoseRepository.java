package com.tabula.drugs.repository;

import com.tabula.drugs.model.medicines.dosing.Dose;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Vladyslav_Vinnyk on 12/22/2016.
 */
public interface DoseRepository extends CrudRepository<Dose, Long>{
}
