package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Zc {

    /* renamed from: a  reason: collision with root package name */
    public final C0158bn f756a;
    public final C0158bn b;
    public final H4 c;
    public final PublicLogger d;
    public final String e;

    public Zc(String str, PublicLogger publicLogger) {
        this(new H4(30), new C0158bn(50, str.concat("map key"), publicLogger), new C0158bn(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public Zc(H4 h4, C0158bn c0158bn, C0158bn c0158bn2, String str, PublicLogger publicLogger) {
        this.c = h4;
        this.f756a = c0158bn;
        this.b = c0158bn2;
        this.e = str;
        this.d = publicLogger;
    }
}
