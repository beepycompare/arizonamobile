package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ya  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC0729ya {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f1153a;

    EnumC0729ya(int i) {
        this.f1153a = i;
    }

    public static EnumC0729ya a(Integer num) {
        EnumC0729ya[] values;
        if (num != null) {
            for (EnumC0729ya enumC0729ya : values()) {
                if (enumC0729ya.f1153a == num.intValue()) {
                    return enumC0729ya;
                }
            }
        }
        return UNKNOWN;
    }
}
