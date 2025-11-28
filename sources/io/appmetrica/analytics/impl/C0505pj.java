package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.pj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0505pj {

    /* renamed from: a  reason: collision with root package name */
    public final String f1058a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final C0579sj d;

    public C0505pj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, C0579sj c0579sj) {
        this.f1058a = str;
        this.b = context;
        int i = AbstractC0480oj.f1043a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = c0579sj;
    }
}
