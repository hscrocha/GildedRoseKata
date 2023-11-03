package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public int increaseQuality(int itemQual, int amount){
        if (itemQual < 50) {
            itemQual = itemQual + amount;
        }
        if (itemQual > 50) {
            itemQual = 50;
        }
        return itemQual;
    }

    public int decreaseQuality(int itemQual, int amount){
        if (itemQual > 0) {
            itemQual = itemQual - amount;
        }
        if (itemQual < 0) {
            itemQual = 0;
        }
        return itemQual;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            int change = 1;
            if(items[i].sellIn <= 0){
                change = 2;
            }

            if (items[i].name.equals("Aged Brie")) {
                items[i].quality = increaseQuality(items[i].quality, change);
            }
            else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                if (6 < items[i].sellIn&&items[i].sellIn < 11) {
                    items[i].quality=increaseQuality(items[i].quality, 2);
                }
                else if (0 < items[i].sellIn&&items[i].sellIn < 6) {
                    items[i].quality=increaseQuality(items[i].quality, 3);
                }
                else if(items[i].sellIn <= 0){
                    items[i].quality = 0;
                }
                else{items[i].quality=increaseQuality(items[i].quality, 1);}
            }
            else if (items[i].name.contains("Conjured")){
                items[i].quality = decreaseQuality(items[i].quality, change*2);
            }
            else {
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].quality = decreaseQuality(items[i].quality, change);
                }
            }
            //decrease sell by day
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
        }
    }
}
