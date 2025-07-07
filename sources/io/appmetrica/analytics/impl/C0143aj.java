package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.aj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0143aj implements L9 {
    @Override // io.appmetrica.analytics.impl.L9
    public final Integer a(C0211d9 c0211d9) {
        EnumC0636ub enumC0636ub = c0211d9.h;
        if (enumC0636ub == null) {
            Map map = AbstractC0140ag.f754a;
            return null;
        }
        return (Integer) AbstractC0140ag.c.get(enumC0636ub);
    }
}
