package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Cm extends AbstractC0165c6 {
    public final Q3 b;

    public Cm(Context context, String str) {
        this(context, str, new SafePackageManager(), Na.k().f());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0165c6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final Dm load(C0139b6 c0139b6) {
        Dm dm = (Dm) super.load(c0139b6);
        Hm hm = c0139b6.f904a;
        dm.d = hm.f;
        dm.e = hm.g;
        Bm bm = (Bm) c0139b6.componentArguments;
        String str = bm.f484a;
        if (str != null) {
            dm.f = str;
            dm.g = bm.b;
        }
        Map<String, String> map = bm.c;
        dm.h = map;
        dm.i = (I3) this.b.a(new I3(map, EnumC0399l8.d));
        Bm bm2 = (Bm) c0139b6.componentArguments;
        dm.k = bm2.d;
        dm.j = bm2.e;
        Hm hm2 = c0139b6.f904a;
        dm.l = hm2.p;
        dm.m = hm2.r;
        long j = hm2.v;
        if (dm.n == 0) {
            dm.n = j;
        }
        return dm;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new Dm();
    }

    public Cm(Context context, String str, SafePackageManager safePackageManager, Q3 q3) {
        super(context, str, safePackageManager);
        this.b = q3;
    }

    public final Dm a() {
        return new Dm();
    }
}
