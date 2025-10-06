package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientActivator;
/* renamed from: io.appmetrica.analytics.impl.h4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0295h4 implements ModuleClientActivator {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientActivator
    public final void activate(Context context) {
        C0110a0 b = A4.l().b();
        b.c.a().executeDelayed(new Z(b, context), b.d);
    }
}
