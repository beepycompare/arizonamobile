package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.kj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0387kj {

    /* renamed from: a  reason: collision with root package name */
    public final Revenue f957a;
    public final C0211dn b;
    public final C0417ln c;
    public final C0417ln d;
    public final PublicLogger e;

    public C0387kj(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f957a = revenue;
        this.b = new C0211dn(30720, "revenue payload", publicLogger);
        this.c = new C0417ln(new C0211dn(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new C0417ln(new C0262fn(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
