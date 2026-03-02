package io.appmetrica.analytics.impl;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.t0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractServiceC0587t0 extends Service {

    /* renamed from: a  reason: collision with root package name */
    public L1 f1227a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        L1 l1 = this.f1227a;
        if (l1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            l1 = null;
        }
        return l1.a(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        L1 l1 = this.f1227a;
        if (l1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            l1 = null;
        }
        l1.a(configuration);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.f1227a == null) {
            this.f1227a = new L1(this, new C0612u0(this));
        }
        L1 l1 = this.f1227a;
        if (l1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            l1 = null;
        }
        l1.b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        L1 l1 = this.f1227a;
        if (l1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            l1 = null;
        }
        l1.c();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        L1 l1 = this.f1227a;
        if (l1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            l1 = null;
        }
        l1.b(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        L1 l1 = this.f1227a;
        if (l1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            l1 = null;
        }
        return l1.a(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        L1 l1 = this.f1227a;
        if (l1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceDelegate");
            l1 = null;
        }
        return l1.c(intent);
    }
}
