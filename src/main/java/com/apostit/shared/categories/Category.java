package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.Size;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.round;

/**
 * Общий интерфейс для строк таблиц конвертации
 */
public abstract class Category {
    public static Messages x;
    public HashMap<String, Size> map = new HashMap<String, Size>();

    public Category() {
        if (x == null)
            throw new RuntimeException("Initialize category before create instances!");
    }

    public Category(Messages x) {
        Category.x = x;
    }

    public static String val(String value) {
        return "<b>" + value + "</b>";
    }

    /**
     * Округление до половины (чтобы было: 2.0 2.5 и т.д.)
     *
     * @param value Значение
     * @return Округлённое до половины значение
     */
    protected static double half(double value) {
        return round(value * 2.0) / 2.0;
    }

    public String[] getCountries() {
        ArrayList<String> strings = new ArrayList<String>();
        final HashMap<String, Size> hashMap = getList().get(0).map;
        for (String s : hashMap.keySet()) {
            Size size = hashMap.get(s);
            if (size instanceof Country)
                strings.add(s);
        }
        return strings.toArray(new String[]{"x"});
    }

    public String[] getParams() {
        ArrayList<String> strings = new ArrayList<String>();
        final HashMap<String, Size> hashMap = getList().get(0).map;
        for (String s : hashMap.keySet()) {
            Size size = hashMap.get(s);
            if (!(size instanceof Country))
                strings.add(s);
        }
        return strings.toArray(new String[]{"x"});
    }

    public abstract List<Category> getList();

    public Category[] getSizes() {
        return getList().toArray(new Category[1]);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (String s : getCountries()) {
            Size value = map.get(s);
            if (value == null) continue;
            if (value.toString() == null)
                continue;
            if (first)
                first = false;
            else
                builder.append("<br>");
            builder.append(s);
            builder.append(": ");
            builder.append(val(value.toString()));
        }
        for (String s : getParams()) {
            Size value = map.get(s);
            if (value == null) continue;
            if (first)
                first = false;
            else
                builder.append("<br>");
            builder.append(s);
            builder.append(": ");
            builder.append(val(value.toString()));
        }
        return builder.toString();
    }

    public Category x(String system, String value) {
        for (Category size : getSizes()) {
            for (String param : size.getCountries()) {
                if (system.equals(param) && value.equals(size.map.get(param).toString()))
                    return size;
            }
        }
        return null;
    }

    public String get(String key) {
        return map.get(key).toString();
    }

    public String forCountry(String to) {
        return "<h2>" + to + ": " + map.get(to) + "</h2>" + toString();
    }

    abstract public String getName();

    abstract public String getHelp();
}
