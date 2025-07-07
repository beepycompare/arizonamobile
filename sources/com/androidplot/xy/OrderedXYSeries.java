package com.androidplot.xy;
/* loaded from: classes3.dex */
public interface OrderedXYSeries extends XYSeries {

    /* loaded from: classes3.dex */
    public enum XOrder {
        ASCENDING,
        DESCENDING,
        NONE
    }

    XOrder getXOrder();
}
