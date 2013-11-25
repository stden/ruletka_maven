package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.Range;

import java.util.ArrayList;
import java.util.List;

public class ChildWear extends Category {
    public static final String SMALL = "Small";
    public static final String MEDIUM = "Medium";
    public static final String LARGE = "Large";
    public static final String X_LARGE = "XLarge";
    public static final String T2 = "2T";
    public static final String T3 = "3T";
    public static final String T4 = "4T";
    public static final String USA5 = "5";
    public static final String USA6 = "6";
    public static final String USA6X = "6X";
    static ArrayList<Category> list = new ArrayList<Category>();

    /**
     * @param h1            Рост в сантиметрах
     * @param h2            Рост в сантиметрах
     * @param b1            Грудь
     * @param b2            Грудь
     * @param russia        Русский размер
     * @param international Международный
     * @param usa           Американский размер
     */
    public ChildWear(int h1, int h2, int b1, int b2, int russia, String international, String usa) {
        map.put(x.Russia(), new Country(russia));
        map.put(x.International(), new Country(international));
        map.put(x.USA(), new Country(usa));

        map.put(x.height(), new Range(h1, h2));
        map.put(x.BustCircumference(), new Range(b1, b2));
    }

    public ChildWear(Messages x) {
        super(x);

        list.add(new ChildWear(81, 86, 52, 54, 86, SMALL, T2));
        list.add(new ChildWear(87, 92, 53, 55, 92, SMALL, T2));
        list.add(new ChildWear(93, 98, 54, 56, 98, MEDIUM, T3));
        list.add(new ChildWear(99, 104, 55, 57, 104, MEDIUM, T4));
        list.add(new ChildWear(105, 110, 56, 58, 110, LARGE, USA5));
        list.add(new ChildWear(111, 116, 57, 59, 116, LARGE, USA5));
        list.add(new ChildWear(117, 122, 58, 62, 122, LARGE, USA6));
        list.add(new ChildWear(123, 128, 61, 65, 128, X_LARGE, USA6X));
        list.add(new ChildWear(129, 134, 64, 68, 134, X_LARGE, USA6X));
        list.add(new ChildWear(135, 140, 67, 71, 140, X_LARGE, USA6X));
        list.add(new ChildWear(141, 146, 70, 74, 146, X_LARGE, USA6X));
        list.add(new ChildWear(147, 152, 73, 77, 152, X_LARGE, USA6X));
        list.add(new ChildWear(153, 158, 76, 80, 158, X_LARGE, USA6X));
        list.add(new ChildWear(159, 164, 79, 83, 164, X_LARGE, USA6X));
        list.add(new ChildWear(165, 170, 82, 86, 170, X_LARGE, USA6X));
        list.add(new ChildWear(171, 176, 85, 89, 176, X_LARGE, USA6X));
        list.add(new ChildWear(177, 182, 88, 92, 182, X_LARGE, USA6X));
        list.add(new ChildWear(183, 188, 91, 95, 188, X_LARGE, USA6X));
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.childWear();
    }

    @Override
    public String getHelp() {
        return x.ChildWearHelp();
    }
}
