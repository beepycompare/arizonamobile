package io.appmetrica.analytics.impl;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.t0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractServiceC0584t0 extends Service {

    /* renamed from: a  reason: collision with root package name */
    public M1 f1208a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        M1 m1 = this.f1208a;
        if (m1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            m1 = null;
        }
        return m1.a(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        M1 m1 = this.f1208a;
        if (m1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            m1 = null;
        }
        m1.a(configuration);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.f1208a == null) {
            this.f1208a = new M1(this, new C0609u0(this));
        }
        M1 m1 = this.f1208a;
        if (m1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            m1 = null;
        }
        m1.b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        M1 m1 = this.f1208a;
        if (m1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            m1 = null;
        }
        m1.c();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        M1 m1 = this.f1208a;
        if (m1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            m1 = null;
        }
        m1.b(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        M1 m1 = this.f1208a;
        if (m1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            m1 = null;
        }
        return m1.a(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        M1 m1 = this.f1208a;
        if (m1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            m1 = null;
        }
        return m1.c(intent);
    }
}
