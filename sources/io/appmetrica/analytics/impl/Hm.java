package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Hm {
    public final Map A;
    public final W9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f584a;
    public final String b;
    public final Lm c;
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
    public final C4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final Ye s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0600t3 x;
    public final C0755z2 y;
    public final C0232en z;

    public Hm(String str, String str2, Lm lm) {
        this.f584a = str;
        this.b = str2;
        this.c = lm;
        this.d = lm.f653a;
        this.e = lm.b;
        this.f = lm.f;
        this.g = lm.g;
        List list = lm.h;
        this.h = lm.i;
        this.i = lm.c;
        this.j = lm.d;
        String str3 = lm.e;
        this.k = lm.j;
        this.l = lm.k;
        this.m = lm.l;
        this.n = lm.m;
        this.o = lm.n;
        this.p = lm.o;
        this.q = lm.p;
        this.r = lm.q;
        C0335in c0335in = lm.r;
        this.s = lm.s;
        this.t = lm.t;
        this.u = lm.u;
        this.v = lm.v;
        this.w = lm.w;
        this.x = lm.x;
        this.y = lm.y;
        this.z = lm.z;
        this.A = lm.A;
        this.B = lm.B;
    }

    public final String a() {
        return this.f584a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final String toString() {
        return "StartupState(deviceId=" + this.f584a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
