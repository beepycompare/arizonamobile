package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0487oi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f1132a;
    public final /* synthetic */ Ai b;

    public RunnableC0487oi(Ai ai, ReporterConfig reporterConfig) {
        this.b = ai;
        this.f1132a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        ReporterConfig reporterConfig = this.f1132a;
        B0 b0 = ai.f460a;
        Context context = ai.d;
        b0.getClass();
        A0.a(context).f().a(reporterConfig);
    }
}
