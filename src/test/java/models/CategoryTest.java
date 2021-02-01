package models;

import junit.framework.TestCase;

import java.util.UUID;

import static org.h2.value.Value.UUID;

public class CategoryTest extends TestCase {

    public void testGetCatId() {
        Category category = setUpAssistant();
        java.util.UUID id = category.getCatId();
        assertEquals(id, category.getCatId());
    }

    public void testGetCategoryName() {
    }

    public void testSetCategoryName() {
    }

    //helper method
    public Category setUpAssistant(){
        return new Category("Business");
    }
}