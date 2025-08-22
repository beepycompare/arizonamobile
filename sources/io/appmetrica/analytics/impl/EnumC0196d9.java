package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.d9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC0196d9 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f827a;

    EnumC0196d9(int i) {
        this.f827a = i;
    }

    public static EnumC0196d9 a(Integer num) {
        EnumC0196d9[] values;
        if (num != null) {
            for (EnumC0196d9 enumC0196d9 : values()) {
                if (enumC0196d9.f827a == num.intValue()) {
                    return enumC0196d9;
                }
            }
        }
        return NONE;
    }
}
