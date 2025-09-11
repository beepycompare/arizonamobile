package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0540qi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f1052a;
    public final /* synthetic */ Ci b;

    public RunnableC0540qi(Ci ci, ReporterConfig reporterConfig) {
        this.b = ci;
        this.f1052a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        ReporterConfig reporterConfig = this.f1052a;
        C0671w0 c0671w0 = ci.f392a;
        Context context = ci.d;
        c0671w0.getClass();
        C0646v0.a(context).f().a(reporterConfig);
    }
}
