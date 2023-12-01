package com.imryuik.crowdfunding.data;

import com.imryuik.crowdfunding.entity.Invest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestRepository extends CrudRepository<Invest, Long> {
}
