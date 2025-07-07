package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.cm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0198cm {
    public final Am A;
    public final Map B;
    public final U9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f788a;
    public final String b;
    public final C0299gm c;
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
    public final Je s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C0753z3 y;
    public final C0552r2 z;

    public C0198cm(String str, String str2, C0299gm c0299gm) {
        this.f788a = str;
        this.b = str2;
        this.c = c0299gm;
        this.d = c0299gm.f857a;
        this.e = c0299gm.b;
        this.f = c0299gm.f;
        this.g = c0299gm.g;
        List list = c0299gm.h;
        this.h = c0299gm.i;
        this.i = c0299gm.c;
        this.j = c0299gm.d;
        String str3 = c0299gm.e;
        this.k = c0299gm.j;
        this.l = c0299gm.k;
        this.m = c0299gm.l;
        this.n = c0299gm.m;
        this.o = c0299gm.n;
        this.p = c0299gm.o;
        this.q = c0299gm.p;
        this.r = c0299gm.q;
        Em em = c0299gm.r;
        this.s = c0299gm.s;
        this.t = c0299gm.t;
        this.u = c0299gm.u;
        this.v = c0299gm.v;
        this.w = c0299gm.w;
        this.x = c0299gm.x;
        this.y = c0299gm.y;
        this.z = c0299gm.z;
        this.A = c0299gm.A;
        this.B = c0299gm.B;
        this.C = c0299gm.C;
    }

    public final String a() {
        return this.f788a;
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
        return "StartupState(deviceId=" + this.f788a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
