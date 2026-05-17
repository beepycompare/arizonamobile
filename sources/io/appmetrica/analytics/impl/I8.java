package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public enum I8 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f630a;

    I8(int i) {
        this.f630a = i;
    }

    public static I8 a(Integer num) {
        I8[] values;
        if (num != null) {
            for (I8 i8 : values()) {
                if (i8.f630a == num.intValue()) {
                    return i8;
                }
            }
        }
        return NONE;
    }
}
