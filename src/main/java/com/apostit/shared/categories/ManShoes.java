package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.EngSize;
import com.apostit.shared.size.Len;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

/**
 * Мужская обувь
 * Размеры мужской обуви (сандалии, туфли, полуботинки, ботинки, сапоги)
 */
public class ManShoes extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();

    public ManShoes(double len) {
        double russia = Len_Russia(len);
        double UK = Len_UK(len);

        // Российский
        map.put(x.Russia(), new Country(russia));
        map.put(x.Europe(), new Country(russia + 1));
        map.put(x.Germany(), new Country(russia + 1));
        map.put(x.England(), new EngSize(UK));
        map.put(x.Australia(), new EngSize(UK));
        map.put(x.Mexico(), new Country(UK - 0.5));
        final double USA = UK + 0.5;
        map.put(x.USA(), new Country(USA));
        map.put(x.Canada(), new Country(USA));
        map.put(x.Japan(), new Country(len));
        map.put(x.Korea(), new Country((int) (len * 10)));
        map.put(x.France(), new Country(UK_France(UK)));
        map.put(x.Italy(), new Country(US_Italy(USA)));
        map.put(x.China(), new Country(US_China(USA)));

        map.put(x.FootLength(), new Len(len));
    }

    public ManShoes(Messages x) {
        super(x);

        for (double len = 22.0; len < 30; len += 0.5)
            list.add(new ManShoes(len));
    }

    public static double UK_US(double v) {
        return v + 0.5;
    }

    public static double UK_Europe(double v) {
        return half((v - 2.4) / (13.5 - 2.5) * (49.0 - 34.0) + 34.0);
    }

    public static double UK_France(double v) {
        return half((v - 2.5) / (13.5 - 2.5) * (49.0 - 37.0) + 37.0);
    }

    public static double US_Italy(double v) {
        return half((v - 6.0) * (46.5 - 39.0) / 6.0 + 39.0);
    }

    public static double Len_Russia(double x) {
        return round(73.7458 - 4.36364 * x + 0.117882 * x * x);
    }

    public static double Len_UK(double x) {
        return half(59.7745 - 5.41013 * x + 0.130833 * x * x);
    }

    public static double US_China(double x) {
        return half(31.3164 + 1.40992 * x - 0.00770023 * x * x);
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.MenShoes();
    }

    @Override
    public String getHelp() {
        return "";
    }
}
