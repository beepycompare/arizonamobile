package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class K2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0189d2 fromModel(M2 m2) {
        C0189d2 c0189d2 = new C0189d2();
        L2 l2 = m2.f565a;
        if (l2 != null) {
            int ordinal = l2.ordinal();
            if (ordinal == 1) {
                c0189d2.f830a = 1;
            } else if (ordinal == 2) {
                c0189d2.f830a = 2;
            } else if (ordinal == 3) {
                c0189d2.f830a = 3;
            } else if (ordinal == 4) {
                c0189d2.f830a = 4;
            } else if (ordinal == 5) {
                c0189d2.f830a = 5;
            }
        }
        Boolean bool = m2.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                c0189d2.b = 1;
                return c0189d2;
            }
            c0189d2.b = 0;
        }
        return c0189d2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final M2 toModel(C0189d2 c0189d2) {
        L2 l2;
        int i = c0189d2.f830a;
        Boolean bool = null;
        if (i == 1) {
            l2 = L2.ACTIVE;
        } else if (i == 2) {
            l2 = L2.WORKING_SET;
        } else if (i == 3) {
            l2 = L2.FREQUENT;
        } else if (i != 4) {
            l2 = i != 5 ? null : L2.RESTRICTED;
        } else {
            l2 = L2.RARE;
        }
        int i2 = c0189d2.b;
        if (i2 == 0) {
            bool = Boolean.FALSE;
        } else if (i2 == 1) {
            bool = Boolean.TRUE;
        }
        return new M2(l2, bool);
    }
}
