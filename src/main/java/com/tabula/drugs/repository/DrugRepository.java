package com.tabula.drugs.repository;

import com.tabula.drugs.model.Drug;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
public interface DrugRepository extends CrudRepository<Drug, Long> {
}
