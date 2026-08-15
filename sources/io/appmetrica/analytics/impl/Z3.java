package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientActivator;
/* loaded from: classes5.dex */
public final class Z3 implements ModuleClientActivator {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientActivator
    public final void activate(Context context) {
        C0184d0 b = C0575s4.l().b();
        b.c.a().executeDelayed(new C0158c0(b, context), b.d);
    }
}
