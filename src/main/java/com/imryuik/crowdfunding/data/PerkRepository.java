package com.imryuik.crowdfunding.data;

import com.imryuik.crowdfunding.entity.Perk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerkRepository extends CrudRepository<Perk, Long> {
}
