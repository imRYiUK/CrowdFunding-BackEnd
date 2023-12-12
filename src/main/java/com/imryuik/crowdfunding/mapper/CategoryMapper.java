package com.imryuik.crowdfunding.mapper;

import com.imryuik.crowdfunding.dto.CategoryDTO;
import com.imryuik.crowdfunding.entity.Category;
import jakarta.persistence.ManyToOne;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
