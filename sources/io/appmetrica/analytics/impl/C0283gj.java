package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.gj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0283gj {

    /* renamed from: a  reason: collision with root package name */
    public final Revenue f874a;
    public final Zm b;
    public final C0313hn c;
    public final C0313hn d;
    public final PublicLogger e;

    public C0283gj(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f874a = revenue;
        this.b = new Zm(30720, "revenue payload", publicLogger);
        this.c = new C0313hn(new Zm(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new C0313hn(new C0158bn(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
