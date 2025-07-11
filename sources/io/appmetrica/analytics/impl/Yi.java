package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Yi {

    /* renamed from: a  reason: collision with root package name */
    public final Revenue f725a;
    public final Rm b;
    public final Zm c;
    public final Zm d;
    public final PublicLogger e;

    public Yi(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f725a = revenue;
        this.b = new Rm(30720, "revenue payload", publicLogger);
        this.c = new Zm(new Rm(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new Zm(new Tm(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
