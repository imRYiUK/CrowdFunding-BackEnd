package com.imryuik.crowdfunding.data;

import com.imryuik.crowdfunding.entity.Creator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends CrudRepository<Creator, Long> {
}
