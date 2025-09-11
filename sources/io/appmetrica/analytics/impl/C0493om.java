package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.om  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0493om {
    public final Mm A;
    public final Map B;
    public final C0145ba C;

    /* renamed from: a  reason: collision with root package name */
    public final String f1024a;
    public final String b;
    public final C0593sm c;
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
    public final C0598t2 z;

    public C0493om(String str, String str2, C0593sm c0593sm) {
        this.f1024a = str;
        this.b = str2;
        this.c = c0593sm;
        this.d = c0593sm.f1084a;
        this.e = c0593sm.b;
        this.f = c0593sm.f;
        this.g = c0593sm.g;
        List list = c0593sm.h;
        this.h = c0593sm.i;
        this.i = c0593sm.c;
        this.j = c0593sm.d;
        String str3 = c0593sm.e;
        this.k = c0593sm.j;
        this.l = c0593sm.k;
        this.m = c0593sm.l;
        this.n = c0593sm.m;
        this.o = c0593sm.n;
        this.p = c0593sm.o;
        this.q = c0593sm.p;
        this.r = c0593sm.q;
        Qm qm = c0593sm.r;
        this.s = c0593sm.s;
        this.t = c0593sm.t;
        this.u = c0593sm.u;
        this.v = c0593sm.v;
        this.w = c0593sm.w;
        this.x = c0593sm.x;
        this.y = c0593sm.y;
        this.z = c0593sm.z;
        this.A = c0593sm.A;
        this.B = c0593sm.B;
        this.C = c0593sm.C;
    }

    public final String a() {
        return this.f1024a;
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
        return "StartupState(deviceId=" + this.f1024a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
