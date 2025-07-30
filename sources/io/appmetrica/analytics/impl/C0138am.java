package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.am  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0138am extends AbstractC0327i6 {
    public final V3 b;

    public C0138am(Context context, String str) {
        this(context, str, new SafePackageManager(), Ia.j().e());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0327i6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0164bm load(C0302h6 c0302h6) {
        C0164bm c0164bm = (C0164bm) super.load(c0302h6);
        C0267fm c0267fm = c0302h6.f879a;
        c0164bm.d = c0267fm.f;
        c0164bm.e = c0267fm.g;
        Zl zl = (Zl) c0302h6.componentArguments;
        String str = zl.f755a;
        if (str != null) {
            c0164bm.f = str;
            c0164bm.g = zl.b;
        }
        Map<String, String> map = zl.c;
        c0164bm.h = map;
        c0164bm.i = (N3) this.b.a(new N3(map, EnumC0403l8.c));
        Zl zl2 = (Zl) c0302h6.componentArguments;
        c0164bm.k = zl2.d;
        c0164bm.j = zl2.e;
        C0267fm c0267fm2 = c0302h6.f879a;
        c0164bm.l = c0267fm2.p;
        c0164bm.m = c0267fm2.r;
        long j = c0267fm2.v;
        if (c0164bm.n == 0) {
            c0164bm.n = j;
        }
        return c0164bm;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0164bm();
    }

    public C0138am(Context context, String str, SafePackageManager safePackageManager, V3 v3) {
        super(context, str, safePackageManager);
        this.b = v3;
    }

    public final C0164bm a() {
        return new C0164bm();
    }
}
