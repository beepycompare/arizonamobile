package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.wa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC0677wa {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f1104a;

    EnumC0677wa(int i) {
        this.f1104a = i;
    }

    public static EnumC0677wa a(Integer num) {
        EnumC0677wa[] values;
        if (num != null) {
            for (EnumC0677wa enumC0677wa : values()) {
                if (enumC0677wa.f1104a == num.intValue()) {
                    return enumC0677wa;
                }
            }
        }
        return UNKNOWN;
    }
}
