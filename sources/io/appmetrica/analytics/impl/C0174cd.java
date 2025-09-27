package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.cd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0174cd {

    /* renamed from: a  reason: collision with root package name */
    public final C0261fn f824a;
    public final C0261fn b;
    public final K4 c;
    public final PublicLogger d;
    public final String e;

    public C0174cd(String str, PublicLogger publicLogger) {
        this(new K4(30), new C0261fn(50, str.concat("map key"), publicLogger), new C0261fn(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public C0174cd(K4 k4, C0261fn c0261fn, C0261fn c0261fn2, String str, PublicLogger publicLogger) {
        this.c = k4;
        this.f824a = c0261fn;
        this.b = c0261fn2;
        this.e = str;
        this.d = publicLogger;
    }
}
