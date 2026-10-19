package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class I2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0309i2 fromModel(K2 k2) {
        C0309i2 c0309i2 = new C0309i2();
        J2 j2 = k2.f628a;
        if (j2 != null) {
            int ordinal = j2.ordinal();
            if (ordinal == 0) {
                c0309i2.f1031a = 6;
            } else if (ordinal == 1) {
                c0309i2.f1031a = 1;
            } else if (ordinal == 2) {
                c0309i2.f1031a = 2;
            } else if (ordinal == 3) {
                c0309i2.f1031a = 3;
            } else if (ordinal == 4) {
                c0309i2.f1031a = 4;
            } else if (ordinal != 5) {
                c0309i2.f1031a = 0;
            } else {
                c0309i2.f1031a = 5;
            }
        }
        Boolean bool = k2.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                c0309i2.b = 1;
                return c0309i2;
            }
            c0309i2.b = 0;
        }
        return c0309i2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final K2 toModel(C0309i2 c0309i2) {
        J2 j2;
        Boolean bool = null;
        switch (c0309i2.f1031a) {
            case 1:
                j2 = J2.ACTIVE;
                break;
            case 2:
                j2 = J2.WORKING_SET;
                break;
            case 3:
                j2 = J2.FREQUENT;
                break;
            case 4:
                j2 = J2.RARE;
                break;
            case 5:
                j2 = J2.RESTRICTED;
                break;
            case 6:
                j2 = J2.EXEMPTED;
                break;
            default:
                j2 = null;
                break;
        }
        int i = c0309i2.b;
        if (i == 0) {
            bool = Boolean.FALSE;
        } else if (i == 1) {
            bool = Boolean.TRUE;
        }
        return new K2(j2, bool);
    }
}
