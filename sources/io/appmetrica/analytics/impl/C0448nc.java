package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.nc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0448nc extends AbstractC0230f {
    public C0448nc(Context context, Cg cg) {
        super(context, cg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0230f
    public final void b(Q5 q5, C0515q4 c0515q4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(c0515q4.b.b, Boolean.FALSE)).booleanValue();
        Lb m = C0471oa.I.m();
        m.a(booleanValue);
        m.a(c0515q4.b.c);
        Boolean bool = c0515q4.b.n;
        if (bool != null) {
            C0471oa.I.c().b(bool.booleanValue());
        }
        this.b.a(q5, c0515q4);
    }
}
