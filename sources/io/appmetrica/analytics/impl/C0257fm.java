package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.fm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0257fm {
    public final Map A;
    public final B9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f1000a;
    public final String b;
    public final C0360jm c;
    public final String d;
    public final List e;
    public final List f;
    public final List g;
    public final Map h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final C0393l4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final C0702xe s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0187d3 x;
    public final C0416m2 y;
    public final Cm z;

    public C0257fm(String str, String str2, C0360jm c0360jm) {
        this.f1000a = str;
        this.b = str2;
        this.c = c0360jm;
        this.d = c0360jm.f1069a;
        this.e = c0360jm.b;
        this.f = c0360jm.f;
        this.g = c0360jm.g;
        List list = c0360jm.h;
        this.h = c0360jm.i;
        this.i = c0360jm.c;
        this.j = c0360jm.d;
        String str3 = c0360jm.e;
        this.k = c0360jm.j;
        this.l = c0360jm.k;
        this.m = c0360jm.l;
        this.n = c0360jm.m;
        this.o = c0360jm.n;
        this.p = c0360jm.o;
        this.q = c0360jm.p;
        this.r = c0360jm.q;
        Gm gm = c0360jm.r;
        this.s = c0360jm.s;
        this.t = c0360jm.t;
        this.u = c0360jm.u;
        this.v = c0360jm.v;
        this.w = c0360jm.w;
        this.x = c0360jm.x;
        this.y = c0360jm.y;
        this.z = c0360jm.z;
        this.A = c0360jm.A;
        this.B = c0360jm.B;
    }

    public final String a() {
        return this.f1000a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final String toString() {
        return "StartupState(deviceId=" + this.f1000a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
