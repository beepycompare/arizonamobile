package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes4.dex */
public final class Jf implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Integer fromModel(EnumC0531q8 enumC0531q8) {
        int ordinal = enumC0531q8.ordinal();
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
    public final EnumC0531q8 toModel(Integer num) {
        int intValue = num.intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return EnumC0531q8.b;
                }
                return EnumC0531q8.d;
            }
            return EnumC0531q8.e;
        }
        return EnumC0531q8.c;
    }
}
