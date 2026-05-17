package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.kj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0382kj {

    /* renamed from: a  reason: collision with root package name */
    public final String f1088a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final C0457nj d;

    public C0382kj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, C0457nj c0457nj) {
        this.f1088a = str;
        this.b = context;
        int i = AbstractC0356jj.f1072a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = c0457nj;
    }
}
