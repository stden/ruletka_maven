package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.Range;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.round;

/**
 * Одежда для малышей
 */
public class ClothesForKids extends Category {

    static ArrayList<Category> list = new ArrayList<Category>();

    /**
     * @param size Русский размер
     */
    public ClothesForKids(int size) {
        final int h1 = Size_h1(size);
        map.put(x.height(), new Range(h1, Size_h2(size)));
        map.put(x.bust(), new Range(Size_bust1(size), Size_bust2(size)));
        map.put(x.Waist(), new Range(Size_w1(size), Size_w2(size)));
        map.put(x.Hips(), new Range(Size_hips1(size), Size_hips2(size)));
        map.put(x.Russia(), new Country(size));
        map.put(x.China(), new Country(size));
        map.put(x.England(), new Country(h1_UK(h1)));
        map.put(x.Australia(), new Country(h1_Australia(h1)));
    }

    public ClothesForKids(Messages x) {
        super(x);

        for (int size = 50; size <= 146; size += 6) {
            list.add(new ClothesForKids(size));
        }
    }

    public static int Size_h1(int size) {
        return size - 5;
    }

    public static int Size_h2(int size) {
        return size;
    }

    public static long Size_bust1(int x) {
        return round(-2.590494461E-8 * pow(x, 5) + 1.313367931E-5 * pow(x, 4) - 2.526324214E-3 * pow(x, 3) + 2.294534737E-1 * pow(x, 2) - 9.552162029 * x + 186.900646);
    }

    public static long Size_bust2(int x) {
        return round(-3.790033762E-8 * pow(x, 5) + 1.852905395E-5 * pow(x, 4)
                - 3.457437244E-3 * pow(x, 3) + 3.067582584E-1 * x * x - 12.64763212 * x + 236.8391064);
    }

    public static long Size_w1(int x) {
        return round(2.209704545E-5 * x * x * x - 6.360365784E-3 * x * x + 7.685758514E-1 * x + 16.02578068);
    }

    public static long Size_w2(int x) {
        return round(-3.904883293E-7 * x * x * x * x + 1.75765688E-4 * x * x * x - 2.802226943E-2 * x * x + 2.063334452 * x - 9.612312204);
    }

    public static long Size_hips1(int x) {
        return round(-1.084689795E-8 * pow(x, 5) +
                5.073796028E-6 * pow(x, 4) - 8.84553043E-4 * pow(x, 3) + 7.156010501E-2 * pow(x, 2) - 2.371301132 * x + 62.84940298);
    }

    public static double Size_hips2(int x) {
        return Math.round(-1.85673371E-8 * pow(x, 5) + 8.604142294E-6 * pow(x, 4) - 1.518743092E-3 * pow(x, 3) + 1.277804066E-1 * pow(x, 2) - 4.816128103 * x + 106.2535741);
    }

    public static String h1_UK(int x) {
        if (x >= 92) {
            long base = round(1.666666667E-1 * x - 13.33333333);
            return base + "-" + (base + 1);
        } else {
            return (x - 62) + " m";
        }
    }

    public static String h1_US(int x) {
        if (x == 86)
            return "23/24 m";
        if (x >= 92) {
            long base = round(1.666666667E-1 * x - 13.33333333);
            return base + "-" + (base + 1);
        } else {
            return (x - 62) + "-" + (x - 62 + 6) + " m";
        }
    }

    public static String h1_Australia(int x) {
        if (x <= 80)
            return "18 m";
        return "" + Math.round(1.666666667E-1 * x - 12.33333333);
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.ClothesForKids();
    }

    @Override
    public String getHelp() {
        return "";
    }
}
