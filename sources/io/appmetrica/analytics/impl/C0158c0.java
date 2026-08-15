package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.c0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0158c0 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0184d0 f917a;
    public final /* synthetic */ Context b;

    public C0158c0(C0184d0 c0184d0, Context context) {
        this.f917a = c0184d0;
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0184d0 c0184d0 = this.f917a;
        Context context = this.b;
        c0184d0.getClass();
        c0184d0.a(context, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
    }
}
