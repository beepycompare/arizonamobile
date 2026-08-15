package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.ih  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0329ih implements InterfaceC0603t6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1036a;
    public final C0549r4 b;
    public final IHandlerExecutor c = Na.k().w().f();

    public C0329ih(Context context, C0549r4 c0549r4) {
        this.f1036a = context;
        this.b = c0549r4;
    }

    public final void a(C0241f6 c0241f6, Bundle bundle) {
        if (c0241f6.m()) {
            return;
        }
        this.c.execute(new Fh(this.f1036a, c0241f6, bundle, this.b));
    }

    public final void a(C0265g4 c0265g4, C0241f6 c0241f6, G4 g4) {
        this.b.a(c0265g4, g4).a(c0241f6, g4);
        this.b.a(c0265g4.b, c0265g4.c, c0265g4.d);
    }
}
