package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ij  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0334ij implements Q9 {
    @Override // io.appmetrica.analytics.impl.Q9
    public final Integer a(C0325i9 c0325i9) {
        EnumC0728yb enumC0728yb = c0325i9.h;
        if (enumC0728yb == null) {
            Map map = AbstractC0306hg.f889a;
            return null;
        }
        return (Integer) AbstractC0306hg.c.get(enumC0728yb);
    }
}
