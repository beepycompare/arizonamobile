package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.kj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0383kj {

    /* renamed from: a  reason: collision with root package name */
    public final String f1083a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final C0458nj d;

    public C0383kj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, C0458nj c0458nj) {
        this.f1083a = str;
        this.b = context;
        int i = AbstractC0357jj.f1067a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = c0458nj;
    }
}
