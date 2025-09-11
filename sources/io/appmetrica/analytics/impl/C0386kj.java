package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.kj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0386kj {

    /* renamed from: a  reason: collision with root package name */
    public final Revenue f956a;
    public final C0210dn b;
    public final C0416ln c;
    public final C0416ln d;
    public final PublicLogger e;

    public C0386kj(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f956a = revenue;
        this.b = new C0210dn(30720, "revenue payload", publicLogger);
        this.c = new C0416ln(new C0210dn(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new C0416ln(new C0261fn(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
