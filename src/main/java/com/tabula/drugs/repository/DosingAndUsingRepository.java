package com.tabula.drugs.repository;

import com.tabula.drugs.model.medicines.dosing.DosingAndUsing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladyslav_Vinnyk on 12/22/2016.
 */
@Repository
public interface DosingAndUsingRepository extends CrudRepository<DosingAndUsing, Long> {
}
