package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.bm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0150bm extends N5 {
    public final A3 b;

    public C0150bm(Context context, String str) {
        this(context, str, new SafePackageManager(), C0471oa.k().f());
    }

    @Override // io.appmetrica.analytics.impl.N5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0176cm load(M5 m5) {
        C0176cm c0176cm = (C0176cm) super.load(m5);
        C0279gm c0279gm = m5.f583a;
        c0176cm.d = c0279gm.f;
        c0176cm.e = c0279gm.g;
        C0124am c0124am = (C0124am) m5.componentArguments;
        String str = c0124am.f804a;
        if (str != null) {
            c0176cm.f = str;
            c0176cm.g = c0124am.b;
        }
        Map<String, String> map = c0124am.c;
        c0176cm.h = map;
        c0176cm.i = (C0563s3) this.b.a(new C0563s3(map, T7.c));
        C0124am c0124am2 = (C0124am) m5.componentArguments;
        c0176cm.k = c0124am2.d;
        c0176cm.j = c0124am2.e;
        C0279gm c0279gm2 = m5.f583a;
        c0176cm.l = c0279gm2.p;
        c0176cm.m = c0279gm2.r;
        long j = c0279gm2.v;
        if (c0176cm.n == 0) {
            c0176cm.n = j;
        }
        return c0176cm;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0176cm();
    }

    public C0150bm(Context context, String str, SafePackageManager safePackageManager, A3 a3) {
        super(context, str, safePackageManager);
        this.b = a3;
    }

    public final C0176cm a() {
        return new C0176cm();
    }
}
