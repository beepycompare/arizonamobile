package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Pi {

    /* renamed from: a  reason: collision with root package name */
    public final Revenue f637a;
    public final Vm b;
    public final C0228en c;
    public final C0228en d;
    public final PublicLogger e;

    public Pi(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f637a = revenue;
        this.b = new Vm(30720, "revenue payload", publicLogger);
        this.c = new C0228en(new Vm(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new C0228en(new Ym(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
