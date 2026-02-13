package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Cc {

    /* renamed from: a  reason: collision with root package name */
    public final Xm f532a;
    public final Xm b;
    public final C0418m4 c;
    public final PublicLogger d;
    public final String e;

    public Cc(String str, PublicLogger publicLogger) {
        this(new C0418m4(30), new Xm(50, str.concat("map key"), publicLogger), new Xm(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public Cc(C0418m4 c0418m4, Xm xm, Xm xm2, String str, PublicLogger publicLogger) {
        this.c = c0418m4;
        this.f532a = xm;
        this.b = xm2;
        this.e = str;
        this.d = publicLogger;
    }
}
