package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0168bi implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0625u0 f770a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public C0168bi(C0625u0 c0625u0, Context context, ReporterConfig reporterConfig) {
        this.f770a = c0625u0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C0625u0 c0625u0 = this.f770a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c0625u0.getClass();
        return C0600t0.a(context).f().c(reporterConfig);
    }
}
