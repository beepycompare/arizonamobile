package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.da  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0193da {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f956a;

    EnumC0193da(int i) {
        this.f956a = i;
    }

    public static EnumC0193da a(Integer num) {
        EnumC0193da[] values;
        if (num != null) {
            for (EnumC0193da enumC0193da : values()) {
                if (enumC0193da.f956a == num.intValue()) {
                    return enumC0193da;
                }
            }
        }
        return UNKNOWN;
    }
}
