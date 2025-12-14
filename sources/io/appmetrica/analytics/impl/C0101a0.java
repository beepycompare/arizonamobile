package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.a0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0101a0 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0127b0 f884a;
    public final /* synthetic */ Context b;

    public C0101a0(C0127b0 c0127b0, Context context) {
        this.f884a = c0127b0;
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0127b0 c0127b0 = this.f884a;
        Context context = this.b;
        c0127b0.getClass();
        c0127b0.a(context, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
    }
}
