package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.ih  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0323ih implements InterfaceC0597t6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1039a;
    public final C0543r4 b;
    public final IHandlerExecutor c = Na.k().w().f();

    public C0323ih(Context context, C0543r4 c0543r4) {
        this.f1039a = context;
        this.b = c0543r4;
    }

    public final void a(C0235f6 c0235f6, Bundle bundle) {
        if (c0235f6.m()) {
            return;
        }
        this.c.execute(new Fh(this.f1039a, c0235f6, bundle, this.b));
    }

    public final void a(C0259g4 c0259g4, C0235f6 c0235f6, G4 g4) {
        this.b.a(c0259g4, g4).a(c0235f6, g4);
        this.b.a(c0259g4.b, c0259g4.c, c0259g4.d);
    }
}
