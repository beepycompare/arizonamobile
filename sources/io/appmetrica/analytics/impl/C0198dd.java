package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.dd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0198dd {

    /* renamed from: a  reason: collision with root package name */
    public final C0777zn f943a;
    public final C0777zn b;
    public final D4 c;
    public final PublicLogger d;
    public final String e;

    public C0198dd(String str, PublicLogger publicLogger) {
        this(new D4(30), new C0777zn(50, str.concat("map key"), publicLogger), new C0777zn(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public C0198dd(D4 d4, C0777zn c0777zn, C0777zn c0777zn2, String str, PublicLogger publicLogger) {
        this.c = d4;
        this.f943a = c0777zn;
        this.b = c0777zn2;
        this.e = str;
        this.d = publicLogger;
    }
}
