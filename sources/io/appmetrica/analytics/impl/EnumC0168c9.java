package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.c9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0168c9 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f922a;

    EnumC0168c9(int i) {
        this.f922a = i;
    }

    public static EnumC0168c9 a(Integer num) {
        EnumC0168c9[] values;
        if (num != null) {
            for (EnumC0168c9 enumC0168c9 : values()) {
                if (enumC0168c9.f922a == num.intValue()) {
                    return enumC0168c9;
                }
            }
        }
        return NONE;
    }
}
