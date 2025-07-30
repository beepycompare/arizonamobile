package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.dj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0213dj implements O9 {
    @Override // io.appmetrica.analytics.impl.O9
    public final Integer a(C0280g9 c0280g9) {
        EnumC0680wb enumC0680wb = c0280g9.h;
        if (enumC0680wb == null) {
            Map map = AbstractC0184cg.f799a;
            return null;
        }
        return (Integer) AbstractC0184cg.c.get(enumC0680wb);
    }
}
