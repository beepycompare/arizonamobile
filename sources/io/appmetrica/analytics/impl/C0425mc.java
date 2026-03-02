package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.mc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0425mc extends AbstractC0233f {
    public C0425mc(Context context, Bg bg) {
        super(context, bg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0233f
    public final void b(P5 p5, C0492p4 c0492p4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(c0492p4.b.b, Boolean.FALSE)).booleanValue();
        Kb m = C0448na.I.m();
        m.a(booleanValue);
        m.a(c0492p4.b.c);
        Boolean bool = c0492p4.b.n;
        if (bool != null) {
            C0448na.I.c().b(bool.booleanValue());
        }
        this.b.a(p5, c0492p4);
    }
}
