package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0516pi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f1036a;
    public final /* synthetic */ Ci b;

    public RunnableC0516pi(Ci ci, ReporterConfig reporterConfig) {
        this.b = ci;
        this.f1036a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        ReporterConfig reporterConfig = this.f1036a;
        C0672w0 c0672w0 = ci.f393a;
        Context context = ci.d;
        c0672w0.getClass();
        C0647v0.a(context).f().a(reporterConfig);
    }
}
