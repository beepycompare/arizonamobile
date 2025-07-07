package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0245ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f822a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0245ei(C0568ri c0568ri, ReporterConfig reporterConfig) {
        this.b = c0568ri;
        this.f822a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        ReporterConfig reporterConfig = this.f822a;
        C0625u0 c0625u0 = c0568ri.f1028a;
        Context context = c0568ri.d;
        c0625u0.getClass();
        C0600t0.a(context).f().a(reporterConfig);
    }
}
