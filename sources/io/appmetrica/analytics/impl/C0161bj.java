package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.bj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0161bj {

    /* renamed from: a  reason: collision with root package name */
    public final Revenue f787a;
    public final Um b;
    public final C0191cn c;
    public final C0191cn d;
    public final PublicLogger e;

    public C0161bj(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f787a = revenue;
        this.b = new Um(30720, "revenue payload", publicLogger);
        this.c = new C0191cn(new Um(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new C0191cn(new Wm(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
