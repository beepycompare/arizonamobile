package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC0151b9 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f780a;

    EnumC0151b9(int i) {
        this.f780a = i;
    }

    public static EnumC0151b9 a(Integer num) {
        EnumC0151b9[] values;
        if (num != null) {
            for (EnumC0151b9 enumC0151b9 : values()) {
                if (enumC0151b9.f780a == num.intValue()) {
                    return enumC0151b9;
                }
            }
        }
        return NONE;
    }
}
