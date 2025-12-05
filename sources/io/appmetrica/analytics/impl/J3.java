package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientActivator;
/* loaded from: classes5.dex */
public final class J3 implements ModuleClientActivator {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientActivator
    public final void activate(Context context) {
        C0127b0 b = C0157c4.l().b();
        b.c.a().executeDelayed(new C0101a0(b, context), b.d);
    }
}
