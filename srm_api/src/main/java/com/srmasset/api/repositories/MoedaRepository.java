package com.srmasset.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srmasset.api.models.MoedaModel;

@Repository
public interface MoedaRepository extends JpaRepository<MoedaModel,  Long> {

}
