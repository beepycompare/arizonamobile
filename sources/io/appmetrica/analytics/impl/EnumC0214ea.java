package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ea  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0214ea {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f966a;

    EnumC0214ea(int i) {
        this.f966a = i;
    }

    public static EnumC0214ea a(Integer num) {
        EnumC0214ea[] values;
        if (num != null) {
            for (EnumC0214ea enumC0214ea : values()) {
                if (enumC0214ea.f966a == num.intValue()) {
                    return enumC0214ea;
                }
            }
        }
        return UNKNOWN;
    }
}
