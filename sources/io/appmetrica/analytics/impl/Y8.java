package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public enum Y8 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f718a;

    Y8(int i) {
        this.f718a = i;
    }

    public static Y8 a(Integer num) {
        Y8[] values;
        if (num != null) {
            for (Y8 y8 : values()) {
                if (y8.f718a == num.intValue()) {
                    return y8;
                }
            }
        }
        return NONE;
    }
}
