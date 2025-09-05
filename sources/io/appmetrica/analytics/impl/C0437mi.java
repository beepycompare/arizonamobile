package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* renamed from: io.appmetrica.analytics.impl.mi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0437mi implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0671w0 f989a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public C0437mi(C0671w0 c0671w0, Context context, ReporterConfig reporterConfig) {
        this.f989a = c0671w0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C0671w0 c0671w0 = this.f989a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c0671w0.getClass();
        return C0646v0.a(context).f().c(reporterConfig);
    }
}
