package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.fm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0256fm {
    public final Map A;
    public final B9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f1004a;
    public final String b;
    public final C0359jm c;
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
    public final C0392l4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final C0701xe s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0186d3 x;
    public final C0415m2 y;
    public final Cm z;

    public C0256fm(String str, String str2, C0359jm c0359jm) {
        this.f1004a = str;
        this.b = str2;
        this.c = c0359jm;
        this.d = c0359jm.f1073a;
        this.e = c0359jm.b;
        this.f = c0359jm.f;
        this.g = c0359jm.g;
        List list = c0359jm.h;
        this.h = c0359jm.i;
        this.i = c0359jm.c;
        this.j = c0359jm.d;
        String str3 = c0359jm.e;
        this.k = c0359jm.j;
        this.l = c0359jm.k;
        this.m = c0359jm.l;
        this.n = c0359jm.m;
        this.o = c0359jm.n;
        this.p = c0359jm.o;
        this.q = c0359jm.p;
        this.r = c0359jm.q;
        Gm gm = c0359jm.r;
        this.s = c0359jm.s;
        this.t = c0359jm.t;
        this.u = c0359jm.u;
        this.v = c0359jm.v;
        this.w = c0359jm.w;
        this.x = c0359jm.x;
        this.y = c0359jm.y;
        this.z = c0359jm.z;
        this.A = c0359jm.A;
        this.B = c0359jm.B;
    }

    public final String a() {
        return this.f1004a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final String toString() {
        return "StartupState(deviceId=" + this.f1004a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
