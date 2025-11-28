package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
/* loaded from: classes5.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f789a;
    public final /* synthetic */ C0404li b;

    public Zh(C0404li c0404li, ReporterConfig reporterConfig) {
        this.b = c0404li;
        this.f789a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        ReporterConfig reporterConfig = this.f789a;
        C0685x0 c0685x0 = c0404li.f993a;
        Context context = c0404li.d;
        c0685x0.getClass();
        C0660w0.a(context).f().a(reporterConfig);
    }
}
