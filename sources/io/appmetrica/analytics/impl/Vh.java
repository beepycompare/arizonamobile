package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* loaded from: classes5.dex */
public final class Vh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f726a;
    public final /* synthetic */ C0301hi b;

    public Vh(C0301hi c0301hi, ReporterConfig reporterConfig) {
        this.b = c0301hi;
        this.f726a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        ReporterConfig reporterConfig = this.f726a;
        C0735z0 c0735z0 = c0301hi.f926a;
        Context context = c0301hi.d;
        c0735z0.getClass();
        C0710y0.a(context).f().a(reporterConfig);
    }
}
