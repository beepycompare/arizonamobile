package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.aj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0135aj implements L9 {
    @Override // io.appmetrica.analytics.impl.L9
    public final Integer a(C0203d9 c0203d9) {
        EnumC0628ub enumC0628ub = c0203d9.h;
        if (enumC0628ub == null) {
            Map map = AbstractC0132ag.f755a;
            return null;
        }
        return (Integer) AbstractC0132ag.c.get(enumC0628ub);
    }
}
