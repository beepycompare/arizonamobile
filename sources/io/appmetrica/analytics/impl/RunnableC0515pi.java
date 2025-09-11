package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0515pi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f1035a;
    public final /* synthetic */ Ci b;

    public RunnableC0515pi(Ci ci, ReporterConfig reporterConfig) {
        this.b = ci;
        this.f1035a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        ReporterConfig reporterConfig = this.f1035a;
        C0671w0 c0671w0 = ci.f392a;
        Context context = ci.d;
        c0671w0.getClass();
        C0646v0.a(context).f().a(reporterConfig);
    }
}
