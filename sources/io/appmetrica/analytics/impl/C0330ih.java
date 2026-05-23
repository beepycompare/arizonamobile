package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.ih  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0330ih implements InterfaceC0604t6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1033a;
    public final C0550r4 b;
    public final IHandlerExecutor c = Na.k().w().f();

    public C0330ih(Context context, C0550r4 c0550r4) {
        this.f1033a = context;
        this.b = c0550r4;
    }

    public final void a(C0242f6 c0242f6, Bundle bundle) {
        if (c0242f6.m()) {
            return;
        }
        this.c.execute(new Fh(this.f1033a, c0242f6, bundle, this.b));
    }

    public final void a(C0266g4 c0266g4, C0242f6 c0242f6, G4 g4) {
        this.b.a(c0266g4, g4).a(c0242f6, g4);
        this.b.a(c0266g4.b, c0266g4.c, c0266g4.d);
    }
}
