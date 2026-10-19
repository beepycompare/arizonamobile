package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.c0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0152c0 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0178d0 f920a;
    public final /* synthetic */ Context b;

    public C0152c0(C0178d0 c0178d0, Context context) {
        this.f920a = c0178d0;
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0178d0 c0178d0 = this.f920a;
        Context context = this.b;
        c0178d0.getClass();
        c0178d0.a(context, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
    }
}
