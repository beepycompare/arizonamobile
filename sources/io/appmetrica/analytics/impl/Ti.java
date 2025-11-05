package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes3.dex */
public final class Ti {

    /* renamed from: a  reason: collision with root package name */
    public final Revenue f708a;
    public final Ym b;
    public final C0280gn c;
    public final C0280gn d;
    public final PublicLogger e;

    public Ti(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f708a = revenue;
        this.b = new Ym(30720, "revenue payload", publicLogger);
        this.c = new C0280gn(new Ym(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new C0280gn(new C0125an(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
