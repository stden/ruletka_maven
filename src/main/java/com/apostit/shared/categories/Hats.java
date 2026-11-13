package com.apostit.shared.categories;

import java.util.ArrayList;
import java.util.List;

/**
 * Шляпы
 */
public class Hats extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();

    public static double Europe_US(int europe) {
        if (europe == 54)
            return 6;
        if (europe == 55)
            return 6.75;
        if (europe == 56)
            return 7.0;
        if (europe == 58)
            return 7.25;
        if (europe == 60)
            return 7.5;
        if (europe == 62)
            return 7.75;
        return Math.round((europe / 1.9 - 21.0) * 4) / 4.0;
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.Hats();
    }

    @Override
    public String getHelp() {
        return x.HatsHelp();
    }
}
