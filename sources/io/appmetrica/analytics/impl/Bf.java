package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes4.dex */
public final class Bf implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Integer fromModel(EnumC0327i8 enumC0327i8) {
        int ordinal = enumC0327i8.ordinal();
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
    public final EnumC0327i8 toModel(Integer num) {
        int intValue = num.intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return EnumC0327i8.b;
                }
                return EnumC0327i8.d;
            }
            return EnumC0327i8.e;
        }
        return EnumC0327i8.c;
    }
}
