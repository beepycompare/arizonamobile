package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.jj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0357jj {

    /* renamed from: a  reason: collision with root package name */
    public final Revenue f1054a;
    public final C0698wn b;
    public final En c;
    public final En d;
    public final PublicLogger e;

    public C0357jj(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f1054a = revenue;
        this.b = new C0698wn(30720, "revenue payload", publicLogger);
        this.c = new En(new C0698wn(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new En(new C0776zn(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
