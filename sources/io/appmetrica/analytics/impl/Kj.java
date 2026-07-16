package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes5.dex */
public final class Kj {

    /* renamed from: a  reason: collision with root package name */
    public final String f632a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final Nj d;

    public Kj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, Nj nj) {
        this.f632a = str;
        this.b = context;
        int i = Jj.f617a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = nj;
    }
}
