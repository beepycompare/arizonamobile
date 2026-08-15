package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.dd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0197dd {

    /* renamed from: a  reason: collision with root package name */
    public final C0776zn f946a;
    public final C0776zn b;
    public final D4 c;
    public final PublicLogger d;
    public final String e;

    public C0197dd(String str, PublicLogger publicLogger) {
        this(new D4(30), new C0776zn(50, str.concat("map key"), publicLogger), new C0776zn(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public C0197dd(D4 d4, C0776zn c0776zn, C0776zn c0776zn2, String str, PublicLogger publicLogger) {
        this.c = d4;
        this.f946a = c0776zn;
        this.b = c0776zn2;
        this.e = str;
        this.d = publicLogger;
    }
}
