package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.cd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0175cd {

    /* renamed from: a  reason: collision with root package name */
    public final C0262fn f824a;
    public final C0262fn b;
    public final K4 c;
    public final PublicLogger d;
    public final String e;

    public C0175cd(String str, PublicLogger publicLogger) {
        this(new K4(30), new C0262fn(50, str.concat("map key"), publicLogger), new C0262fn(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public C0175cd(K4 k4, C0262fn c0262fn, C0262fn c0262fn2, String str, PublicLogger publicLogger) {
        this.c = k4;
        this.f824a = c0262fn;
        this.b = c0262fn2;
        this.e = str;
        this.d = publicLogger;
    }
}
