package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.Len;

import java.util.ArrayList;
import java.util.List;

import static com.apostit.shared.Converter.*;

/**
 * Сорочки
 */
public class Shirts extends Category {
    static private ArrayList<Category> list = new ArrayList<Category>();

    public Shirts(Messages x) {
        super(x);

        for (int russian = 37; russian <= 46; russian++)
            list.add(new Shirts(russian));
    }

    public Shirts(int russian) {
        map.put(x.Russia(), new Country(russian));
        map.put(x.Neck(), new Len(Rus_Neck(russian)));
        map.put(x.International(), new Country(Rus_International(russian)));
        map.put(x.USA(), new Country(Rus_USA(russian)));
        map.put(x.Europe(), new Country(Rus_Europe(russian)));
    }

    public static int Rus_Neck(int russian) {
        return russian;
    }

    public static String Rus_International(int russian) {
        if (russian >= 45)
            return XXL;
        if (russian >= 44)
            return XL;
        if (russian >= 41)
            return L;
        if (russian >= 39)
            return M;
        return S;
    }

    public static double Rus_USA(int russian) {
        if (russian >= 46)
            return russian / 2.0 - 5.0;
        if (russian >= 40)
            return russian / 2.0 - 4.5;
        return russian / 2.0 - 4.0;
    }

    public static int Rus_Europe(int russian) {
        return russian;
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.Shirts();
    }

    @Override
    public String getHelp() {
        return x.ShirtsHelp();
    }
}
