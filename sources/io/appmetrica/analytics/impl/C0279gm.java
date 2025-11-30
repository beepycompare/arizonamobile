package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.gm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0279gm {
    public final Map A;
    public final C9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f911a;
    public final String b;
    public final C0382km c;
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
    public final C0415m4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final C0724ye s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0208e3 x;
    public final C0438n2 y;
    public final Dm z;

    public C0279gm(String str, String str2, C0382km c0382km) {
        this.f911a = str;
        this.b = str2;
        this.c = c0382km;
        this.d = c0382km.f981a;
        this.e = c0382km.b;
        this.f = c0382km.f;
        this.g = c0382km.g;
        List list = c0382km.h;
        this.h = c0382km.i;
        this.i = c0382km.c;
        this.j = c0382km.d;
        String str3 = c0382km.e;
        this.k = c0382km.j;
        this.l = c0382km.k;
        this.m = c0382km.l;
        this.n = c0382km.m;
        this.o = c0382km.n;
        this.p = c0382km.o;
        this.q = c0382km.p;
        this.r = c0382km.q;
        Hm hm = c0382km.r;
        this.s = c0382km.s;
        this.t = c0382km.t;
        this.u = c0382km.u;
        this.v = c0382km.v;
        this.w = c0382km.w;
        this.x = c0382km.x;
        this.y = c0382km.y;
        this.z = c0382km.z;
        this.A = c0382km.A;
        this.B = c0382km.B;
    }

    public final String a() {
        return this.f911a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final String toString() {
        return "StartupState(deviceId=" + this.f911a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
