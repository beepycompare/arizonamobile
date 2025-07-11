package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.uj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0636uj {

    /* renamed from: a  reason: collision with root package name */
    public final String f1079a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final C0711xj d;

    public C0636uj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, C0711xj c0711xj) {
        this.f1079a = str;
        this.b = context;
        int i = AbstractC0611tj.f1063a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = c0711xj;
    }
}
