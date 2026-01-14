package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.am  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0128am extends M5 {
    public final C0741z3 b;

    public C0128am(Context context, String str) {
        this(context, str, new SafePackageManager(), C0449na.k().f());
    }

    @Override // io.appmetrica.analytics.impl.M5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0154bm load(L5 l5) {
        C0154bm c0154bm = (C0154bm) super.load(l5);
        C0257fm c0257fm = l5.f672a;
        c0154bm.d = c0257fm.f;
        c0154bm.e = c0257fm.g;
        Zl zl = (Zl) l5.componentArguments;
        String str = zl.f892a;
        if (str != null) {
            c0154bm.f = str;
            c0154bm.g = zl.b;
        }
        Map<String, String> map = zl.c;
        c0154bm.h = map;
        c0154bm.i = (C0541r3) this.b.a(new C0541r3(map, S7.c));
        Zl zl2 = (Zl) l5.componentArguments;
        c0154bm.k = zl2.d;
        c0154bm.j = zl2.e;
        C0257fm c0257fm2 = l5.f672a;
        c0154bm.l = c0257fm2.p;
        c0154bm.m = c0257fm2.r;
        long j = c0257fm2.v;
        if (c0154bm.n == 0) {
            c0154bm.n = j;
        }
        return c0154bm;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0154bm();
    }

    public C0128am(Context context, String str, SafePackageManager safePackageManager, C0741z3 c0741z3) {
        super(context, str, safePackageManager);
        this.b = c0741z3;
    }

    public final C0154bm a() {
        return new C0154bm();
    }
}
