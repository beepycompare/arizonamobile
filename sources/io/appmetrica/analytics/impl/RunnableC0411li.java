package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* renamed from: io.appmetrica.analytics.impl.li  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0411li implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f953a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0411li(C0735yi c0735yi, ReporterConfig reporterConfig) {
        this.b = c0735yi;
        this.f953a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        ReporterConfig reporterConfig = this.f953a;
        C0617u0 c0617u0 = c0735yi.f1162a;
        Context context = c0735yi.d;
        c0617u0.getClass();
        C0592t0.a(context).f().a(reporterConfig);
    }
}
