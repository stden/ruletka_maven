package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.Len;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class ChildShoes extends Category {
    public static final String INFANT_PRE_WALKER_SIZING = "Infant / Pre-walker Sizing";
    public static final String TODDLER_SIZING = "Toddler Sizing";
    public static final String CHILDREN_SIZING = "Children Sizing";
    static ArrayList<Category> list = new ArrayList<Category>();

    public ChildShoes(double US_Size, double sm, String name, double EU_size) {
        double UK_Size = US_Size - 1;
        map.put(x.USA(), new Country(US_Size));
        map.put(x.Canada(), new Country(US_Size));
        map.put(x.Europe(), new Country(EU_size));
        map.put(x.Russia(), new Country(EU_size));
        map.put(x.England(), new Country(UK_Size));
        map.put(x.FootLength(), new Len(sm));
        map.put(x.Japan(), new Country(europeToJapan(EU_size)));
        map.put(x.International(), new Country(name));
        map.put(x.China(), new Country(US_China(US_Size)));
        map.put(x.Korea(), new Country(US_mm(US_Size)));
    }

    public ChildShoes(Messages x) {
        super(x);

        list.add(new ChildShoes(1, 9.05, INFANT_PRE_WALKER_SIZING, 16.5));
        list.add(new ChildShoes(2, 9.84, INFANT_PRE_WALKER_SIZING, 17.5));
        list.add(new ChildShoes(3, 10.8, INFANT_PRE_WALKER_SIZING, 18.5));
        list.add(new ChildShoes(4, 11.59, INFANT_PRE_WALKER_SIZING, 19.5));
        list.add(new ChildShoes(5, 12.38, TODDLER_SIZING, 21));
        list.add(new ChildShoes(5.5, 12.86, TODDLER_SIZING, 21.5));
        list.add(new ChildShoes(6, 13.34, TODDLER_SIZING, 22));
        list.add(new ChildShoes(6.5, 13.65, TODDLER_SIZING, 23));
        list.add(new ChildShoes(7, 14.13, TODDLER_SIZING, 23.5));
        list.add(new ChildShoes(7.5, 14.61, TODDLER_SIZING, 24));
        list.add(new ChildShoes(8, 14.92, TODDLER_SIZING, 25));
        list.add(new ChildShoes(8.5, 15.40, TODDLER_SIZING, 25.5));
        list.add(new ChildShoes(9, 15.88, TODDLER_SIZING, 26));
        list.add(new ChildShoes(9.5, 16.19, TODDLER_SIZING, 26.5));
        list.add(new ChildShoes(10, 16.67, TODDLER_SIZING, 27.5));
        list.add(new ChildShoes(10.5, 17.15, CHILDREN_SIZING, 28));
        list.add(new ChildShoes(11, 17.46, CHILDREN_SIZING, 28.5));
        list.add(new ChildShoes(11.5, 17.94, CHILDREN_SIZING, 29));
        list.add(new ChildShoes(12, 18.42, CHILDREN_SIZING, 30));
    }

    public static double europeToJapan(double v) {
        final double v1 = 0.64;
        return round(((v - 20.2) * v1 + 12.6) * 2) / 2.0;
    }

    public static double US_Euro(double v) {
        return round((v - 5) * ((29 - 20) / (11.5 - 5)) + 20.0);
    }

    public static double US_UK(double v) {
        if (v > 0.99 && v < 1.51)
            return v + 12;
        return v - 1.0;
    }

    public static double US_EU(double x) {
        return half(13.458 + 1.2997 * x + 0.001998 * x * x);
    }

    public static double US_China(double x) {
        return half(10.4607 + 0.702547 * x + 0.0494505 * x * x);
    }

    public static double US_mm(double x) {
        return 84.1725 + 8.43357 * x;
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.childShoes();
    }

    @Override
    public String getHelp() {
        return x.childShoesHelp();
    }
}
