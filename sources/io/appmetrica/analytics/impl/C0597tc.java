package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.tc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0597tc extends AbstractC0230f {
    public C0597tc(Context context, Gg gg) {
        super(context, gg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0230f
    public final void b(W5 w5, C0664w4 c0664w4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(c0664w4.b.b, Boolean.FALSE)).booleanValue();
        Rb m = C0620ua.H.m();
        m.a(booleanValue);
        m.a(c0664w4.b.c);
        Boolean bool = c0664w4.b.n;
        if (bool != null) {
            C0620ua.H.c().b(bool.booleanValue());
        }
        this.b.a(w5, c0664w4);
    }
}
