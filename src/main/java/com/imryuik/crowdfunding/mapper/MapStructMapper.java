package com.imryuik.crowdfunding.mapper;

import com.imryuik.crowdfunding.dto.*;
import com.imryuik.crowdfunding.entity.*;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    CategoryDTO categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(CategoryDTO categoryDto);
    InvestDTO investToInvestDTO(Invest invest);
    Invest investDTOToInvest(InvestDTO investDto);
    UserGetDTO userToUserGetDTO(User user);
    User userDTOToUser(UserDTO userDto);
    ProjectDTO projectToProjectDTO(Project project);
    Project projectDTOToProject(ProjectDTO projectDto);
    PerkDTO perkToPerkDTO(Perk perk);
    Perk perkDTOToPerk(PerkDTO perkDto);
    TagDTO tagToTagDTO(Tag tag);
    Tag tagDTOtoTag(TagDTO tagDto);

}
