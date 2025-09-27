package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public enum Da {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f408a;

    Da(int i) {
        this.f408a = i;
    }

    public static Da a(Integer num) {
        Da[] values;
        if (num != null) {
            for (Da da : values()) {
                if (da.f408a == num.intValue()) {
                    return da;
                }
            }
        }
        return UNKNOWN;
    }
}
