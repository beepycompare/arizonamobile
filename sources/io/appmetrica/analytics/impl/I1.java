package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes4.dex */
public final class I1 implements InterfaceC0701x1 {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f467a;
    public final InterfaceC0701x1 b;
    public boolean c;

    public I1(InterfaceC0701x1 interfaceC0701x1) {
        this(Ga.j().w().b(), interfaceC0701x1);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void a(Intent intent, int i) {
        this.f467a.execute(new A1(this, intent, i));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void b(Intent intent) {
        this.f467a.execute(new E1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void c(Intent intent) {
        this.f467a.execute(new D1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void onConfigurationChanged(Configuration configuration) {
        this.f467a.execute(new C0726y1(this, configuration));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final synchronized void onCreate() {
        this.c = true;
        this.f467a.execute(new C0751z1(this));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void onDestroy() {
        this.f467a.removeAll();
        synchronized (this) {
            this.c = false;
        }
        this.b.onDestroy();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void pauseUserSession(Bundle bundle) {
        this.f467a.execute(new H1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void reportData(int i, Bundle bundle) {
        this.f467a.execute(new F1(this, i, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void resumeUserSession(Bundle bundle) {
        this.f467a.execute(new G1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void a(Intent intent, int i, int i2) {
        this.f467a.execute(new B1(this, intent, i, i2));
    }

    public I1(IHandlerExecutor iHandlerExecutor, InterfaceC0701x1 interfaceC0701x1) {
        this.c = false;
        this.f467a = iHandlerExecutor;
        this.b = interfaceC0701x1;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void a(Intent intent) {
        this.f467a.execute(new C1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void a(InterfaceC0676w1 interfaceC0676w1) {
        this.b.a(interfaceC0676w1);
    }
}
