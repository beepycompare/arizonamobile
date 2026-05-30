package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.c0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0159c0 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0185d0 f915a;
    public final /* synthetic */ Context b;

    public C0159c0(C0185d0 c0185d0, Context context) {
        this.f915a = c0185d0;
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0185d0 c0185d0 = this.f915a;
        Context context = this.b;
        c0185d0.getClass();
        c0185d0.a(context, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
    }
}
