package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* loaded from: classes5.dex */
public final class Vh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f809a;
    public final /* synthetic */ C0300hi b;

    public Vh(C0300hi c0300hi, ReporterConfig reporterConfig) {
        this.b = c0300hi;
        this.f809a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        ReporterConfig reporterConfig = this.f809a;
        C0734z0 c0734z0 = c0300hi.f1009a;
        Context context = c0300hi.d;
        c0734z0.getClass();
        C0709y0.a(context).f().a(reporterConfig);
    }
}
