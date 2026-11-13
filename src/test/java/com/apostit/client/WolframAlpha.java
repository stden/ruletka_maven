package com.apostit.client;

/**
 * http://www.wolframalpha.com/input
 * linear fit {{81.3, 0}, {83.8, 2}, {86.4, 4}, {88.9, 6}, {102.9, 14}, {105.4, 16}}
 */
public class WolframAlpha {
    StringBuilder builder = new StringBuilder();
    private boolean first = true;

    public void Add(double a, double b) {
        if (!first)
            builder.append(",");
        builder.append("{");
        builder.append(a);
        builder.append(",");
        builder.append(b);
        builder.append("}");
        first = false;
    }

    public String linear() {
        return "linear fit {" + builder.toString() + "}";
    }

    public String quadratic() {
        return "quadratic fit {" + builder.toString() + "}";
    }
}
