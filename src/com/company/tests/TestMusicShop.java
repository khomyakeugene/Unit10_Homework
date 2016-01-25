package com.company.tests;

import com.company.music.Guitar;
import com.company.music.MusicShop;
import com.company.music.Piano;
import com.company.music.Trumpet;
import com.company.utils.Utils;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class TestMusicShop {
    public final static String MUSIC_SHOP_NAME = "My Music Shop";
    public static final String SORTED_MUSICAL_INSTRUMENT_LIST_MESSAGE = "Sorted list of musical instruments: ";

    private MusicShop musicShop;

    private void initMusicShopData() {
        musicShop = new MusicShop(MUSIC_SHOP_NAME);

        musicShop.addInstrument(new Guitar());
        musicShop.addInstrument(new Trumpet());
        musicShop.addInstrument(new Guitar());
        musicShop.addInstrument(new Trumpet());
        musicShop.addInstrument(new Piano());
    }

    private void showMusicShop() {
        musicShop.showMusicShop();

        Utils.printMessage(SORTED_MUSICAL_INSTRUMENT_LIST_MESSAGE);
        musicShop.sortInstrumentsByType();
        musicShop.showMusicShop();
    }

    public void demonstrateData() {
        initMusicShopData();
        showMusicShop();
    }
}
