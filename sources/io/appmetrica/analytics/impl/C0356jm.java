package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0356jm {
    public final Map A;
    public final I9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f959a;
    public final String b;
    public final C0458nm c;
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
    public final C0564s4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final De s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0389l3 x;
    public final C0612u2 y;
    public final Gm z;

    public C0356jm(String str, String str2, C0458nm c0458nm) {
        this.f959a = str;
        this.b = str2;
        this.c = c0458nm;
        this.d = c0458nm.f1028a;
        this.e = c0458nm.b;
        this.f = c0458nm.f;
        this.g = c0458nm.g;
        List list = c0458nm.h;
        this.h = c0458nm.i;
        this.i = c0458nm.c;
        this.j = c0458nm.d;
        String str3 = c0458nm.e;
        this.k = c0458nm.j;
        this.l = c0458nm.k;
        this.m = c0458nm.l;
        this.n = c0458nm.m;
        this.o = c0458nm.n;
        this.p = c0458nm.o;
        this.q = c0458nm.p;
        this.r = c0458nm.q;
        Km km = c0458nm.r;
        this.s = c0458nm.s;
        this.t = c0458nm.t;
        this.u = c0458nm.u;
        this.v = c0458nm.v;
        this.w = c0458nm.w;
        this.x = c0458nm.x;
        this.y = c0458nm.y;
        this.z = c0458nm.z;
        this.A = c0458nm.A;
        this.B = c0458nm.B;
    }

    public final String a() {
        return this.f959a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final String toString() {
        return "StartupState(deviceId=" + this.f959a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
