package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.gm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0278gm {
    public final Map A;
    public final C9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f994a;
    public final String b;
    public final C0381km c;
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
    public final C0414m4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final C0723ye s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0207e3 x;
    public final C0437n2 y;
    public final Dm z;

    public C0278gm(String str, String str2, C0381km c0381km) {
        this.f994a = str;
        this.b = str2;
        this.c = c0381km;
        this.d = c0381km.f1064a;
        this.e = c0381km.b;
        this.f = c0381km.f;
        this.g = c0381km.g;
        List list = c0381km.h;
        this.h = c0381km.i;
        this.i = c0381km.c;
        this.j = c0381km.d;
        String str3 = c0381km.e;
        this.k = c0381km.j;
        this.l = c0381km.k;
        this.m = c0381km.l;
        this.n = c0381km.m;
        this.o = c0381km.n;
        this.p = c0381km.o;
        this.q = c0381km.p;
        this.r = c0381km.q;
        Hm hm = c0381km.r;
        this.s = c0381km.s;
        this.t = c0381km.t;
        this.u = c0381km.u;
        this.v = c0381km.v;
        this.w = c0381km.w;
        this.x = c0381km.x;
        this.y = c0381km.y;
        this.z = c0381km.z;
        this.A = c0381km.A;
        this.B = c0381km.B;
    }

    public final String a() {
        return this.f994a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final String toString() {
        return "StartupState(deviceId=" + this.f994a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
