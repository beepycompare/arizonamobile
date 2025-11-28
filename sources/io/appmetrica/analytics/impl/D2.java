package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes5.dex */
public final class D2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0207e2 fromModel(F2 f2) {
        C0207e2 c0207e2 = new C0207e2();
        E2 e2 = f2.f470a;
        if (e2 != null) {
            int ordinal = e2.ordinal();
            if (ordinal == 1) {
                c0207e2.f855a = 1;
            } else if (ordinal == 2) {
                c0207e2.f855a = 2;
            } else if (ordinal == 3) {
                c0207e2.f855a = 3;
            } else if (ordinal == 4) {
                c0207e2.f855a = 4;
            } else if (ordinal == 5) {
                c0207e2.f855a = 5;
            }
        }
        Boolean bool = f2.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                c0207e2.b = 1;
                return c0207e2;
            }
            c0207e2.b = 0;
        }
        return c0207e2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final F2 toModel(C0207e2 c0207e2) {
        E2 e2;
        int i = c0207e2.f855a;
        Boolean bool = null;
        if (i == 1) {
            e2 = E2.ACTIVE;
        } else if (i == 2) {
            e2 = E2.WORKING_SET;
        } else if (i == 3) {
            e2 = E2.FREQUENT;
        } else if (i != 4) {
            e2 = i != 5 ? null : E2.RESTRICTED;
        } else {
            e2 = E2.RARE;
        }
        int i2 = c0207e2.b;
        if (i2 == 0) {
            bool = Boolean.FALSE;
        } else if (i2 == 1) {
            bool = Boolean.TRUE;
        }
        return new F2(e2, bool);
    }
}
