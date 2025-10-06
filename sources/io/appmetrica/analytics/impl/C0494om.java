package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.om  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0494om {
    public final Mm A;
    public final Map B;
    public final C0146ba C;

    /* renamed from: a  reason: collision with root package name */
    public final String f1025a;
    public final String b;
    public final C0594sm c;
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
    public final J4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final Re s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C3 y;
    public final C0599t2 z;

    public C0494om(String str, String str2, C0594sm c0594sm) {
        this.f1025a = str;
        this.b = str2;
        this.c = c0594sm;
        this.d = c0594sm.f1085a;
        this.e = c0594sm.b;
        this.f = c0594sm.f;
        this.g = c0594sm.g;
        List list = c0594sm.h;
        this.h = c0594sm.i;
        this.i = c0594sm.c;
        this.j = c0594sm.d;
        String str3 = c0594sm.e;
        this.k = c0594sm.j;
        this.l = c0594sm.k;
        this.m = c0594sm.l;
        this.n = c0594sm.m;
        this.o = c0594sm.n;
        this.p = c0594sm.o;
        this.q = c0594sm.p;
        this.r = c0594sm.q;
        Qm qm = c0594sm.r;
        this.s = c0594sm.s;
        this.t = c0594sm.t;
        this.u = c0594sm.u;
        this.v = c0594sm.v;
        this.w = c0594sm.w;
        this.x = c0594sm.x;
        this.y = c0594sm.y;
        this.z = c0594sm.z;
        this.A = c0594sm.A;
        this.B = c0594sm.B;
        this.C = c0594sm.C;
    }

    public final String a() {
        return this.f1025a;
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
        return "StartupState(deviceId=" + this.f1025a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
