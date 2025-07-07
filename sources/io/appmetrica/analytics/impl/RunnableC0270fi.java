package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0270fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f840a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0270fi(C0568ri c0568ri, ReporterConfig reporterConfig) {
        this.b = c0568ri;
        this.f840a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        ReporterConfig reporterConfig = this.f840a;
        C0625u0 c0625u0 = c0568ri.f1028a;
        Context context = c0568ri.d;
        c0625u0.getClass();
        C0600t0.a(context).f().a(reporterConfig);
    }
}
