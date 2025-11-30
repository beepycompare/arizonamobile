package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class Rh implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0735z0 f663a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public Rh(C0735z0 c0735z0, Context context, ReporterConfig reporterConfig) {
        this.f663a = c0735z0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C0735z0 c0735z0 = this.f663a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c0735z0.getClass();
        return C0710y0.a(context).f().c(reporterConfig);
    }
}
