package models;

import java.util.Objects;
import java.util.UUID;

public class Category {
    private long catId;
    private String categoryName;
    
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
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

    @Override
    public String toString() {
        return "Category{" +
                "catId=" + catId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
