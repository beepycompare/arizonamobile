package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Ri implements InterfaceC0619u9 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0619u9
    public final Integer a(O8 o8) {
        EnumC0165cb enumC0165cb = o8.h;
        if (enumC0165cb == null) {
            Map map = Qf.f650a;
            return null;
        }
        return (Integer) Qf.c.get(enumC0165cb);
    }
}
