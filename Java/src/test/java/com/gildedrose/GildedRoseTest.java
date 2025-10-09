package com.gildedrose;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {
    Item[] items = new Item[] {
        new Item("+5 Dexterity Vest", 10, 20), //
        new Item("Aged Brie", 2, 0), //
        new Item("Elixir of the Mongoose", 5, 7), //
        new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        new Item("Conjured Mana Cake", 3, 6),
        new Item("Aged Brie", -1, 49)};
    GildedRose app = new GildedRose(items);

    @Test void updateQuality(){
        assertEquals(49, app.items[9].quality);
        app.updateQuality();
        assertAll(
            ()-> assertEquals(19, app.items[0].quality),
            () -> assertEquals(1, app.items[1].quality),
            () -> assertEquals(6, app.items[2].quality),
            ()-> assertEquals(80, app.items[3].quality),
            () -> assertEquals(-1, app.items[4].sellIn),
            () -> assertEquals(21, app.items[5].quality),
            ()-> assertEquals(9, app.items[6].sellIn),
            () -> assertEquals(50, app.items[7].quality),
            () -> assertEquals(4, app.items[8].quality)
        );
        app.updateQuality();
        assertEquals(50, app.items[9].quality);
        app.updateQuality();
        assertEquals(4, app.items[1].quality);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertAll(
            ()->assertEquals(0, app.items[2].quality),
            ()->assertEquals(-1, app.items[2].sellIn),
            ()->assertEquals(0, app.items[8].quality),
            ()->assertEquals(50, app.items[9].quality)
        );
    }

    @Test
    public void testConjure(){
        Item[] items= new Item[]{new Item("Conjured Lantern", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}
