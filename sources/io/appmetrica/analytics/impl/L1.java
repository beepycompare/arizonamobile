package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes5.dex */
public final class L1 implements A1 {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f567a;
    public final A1 b;
    public boolean c;

    public L1(A1 a1) {
        this(C0620ua.k().x().b(), a1);
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(Intent intent, int i) {
        this.f567a.execute(new D1(this, intent, i));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void b(Intent intent) {
        this.f567a.execute(new H1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void c(Intent intent) {
        this.f567a.execute(new G1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void onConfigurationChanged(Configuration configuration) {
        this.f567a.execute(new B1(this, configuration));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final synchronized void onCreate() {
        this.c = true;
        this.f567a.execute(new C1(this));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void onDestroy() {
        this.f567a.removeAll();
        synchronized (this) {
            this.c = false;
        }
        this.b.onDestroy();
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void pauseUserSession(Bundle bundle) {
        this.f567a.execute(new K1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void reportData(int i, Bundle bundle) {
        this.f567a.execute(new I1(this, i, bundle));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void resumeUserSession(Bundle bundle) {
        this.f567a.execute(new J1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(Intent intent, int i, int i2) {
        this.f567a.execute(new E1(this, intent, i, i2));
    }

    public L1(IHandlerExecutor iHandlerExecutor, A1 a1) {
        this.c = false;
        this.f567a = iHandlerExecutor;
        this.b = a1;
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(Intent intent) {
        this.f567a.execute(new F1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(InterfaceC0736z1 interfaceC0736z1) {
        this.b.a(interfaceC0736z1);
    }
}
