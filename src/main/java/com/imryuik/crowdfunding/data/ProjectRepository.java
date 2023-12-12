package com.imryuik.crowdfunding.data;

import com.imryuik.crowdfunding.entity.Project;
import com.imryuik.crowdfunding.entity.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
//    List<Project> findByCategory_Id(Long category_id);
//    @Query("")
@Query(value = "SELECT * FROM project WHERE id IN (SELECT project_id FROM project_tag WHERE tag_id = :propertyValue)", nativeQuery = true)
    List<Project> findtags(@Param("propertyValue") Long id_tag);

    List<Project> findAll();
}
