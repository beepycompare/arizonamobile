package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.nc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0447nc extends AbstractC0229f {
    public C0447nc(Context context, Cg cg) {
        super(context, cg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0229f
    public final void b(Q5 q5, C0514q4 c0514q4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(c0514q4.b.b, Boolean.FALSE)).booleanValue();
        Lb m = C0470oa.I.m();
        m.a(booleanValue);
        m.a(c0514q4.b.c);
        Boolean bool = c0514q4.b.n;
        if (bool != null) {
            C0470oa.I.c().b(bool.booleanValue());
        }
        this.b.a(q5, c0514q4);
    }
}
