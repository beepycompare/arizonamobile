package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Dc {

    /* renamed from: a  reason: collision with root package name */
    public final Ym f541a;
    public final Ym b;
    public final C0439n4 c;
    public final PublicLogger d;
    public final String e;

    public Dc(String str, PublicLogger publicLogger) {
        this(new C0439n4(30), new Ym(50, str.concat("map key"), publicLogger), new Ym(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public Dc(C0439n4 c0439n4, Ym ym, Ym ym2, String str, PublicLogger publicLogger) {
        this.c = c0439n4;
        this.f541a = ym;
        this.b = ym2;
        this.e = str;
        this.d = publicLogger;
    }
}
