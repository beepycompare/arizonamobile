package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0237ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f823a;
    public final /* synthetic */ C0560ri b;

    public RunnableC0237ei(C0560ri c0560ri, ReporterConfig reporterConfig) {
        this.b = c0560ri;
        this.f823a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        ReporterConfig reporterConfig = this.f823a;
        C0617u0 c0617u0 = c0560ri.f1029a;
        Context context = c0560ri.d;
        c0617u0.getClass();
        C0592t0.a(context).f().a(reporterConfig);
    }
}
