package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.km  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0389km {
    public final Im A;
    public final Map B;
    public final Y9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f942a;
    public final String b;
    public final C0490om c;
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
    public final Ne s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C0745z3 y;
    public final C0544r2 z;

    public C0389km(String str, String str2, C0490om c0490om) {
        this.f942a = str;
        this.b = str2;
        this.c = c0490om;
        this.d = c0490om.f1002a;
        this.e = c0490om.b;
        this.f = c0490om.f;
        this.g = c0490om.g;
        List list = c0490om.h;
        this.h = c0490om.i;
        this.i = c0490om.c;
        this.j = c0490om.d;
        String str3 = c0490om.e;
        this.k = c0490om.j;
        this.l = c0490om.k;
        this.m = c0490om.l;
        this.n = c0490om.m;
        this.o = c0490om.n;
        this.p = c0490om.o;
        this.q = c0490om.p;
        this.r = c0490om.q;
        Mm mm = c0490om.r;
        this.s = c0490om.s;
        this.t = c0490om.t;
        this.u = c0490om.u;
        this.v = c0490om.v;
        this.w = c0490om.w;
        this.x = c0490om.x;
        this.y = c0490om.y;
        this.z = c0490om.z;
        this.A = c0490om.A;
        this.B = c0490om.B;
        this.C = c0490om.C;
    }

    public final String a() {
        return this.f942a;
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
        return "StartupState(deviceId=" + this.f942a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
