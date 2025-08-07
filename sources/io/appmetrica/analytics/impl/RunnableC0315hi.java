package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.hi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0315hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f887a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0315hi(C0613ti c0613ti, ReporterConfig reporterConfig) {
        this.b = c0613ti;
        this.f887a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        ReporterConfig reporterConfig = this.f887a;
        C0620u0 c0620u0 = c0613ti.f1068a;
        Context context = c0613ti.d;
        c0620u0.getClass();
        C0595t0.a(context).f().a(reporterConfig);
    }
}
