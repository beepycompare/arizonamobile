package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Ri implements InterfaceC0618u9 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0618u9
    public final Integer a(O8 o8) {
        EnumC0164cb enumC0164cb = o8.h;
        if (enumC0164cb == null) {
            Map map = Qf.f747a;
            return null;
        }
        return (Integer) Qf.c.get(enumC0164cb);
    }
}
