package com.imryuik.crowdfunding.data;

import com.imryuik.crowdfunding.entity.Backer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackerRepository extends CrudRepository<Backer, Long> {
}
