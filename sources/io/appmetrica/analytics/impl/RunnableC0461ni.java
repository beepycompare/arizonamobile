package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.ni  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0461ni implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f1116a;
    public final /* synthetic */ Ai b;

    public RunnableC0461ni(Ai ai, ReporterConfig reporterConfig) {
        this.b = ai;
        this.f1116a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        ReporterConfig reporterConfig = this.f1116a;
        B0 b0 = ai.f460a;
        Context context = ai.d;
        b0.getClass();
        A0.a(context).f().a(reporterConfig);
    }
}
