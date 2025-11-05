package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientActivator;
/* loaded from: classes3.dex */
public final class Q3 implements ModuleClientActivator {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientActivator
    public final void activate(Context context) {
        C0128b0 b = C0338j4.l().b();
        b.c.a().executeDelayed(new C0102a0(b, context), b.d);
    }
}
