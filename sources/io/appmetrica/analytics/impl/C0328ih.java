package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.ih  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0328ih implements InterfaceC0602t6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1036a;
    public final C0548r4 b;
    public final IHandlerExecutor c = Na.k().w().f();

    public C0328ih(Context context, C0548r4 c0548r4) {
        this.f1036a = context;
        this.b = c0548r4;
    }

    public final void a(C0240f6 c0240f6, Bundle bundle) {
        if (c0240f6.m()) {
            return;
        }
        this.c.execute(new Fh(this.f1036a, c0240f6, bundle, this.b));
    }

    public final void a(C0264g4 c0264g4, C0240f6 c0240f6, G4 g4) {
        this.b.a(c0264g4, g4).a(c0240f6, g4);
        this.b.a(c0264g4.b, c0264g4.c, c0264g4.d);
    }
}
