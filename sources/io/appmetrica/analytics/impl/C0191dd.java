package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.dd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0191dd {

    /* renamed from: a  reason: collision with root package name */
    public final C0770zn f949a;
    public final C0770zn b;
    public final D4 c;
    public final PublicLogger d;
    public final String e;

    public C0191dd(String str, PublicLogger publicLogger) {
        this(new D4(30), new C0770zn(50, str.concat("map key"), publicLogger), new C0770zn(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public C0191dd(D4 d4, C0770zn c0770zn, C0770zn c0770zn2, String str, PublicLogger publicLogger) {
        this.c = d4;
        this.f949a = c0770zn;
        this.b = c0770zn2;
        this.e = str;
        this.d = publicLogger;
    }
}
