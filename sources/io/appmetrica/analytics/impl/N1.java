package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes5.dex */
public final class N1 implements C1 {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f673a;
    public final C1 b;
    public boolean c;

    public N1(C1 c1) {
        this(Na.k().w().b(), c1);
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void a(Intent intent, int i) {
        this.f673a.execute(new F1(this, intent, i));
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void b(Intent intent) {
        this.f673a.execute(new J1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void c(Intent intent) {
        this.f673a.execute(new I1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void onConfigurationChanged(Configuration configuration) {
        this.f673a.execute(new D1(this, configuration));
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final synchronized void onCreate() {
        this.c = true;
        this.f673a.execute(new E1(this));
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void onDestroy() {
        this.f673a.removeAll();
        synchronized (this) {
            this.c = false;
        }
        this.b.onDestroy();
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void pauseUserSession(Bundle bundle) {
        this.f673a.execute(new M1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void reportData(int i, Bundle bundle) {
        this.f673a.execute(new K1(this, i, bundle));
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void resumeUserSession(Bundle bundle) {
        this.f673a.execute(new L1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void a(Intent intent, int i, int i2) {
        this.f673a.execute(new G1(this, intent, i, i2));
    }

    public N1(IHandlerExecutor iHandlerExecutor, C1 c1) {
        this.c = false;
        this.f673a = iHandlerExecutor;
        this.b = c1;
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void a(Intent intent) {
        this.f673a.execute(new H1(this, intent));
    }
}
