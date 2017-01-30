package com.epam.javauniversity.eps.riskgroup;

import com.epam.javauniversity.eps.range.Range;
/*
 * risk group = <name,Range>
 */
public class RiskGroup {
    private final String name;
    private final Range range;

    public RiskGroup(String name, Range range) {
        this.name = name;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public Range getRange() {
        return range;
    }
}
