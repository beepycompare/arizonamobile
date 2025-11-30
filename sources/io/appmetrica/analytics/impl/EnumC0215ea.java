package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ea  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0215ea {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f869a;

    EnumC0215ea(int i) {
        this.f869a = i;
    }

    public static EnumC0215ea a(Integer num) {
        EnumC0215ea[] values;
        if (num != null) {
            for (EnumC0215ea enumC0215ea : values()) {
                if (enumC0215ea.f869a == num.intValue()) {
                    return enumC0215ea;
                }
            }
        }
        return UNKNOWN;
    }
}
