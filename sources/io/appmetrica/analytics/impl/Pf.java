package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes5.dex */
public final class Pf implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Integer fromModel(EnumC0399l8 enumC0399l8) {
        int ordinal = enumC0399l8.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    return 0;
                }
                return 2;
            }
            return 3;
        }
        return 1;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final EnumC0399l8 toModel(Integer num) {
        int intValue = num.intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return EnumC0399l8.c;
                }
                return EnumC0399l8.e;
            }
            return EnumC0399l8.f;
        }
        return EnumC0399l8.d;
    }
}
