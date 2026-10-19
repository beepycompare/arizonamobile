package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.c9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0161c9 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f928a;

    EnumC0161c9(int i) {
        this.f928a = i;
    }

    public static EnumC0161c9 a(Integer num) {
        EnumC0161c9[] values;
        if (num != null) {
            for (EnumC0161c9 enumC0161c9 : values()) {
                if (enumC0161c9.f928a == num.intValue()) {
                    return enumC0161c9;
                }
            }
        }
        return NONE;
    }
}
