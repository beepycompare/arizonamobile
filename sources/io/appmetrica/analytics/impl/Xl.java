package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Xl extends AbstractC0258f6 {
    public final V3 b;

    public Xl(Context context, String str) {
        this(context, str, new SafePackageManager(), Ga.j().e());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0258f6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final Yl load(C0233e6 c0233e6) {
        Yl yl = (Yl) super.load(c0233e6);
        C0198cm c0198cm = c0233e6.f816a;
        yl.d = c0198cm.f;
        yl.e = c0198cm.g;
        Wl wl = (Wl) c0233e6.componentArguments;
        String str = wl.f692a;
        if (str != null) {
            yl.f = str;
            yl.g = wl.b;
        }
        Map<String, String> map = wl.c;
        yl.h = map;
        yl.i = (N3) this.b.a(new N3(map, EnumC0335i8.c));
        Wl wl2 = (Wl) c0233e6.componentArguments;
        yl.k = wl2.d;
        yl.j = wl2.e;
        C0198cm c0198cm2 = c0233e6.f816a;
        yl.l = c0198cm2.p;
        yl.m = c0198cm2.r;
        long j = c0198cm2.v;
        if (yl.n == 0) {
            yl.n = j;
        }
        return yl;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new Yl();
    }

    public Xl(Context context, String str, SafePackageManager safePackageManager, V3 v3) {
        super(context, str, safePackageManager);
        this.b = v3;
    }

    public final Yl a() {
        return new Yl();
    }
}
