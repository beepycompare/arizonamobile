package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.gi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0289gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f867a;
    public final /* synthetic */ C0612ti b;

    public RunnableC0289gi(C0612ti c0612ti, ReporterConfig reporterConfig) {
        this.b = c0612ti;
        this.f867a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        ReporterConfig reporterConfig = this.f867a;
        C0619u0 c0619u0 = c0612ti.f1068a;
        Context context = c0612ti.d;
        c0619u0.getClass();
        C0594t0.a(context).f().a(reporterConfig);
    }
}
