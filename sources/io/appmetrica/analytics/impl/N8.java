package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public enum N8 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f603a;

    N8(int i) {
        this.f603a = i;
    }

    public static N8 a(Integer num) {
        N8[] values;
        if (num != null) {
            for (N8 n8 : values()) {
                if (n8.f603a == num.intValue()) {
                    return n8;
                }
            }
        }
        return NONE;
    }
}
