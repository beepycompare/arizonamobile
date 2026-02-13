package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.a0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0106a0 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0132b0 f893a;
    public final /* synthetic */ Context b;

    public C0106a0(C0132b0 c0132b0, Context context) {
        this.f893a = c0132b0;
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0132b0 c0132b0 = this.f893a;
        Context context = this.b;
        c0132b0.getClass();
        c0132b0.a(context, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
    }
}
