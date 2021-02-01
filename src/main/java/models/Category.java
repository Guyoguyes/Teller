package models;

import java.util.Objects;
import java.util.UUID;

public class Category {
    private UUID catId;
    private String categoryName;
    
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public UUID getCatId() {
        return catId;
    }

    public void setCatId(UUID catId) {
        this.catId = UUID.randomUUID();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(catId, category.catId) && Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, categoryName);
    }

}
