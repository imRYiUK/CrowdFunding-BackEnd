package com.imryuik.crowdfunding.data;

import com.imryuik.crowdfunding.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
