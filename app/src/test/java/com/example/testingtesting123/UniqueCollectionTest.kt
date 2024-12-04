package com.example.testingtesting123

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val item = Item("item1")
        collection.addItem(item)
        assertEquals(1, collection.size())

       // assertEquals("item1", collection.get(0).name)  // The item in the collection should be "item1"

    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        // Arrange
        val item1 = Item("item1")
        val item2 = Item("Item1")  // Same item with different casing
        val item3 = Item("item3")

        // Act
        collection.addItem(item1)
        collection.addItem(item2)  // This should not be added because it has the same name as item1
        collection.addItem(item3)

        // Assert
        assertEquals(2, collection.size())  // The collection should contain only 2 unique items
        assertEquals("item1", collection.get(0).name)  // First item should be "item1"
        assertEquals("item3", collection.get(1).name)  // Second item should be "item3"


    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}