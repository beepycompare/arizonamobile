package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Vc {

    /* renamed from: a  reason: collision with root package name */
    public final Tm f671a;
    public final Tm b;
    public final H4 c;
    public final PublicLogger d;
    public final String e;

    public Vc(String str, PublicLogger publicLogger) {
        this(new H4(30), new Tm(50, str.concat("map key"), publicLogger), new Tm(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public Vc(H4 h4, Tm tm, Tm tm2, String str, PublicLogger publicLogger) {
        this.c = h4;
        this.f671a = tm;
        this.b = tm2;
        this.e = str;
        this.d = publicLogger;
    }
}
