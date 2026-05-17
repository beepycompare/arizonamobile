package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* loaded from: classes5.dex */
public final class Uh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f819a;
    public final /* synthetic */ C0278gi b;

    public Uh(C0278gi c0278gi, ReporterConfig reporterConfig) {
        this.b = c0278gi;
        this.f819a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        ReporterConfig reporterConfig = this.f819a;
        C0737z0 c0737z0 = c0278gi.f1020a;
        Context context = c0278gi.d;
        c0737z0.getClass();
        C0712y0.a(context).f().a(reporterConfig);
    }
}
