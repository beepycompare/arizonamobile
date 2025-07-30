package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Xc {

    /* renamed from: a  reason: collision with root package name */
    public final Wm f717a;
    public final Wm b;
    public final H4 c;
    public final PublicLogger d;
    public final String e;

    public Xc(String str, PublicLogger publicLogger) {
        this(new H4(30), new Wm(50, str.concat("map key"), publicLogger), new Wm(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public Xc(H4 h4, Wm wm, Wm wm2, String str, PublicLogger publicLogger) {
        this.c = h4;
        this.f717a = wm;
        this.b = wm2;
        this.e = str;
        this.d = publicLogger;
    }
}
