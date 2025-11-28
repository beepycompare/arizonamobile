package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ka  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0370ka {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f971a;

    EnumC0370ka(int i) {
        this.f971a = i;
    }

    public static EnumC0370ka a(Integer num) {
        EnumC0370ka[] values;
        if (num != null) {
            for (EnumC0370ka enumC0370ka : values()) {
                if (enumC0370ka.f971a == num.intValue()) {
                    return enumC0370ka;
                }
            }
        }
        return UNKNOWN;
    }
}
