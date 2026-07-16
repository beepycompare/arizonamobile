package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public enum Aa {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f458a;

    Aa(int i) {
        this.f458a = i;
    }

    public static Aa a(Integer num) {
        Aa[] values;
        if (num != null) {
            for (Aa aa : values()) {
                if (aa.f458a == num.intValue()) {
                    return aa;
                }
            }
        }
        return UNKNOWN;
    }
}
