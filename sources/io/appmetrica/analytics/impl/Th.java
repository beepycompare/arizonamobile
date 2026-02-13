package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* loaded from: classes5.dex */
public final class Th implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f800a;
    public final /* synthetic */ C0279gi b;

    public Th(C0279gi c0279gi, ReporterConfig reporterConfig) {
        this.b = c0279gi;
        this.f800a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        ReporterConfig reporterConfig = this.f800a;
        C0738z0 c0738z0 = c0279gi.f1015a;
        Context context = c0279gi.d;
        c0738z0.getClass();
        C0713y0.a(context).f().a(reporterConfig);
    }
}
