package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.EngSize;

import java.util.ArrayList;
import java.util.List;

import static com.apostit.shared.Converter.*;

/**
 * Размеры носков
 */
public class SocksSize extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();

    public SocksSize(int russia, int europe, String USA) {
        map.put(x.Russia(), new Country(russia));
        map.put(x.Europe(), new Country(europe));
        map.put(x.International(), new Country(USA));
        map.put(x.USA(), new EngSize(EuropeToUK(europe)));
        map.put(x.England(), new EngSize(EuropeToUK(europe)));
    }

    public SocksSize(Messages x) {
        super(x);

        list.add(new SocksSize(21, 35, S));
        list.add(new SocksSize(22, 36, S));
        list.add(new SocksSize(23, 37, S));
        list.add(new SocksSize(24, 38, S));
        list.add(new SocksSize(25, 39, M));
        list.add(new SocksSize(26, 40, M));
        list.add(new SocksSize(27, 41, L));
        list.add(new SocksSize(28, 42, L));
        list.add(new SocksSize(29, 43, XL));
        list.add(new SocksSize(30, 44, XL));
        list.add(new SocksSize(31, 45, XXL));
        list.add(new SocksSize(32, 46, XXL));
    }

    public static double EuropeToUK(double v) {
        return (v - 39) / 2.0 + 9.5;
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.Socks();
    }

    @Override
    public String getHelp() {
        return "";
    }
}
