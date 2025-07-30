package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0212di implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0619u0 f818a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public C0212di(C0619u0 c0619u0, Context context, ReporterConfig reporterConfig) {
        this.f818a = c0619u0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C0619u0 c0619u0 = this.f818a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c0619u0.getClass();
        return C0594t0.a(context).f().c(reporterConfig);
    }
}
