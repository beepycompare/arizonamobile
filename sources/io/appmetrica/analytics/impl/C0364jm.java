package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0364jm extends AbstractC0400l6 {
    public final Y3 b;

    public C0364jm(Context context, String str) {
        this(context, str, new SafePackageManager(), Na.j().e());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0400l6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0390km load(C0374k6 c0374k6) {
        C0390km c0390km = (C0390km) super.load(c0374k6);
        C0494om c0494om = c0374k6.f950a;
        c0390km.d = c0494om.f;
        c0390km.e = c0494om.g;
        C0338im c0338im = (C0338im) c0374k6.componentArguments;
        String str = c0338im.f928a;
        if (str != null) {
            c0390km.f = str;
            c0390km.g = c0338im.b;
        }
        Map<String, String> map = c0338im.c;
        c0390km.h = map;
        c0390km.i = (Q3) this.b.a(new Q3(map, EnumC0531q8.c));
        C0338im c0338im2 = (C0338im) c0374k6.componentArguments;
        c0390km.k = c0338im2.d;
        c0390km.j = c0338im2.e;
        C0494om c0494om2 = c0374k6.f950a;
        c0390km.l = c0494om2.p;
        c0390km.m = c0494om2.r;
        long j = c0494om2.v;
        if (c0390km.n == 0) {
            c0390km.n = j;
        }
        return c0390km;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0390km();
    }

    public C0364jm(Context context, String str, SafePackageManager safePackageManager, Y3 y3) {
        super(context, str, safePackageManager);
        this.b = y3;
    }

    public final C0390km a() {
        return new C0390km();
    }
}
