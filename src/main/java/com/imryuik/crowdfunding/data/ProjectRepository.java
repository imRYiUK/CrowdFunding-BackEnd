package com.imryuik.crowdfunding.data;

import com.imryuik.crowdfunding.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findByCategory_Id(Long category_id);
}
