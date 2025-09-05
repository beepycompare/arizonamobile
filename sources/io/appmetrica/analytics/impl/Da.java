package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public enum Da {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f403a;

    Da(int i) {
        this.f403a = i;
    }

    public static Da a(Integer num) {
        Da[] values;
        if (num != null) {
            for (Da da : values()) {
                if (da.f403a == num.intValue()) {
                    return da;
                }
            }
        }
        return UNKNOWN;
    }
}
