package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.da  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0194da {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f956a;

    EnumC0194da(int i) {
        this.f956a = i;
    }

    public static EnumC0194da a(Integer num) {
        EnumC0194da[] values;
        if (num != null) {
            for (EnumC0194da enumC0194da : values()) {
                if (enumC0194da.f956a == num.intValue()) {
                    return enumC0194da;
                }
            }
        }
        return UNKNOWN;
    }
}
