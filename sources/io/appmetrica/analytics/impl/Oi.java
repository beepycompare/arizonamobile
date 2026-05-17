package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Oi {

    /* renamed from: a  reason: collision with root package name */
    public final Revenue f731a;
    public final Um b;
    public final C0206dn c;
    public final C0206dn d;
    public final PublicLogger e;

    public Oi(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f731a = revenue;
        this.b = new Um(30720, "revenue payload", publicLogger);
        this.c = new C0206dn(new Um(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new C0206dn(new Xm(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
