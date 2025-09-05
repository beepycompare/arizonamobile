package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes4.dex */
public final class K1 implements InterfaceC0747z1 {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f525a;
    public final InterfaceC0747z1 b;
    public boolean c;

    public K1(InterfaceC0747z1 interfaceC0747z1) {
        this(Na.j().w().b(), interfaceC0747z1);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void a(Intent intent, int i) {
        this.f525a.execute(new C1(this, intent, i));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void b(Intent intent) {
        this.f525a.execute(new G1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void c(Intent intent) {
        this.f525a.execute(new F1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void onConfigurationChanged(Configuration configuration) {
        this.f525a.execute(new A1(this, configuration));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final synchronized void onCreate() {
        this.c = true;
        this.f525a.execute(new B1(this));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void onDestroy() {
        this.f525a.removeAll();
        synchronized (this) {
            this.c = false;
        }
        this.b.onDestroy();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void pauseUserSession(Bundle bundle) {
        this.f525a.execute(new J1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void reportData(int i, Bundle bundle) {
        this.f525a.execute(new H1(this, i, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void resumeUserSession(Bundle bundle) {
        this.f525a.execute(new I1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void a(Intent intent, int i, int i2) {
        this.f525a.execute(new D1(this, intent, i, i2));
    }

    public K1(IHandlerExecutor iHandlerExecutor, InterfaceC0747z1 interfaceC0747z1) {
        this.c = false;
        this.f525a = iHandlerExecutor;
        this.b = interfaceC0747z1;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void a(Intent intent) {
        this.f525a.execute(new E1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0747z1
    public final void a(InterfaceC0722y1 interfaceC0722y1) {
        this.b.a(interfaceC0722y1);
    }
}
