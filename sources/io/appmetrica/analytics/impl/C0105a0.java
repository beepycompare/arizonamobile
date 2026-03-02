package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.a0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0105a0 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0131b0 f893a;
    public final /* synthetic */ Context b;

    public C0105a0(C0131b0 c0131b0, Context context) {
        this.f893a = c0131b0;
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0131b0 c0131b0 = this.f893a;
        Context context = this.b;
        c0131b0.getClass();
        c0131b0.a(context, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
    }
}
