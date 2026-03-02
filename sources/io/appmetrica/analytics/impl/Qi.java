package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Qi implements InterfaceC0596t9 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0596t9
    public final Integer a(N8 n8) {
        EnumC0142bb enumC0142bb = n8.h;
        if (enumC0142bb == null) {
            Map map = Pf.f738a;
            return null;
        }
        return (Integer) Pf.c.get(enumC0142bb);
    }
}
