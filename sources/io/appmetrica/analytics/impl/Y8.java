package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public enum Y8 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f719a;

    Y8(int i) {
        this.f719a = i;
    }

    public static Y8 a(Integer num) {
        Y8[] values;
        if (num != null) {
            for (Y8 y8 : values()) {
                if (y8.f719a == num.intValue()) {
                    return y8;
                }
            }
        }
        return NONE;
    }
}
