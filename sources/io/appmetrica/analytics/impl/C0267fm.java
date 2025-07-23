package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.fm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0267fm {
    public final Dm A;
    public final Map B;
    public final W9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f851a;
    public final String b;
    public final C0367jm c;
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
    public final G4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final Le s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C0747z3 y;
    public final C0546r2 z;

    public C0267fm(String str, String str2, C0367jm c0367jm) {
        this.f851a = str;
        this.b = str2;
        this.c = c0367jm;
        this.d = c0367jm.f917a;
        this.e = c0367jm.b;
        this.f = c0367jm.f;
        this.g = c0367jm.g;
        List list = c0367jm.h;
        this.h = c0367jm.i;
        this.i = c0367jm.c;
        this.j = c0367jm.d;
        String str3 = c0367jm.e;
        this.k = c0367jm.j;
        this.l = c0367jm.k;
        this.m = c0367jm.l;
        this.n = c0367jm.m;
        this.o = c0367jm.n;
        this.p = c0367jm.o;
        this.q = c0367jm.p;
        this.r = c0367jm.q;
        Hm hm = c0367jm.r;
        this.s = c0367jm.s;
        this.t = c0367jm.t;
        this.u = c0367jm.u;
        this.v = c0367jm.v;
        this.w = c0367jm.w;
        this.x = c0367jm.x;
        this.y = c0367jm.y;
        this.z = c0367jm.z;
        this.A = c0367jm.A;
        this.B = c0367jm.B;
        this.C = c0367jm.C;
    }

    public final String a() {
        return this.f851a;
    }

    public final String b() {
        return this.b;
    }

    public final long c() {
        return this.v;
    }

    public final long d() {
        return this.u;
    }

    public final String e() {
        return this.d;
    }

    public final String toString() {
        return "StartupState(deviceId=" + this.f851a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
