package com.imryuik.crowdfunding.data;

import com.imryuik.crowdfunding.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findByIdentifier(String identifier);
}
