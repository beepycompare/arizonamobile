package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.cm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0190cm {
    public final Am A;
    public final Map B;
    public final U9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f789a;
    public final String b;
    public final C0291gm c;
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
    public final C0745z3 y;
    public final C0544r2 z;

    public C0190cm(String str, String str2, C0291gm c0291gm) {
        this.f789a = str;
        this.b = str2;
        this.c = c0291gm;
        this.d = c0291gm.f858a;
        this.e = c0291gm.b;
        this.f = c0291gm.f;
        this.g = c0291gm.g;
        List list = c0291gm.h;
        this.h = c0291gm.i;
        this.i = c0291gm.c;
        this.j = c0291gm.d;
        String str3 = c0291gm.e;
        this.k = c0291gm.j;
        this.l = c0291gm.k;
        this.m = c0291gm.l;
        this.n = c0291gm.m;
        this.o = c0291gm.n;
        this.p = c0291gm.o;
        this.q = c0291gm.p;
        this.r = c0291gm.q;
        Em em = c0291gm.r;
        this.s = c0291gm.s;
        this.t = c0291gm.t;
        this.u = c0291gm.u;
        this.v = c0291gm.v;
        this.w = c0291gm.w;
        this.x = c0291gm.x;
        this.y = c0291gm.y;
        this.z = c0291gm.z;
        this.A = c0291gm.A;
        this.B = c0291gm.B;
        this.C = c0291gm.C;
    }

    public final String a() {
        return this.f789a;
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
        return "StartupState(deviceId=" + this.f789a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
