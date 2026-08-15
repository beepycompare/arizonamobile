package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.c9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0167c9 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f925a;

    EnumC0167c9(int i) {
        this.f925a = i;
    }

    public static EnumC0167c9 a(Integer num) {
        EnumC0167c9[] values;
        if (num != null) {
            for (EnumC0167c9 enumC0167c9 : values()) {
                if (enumC0167c9.f925a == num.intValue()) {
                    return enumC0167c9;
                }
            }
        }
        return NONE;
    }
}
