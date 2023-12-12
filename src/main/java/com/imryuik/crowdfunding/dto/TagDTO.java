package com.imryuik.crowdfunding.dto;

public class TagDTO {
    private Long id;
    private String name;
    private String identifier;

    private CategoryDTO categoryDTO;

    public TagDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public CategoryDTO getCategoryDTO() {
        return this.categoryDTO;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TagDTO)) return false;
        final TagDTO other = (TagDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$identifier = this.getIdentifier();
        final Object other$identifier = other.getIdentifier();
        if (this$identifier == null ? other$identifier != null : !this$identifier.equals(other$identifier))
            return false;
        final Object this$categoryDTO = this.getCategoryDTO();
        final Object other$categoryDTO = other.getCategoryDTO();
        if (this$categoryDTO == null ? other$categoryDTO != null : !this$categoryDTO.equals(other$categoryDTO))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TagDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $identifier = this.getIdentifier();
        result = result * PRIME + ($identifier == null ? 43 : $identifier.hashCode());
        final Object $categoryDTO = this.getCategoryDTO();
        result = result * PRIME + ($categoryDTO == null ? 43 : $categoryDTO.hashCode());
        return result;
    }

    public String toString() {
        return "TagDTO(id=" + this.getId() + ", name=" + this.getName() + ", identifier=" + this.getIdentifier() + ", categoryDTO=" + this.getCategoryDTO() + ")";
    }
}
