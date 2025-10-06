package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0541qi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f1053a;
    public final /* synthetic */ Ci b;

    public RunnableC0541qi(Ci ci, ReporterConfig reporterConfig) {
        this.b = ci;
        this.f1053a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        ReporterConfig reporterConfig = this.f1053a;
        C0672w0 c0672w0 = ci.f393a;
        Context context = ci.d;
        c0672w0.getClass();
        C0647v0.a(context).f().a(reporterConfig);
    }
}
