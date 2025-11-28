package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0227em extends T5 {
    public final H3 b;

    public C0227em(Context context, String str) {
        this(context, str, new SafePackageManager(), C0620ua.k().f());
    }

    @Override // io.appmetrica.analytics.impl.T5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0253fm load(S5 s5) {
        C0253fm c0253fm = (C0253fm) super.load(s5);
        C0356jm c0356jm = s5.f677a;
        c0253fm.d = c0356jm.f;
        c0253fm.e = c0356jm.g;
        C0202dm c0202dm = (C0202dm) s5.componentArguments;
        String str = c0202dm.f851a;
        if (str != null) {
            c0253fm.f = str;
            c0253fm.g = c0202dm.b;
        }
        Map<String, String> map = c0202dm.c;
        c0253fm.h = map;
        c0253fm.i = (C0738z3) this.b.a(new C0738z3(map, Y7.c));
        C0202dm c0202dm2 = (C0202dm) s5.componentArguments;
        c0253fm.k = c0202dm2.d;
        c0253fm.j = c0202dm2.e;
        C0356jm c0356jm2 = s5.f677a;
        c0253fm.l = c0356jm2.p;
        c0253fm.m = c0356jm2.r;
        long j = c0356jm2.v;
        if (c0253fm.n == 0) {
            c0253fm.n = j;
        }
        return c0253fm;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0253fm();
    }

    public C0227em(Context context, String str, SafePackageManager safePackageManager, H3 h3) {
        super(context, str, safePackageManager);
        this.b = h3;
    }

    public final C0253fm a() {
        return new C0253fm();
    }
}
