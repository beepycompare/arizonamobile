package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.a0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0102a0 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0128b0 f792a;
    public final /* synthetic */ Context b;

    public C0102a0(C0128b0 c0128b0, Context context) {
        this.f792a = c0128b0;
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0128b0 c0128b0 = this.f792a;
        Context context = this.b;
        c0128b0.getClass();
        c0128b0.a(context, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
    }
}
