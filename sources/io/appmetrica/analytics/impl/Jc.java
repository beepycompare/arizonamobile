package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes3.dex */
public final class Jc {

    /* renamed from: a  reason: collision with root package name */
    public final C0125an f545a;
    public final C0125an b;
    public final C0589t4 c;
    public final PublicLogger d;
    public final String e;

    public Jc(String str, PublicLogger publicLogger) {
        this(new C0589t4(30), new C0125an(50, str.concat("map key"), publicLogger), new C0125an(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public Jc(C0589t4 c0589t4, C0125an c0125an, C0125an c0125an2, String str, PublicLogger publicLogger) {
        this.c = c0589t4;
        this.f545a = c0125an;
        this.b = c0125an2;
        this.e = str;
        this.d = publicLogger;
    }
}
