package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ya  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC0730ya {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f1152a;

    EnumC0730ya(int i) {
        this.f1152a = i;
    }

    public static EnumC0730ya a(Integer num) {
        EnumC0730ya[] values;
        if (num != null) {
            for (EnumC0730ya enumC0730ya : values()) {
                if (enumC0730ya.f1152a == num.intValue()) {
                    return enumC0730ya;
                }
            }
        }
        return UNKNOWN;
    }
}
