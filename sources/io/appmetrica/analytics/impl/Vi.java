package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Vi implements A9 {
    @Override // io.appmetrica.analytics.impl.A9
    public final Integer a(S8 s8) {
        EnumC0320ib enumC0320ib = s8.h;
        if (enumC0320ib == null) {
            Map map = Uf.f719a;
            return null;
        }
        return (Integer) Uf.c.get(enumC0320ib);
    }
}
