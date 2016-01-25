package com.company.music;

import com.company.utils.Collections;
import java.util.ArrayList;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class MusicShop {
    public final static int TABLE_WIDTH = 80;

    private String shopName;
    private ArrayList<MusicalInstrument> instruments;

    public MusicShop(String shopName) {
        super();

        setShopName(shopName);

        // Init "instruments space"
        instruments = new ArrayList<>();
    }

    public ArrayList<MusicalInstrument> getInstruments() {
        return instruments;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void addInstrument(MusicalInstrument instrument) {
        instruments.add(instrument);
    }

    public void showMusicShop() {
        // Show as a table
        Collections.printListAsTable(getInstruments(), getShopName(), TABLE_WIDTH);
    }

    public void sortInstrumentsByType() {
        ArrayList<MusicalInstrument> copyOfInstruments = new ArrayList<>();

        copyOfInstruments.addAll(instruments);
        instruments.clear();

        copyOfInstruments
                .stream()
                .sorted((i1, i2) -> i1.getInstrumentType().compareTo(i2.getInstrumentType()))
                .forEach(i -> instruments.add(i));
    }
}
