package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0486oi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f1135a;
    public final /* synthetic */ Ai b;

    public RunnableC0486oi(Ai ai, ReporterConfig reporterConfig) {
        this.b = ai;
        this.f1135a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        ReporterConfig reporterConfig = this.f1135a;
        B0 b0 = ai.f463a;
        Context context = ai.d;
        b0.getClass();
        A0.a(context).f().a(reporterConfig);
    }
}
