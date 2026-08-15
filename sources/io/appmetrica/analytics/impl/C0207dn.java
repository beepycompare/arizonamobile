package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.dn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0207dn {

    /* renamed from: a  reason: collision with root package name */
    public final Context f952a;
    public final String b;
    public final Bm c;
    public final C0309hm d;
    public final Jm e;
    public final M4 f;
    public final Gm g;
    public final C0217e8 h;
    public final SystemTimeProvider i;
    public final Q3 j;
    public final T3 k;
    public final C0386km l;
    public final Vd m;

    public C0207dn(Context context, String str, Bm bm, C0309hm c0309hm) {
        this.f952a = context;
        this.b = str;
        this.c = bm;
        this.d = c0309hm;
        Jm A = Na.k().A();
        this.e = A;
        Hm a2 = A.a();
        this.f = new M4(str);
        this.g = new Gm(context);
        this.h = new C0217e8();
        this.i = new SystemTimeProvider();
        this.j = Na.k().f();
        this.k = new T3();
        this.l = new C0386km(new Cm(context, str), a2, bm);
        this.m = Na.k().q();
    }
}
