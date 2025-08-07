package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.fm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0268fm {
    public final Dm A;
    public final Map B;
    public final W9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f851a;
    public final String b;
    public final C0368jm c;
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
    public final C0748z3 y;
    public final C0547r2 z;

    public C0268fm(String str, String str2, C0368jm c0368jm) {
        this.f851a = str;
        this.b = str2;
        this.c = c0368jm;
        this.d = c0368jm.f917a;
        this.e = c0368jm.b;
        this.f = c0368jm.f;
        this.g = c0368jm.g;
        List list = c0368jm.h;
        this.h = c0368jm.i;
        this.i = c0368jm.c;
        this.j = c0368jm.d;
        String str3 = c0368jm.e;
        this.k = c0368jm.j;
        this.l = c0368jm.k;
        this.m = c0368jm.l;
        this.n = c0368jm.m;
        this.o = c0368jm.n;
        this.p = c0368jm.o;
        this.q = c0368jm.p;
        this.r = c0368jm.q;
        Hm hm = c0368jm.r;
        this.s = c0368jm.s;
        this.t = c0368jm.t;
        this.u = c0368jm.u;
        this.v = c0368jm.v;
        this.w = c0368jm.w;
        this.x = c0368jm.x;
        this.y = c0368jm.y;
        this.z = c0368jm.z;
        this.A = c0368jm.A;
        this.B = c0368jm.B;
        this.C = c0368jm.C;
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
