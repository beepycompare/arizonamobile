package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.g9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC0273g9 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f893a;

    EnumC0273g9(int i) {
        this.f893a = i;
    }

    public static EnumC0273g9 a(Integer num) {
        EnumC0273g9[] values;
        if (num != null) {
            for (EnumC0273g9 enumC0273g9 : values()) {
                if (enumC0273g9.f893a == num.intValue()) {
                    return enumC0273g9;
                }
            }
        }
        return NONE;
    }
}
