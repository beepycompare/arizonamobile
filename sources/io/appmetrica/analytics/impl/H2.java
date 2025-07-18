package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class H2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0144b2 fromModel(J2 j2) {
        C0144b2 c0144b2 = new C0144b2();
        I2 i2 = j2.f485a;
        if (i2 != null) {
            int ordinal = i2.ordinal();
            if (ordinal == 1) {
                c0144b2.f764a = 1;
            } else if (ordinal == 2) {
                c0144b2.f764a = 2;
            } else if (ordinal == 3) {
                c0144b2.f764a = 3;
            } else if (ordinal == 4) {
                c0144b2.f764a = 4;
            } else if (ordinal == 5) {
                c0144b2.f764a = 5;
            }
        }
        Boolean bool = j2.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                c0144b2.b = 1;
                return c0144b2;
            }
            c0144b2.b = 0;
        }
        return c0144b2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J2 toModel(C0144b2 c0144b2) {
        I2 i2;
        int i = c0144b2.f764a;
        Boolean bool = null;
        if (i == 1) {
            i2 = I2.ACTIVE;
        } else if (i == 2) {
            i2 = I2.WORKING_SET;
        } else if (i == 3) {
            i2 = I2.FREQUENT;
        } else if (i != 4) {
            i2 = i != 5 ? null : I2.RESTRICTED;
        } else {
            i2 = I2.RARE;
        }
        int i3 = c0144b2.b;
        if (i3 == 0) {
            bool = Boolean.FALSE;
        } else if (i3 == 1) {
            bool = Boolean.TRUE;
        }
        return new J2(i2, bool);
    }
}
