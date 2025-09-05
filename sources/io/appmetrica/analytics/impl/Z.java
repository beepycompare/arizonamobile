package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Z extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0109a0 f760a;
    public final /* synthetic */ Context b;

    public Z(C0109a0 c0109a0, Context context) {
        this.f760a = c0109a0;
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0109a0 c0109a0 = this.f760a;
        Context context = this.b;
        c0109a0.getClass();
        c0109a0.a(context, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
    }
}
