package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.mc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0426mc extends AbstractC0234f {
    public C0426mc(Context context, Bg bg) {
        super(context, bg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0234f
    public final void b(P5 p5, C0493p4 c0493p4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(c0493p4.b.b, Boolean.FALSE)).booleanValue();
        Kb m = C0449na.I.m();
        m.a(booleanValue);
        m.a(c0493p4.b.c);
        Boolean bool = c0493p4.b.n;
        if (bool != null) {
            C0449na.I.c().b(bool.booleanValue());
        }
        this.b.a(p5, c0493p4);
    }
}
