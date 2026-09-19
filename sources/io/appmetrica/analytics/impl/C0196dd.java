package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.dd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0196dd {

    /* renamed from: a  reason: collision with root package name */
    public final C0775zn f946a;
    public final C0775zn b;
    public final D4 c;
    public final PublicLogger d;
    public final String e;

    public C0196dd(String str, PublicLogger publicLogger) {
        this(new D4(30), new C0775zn(50, str.concat("map key"), publicLogger), new C0775zn(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public C0196dd(D4 d4, C0775zn c0775zn, C0775zn c0775zn2, String str, PublicLogger publicLogger) {
        this.c = d4;
        this.f946a = c0775zn;
        this.b = c0775zn2;
        this.e = str;
        this.d = publicLogger;
    }
}
