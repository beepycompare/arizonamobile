package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0363jm extends AbstractC0399l6 {
    public final Y3 b;

    public C0363jm(Context context, String str) {
        this(context, str, new SafePackageManager(), Na.j().e());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0399l6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0389km load(C0373k6 c0373k6) {
        C0389km c0389km = (C0389km) super.load(c0373k6);
        C0493om c0493om = c0373k6.f945a;
        c0389km.d = c0493om.f;
        c0389km.e = c0493om.g;
        C0337im c0337im = (C0337im) c0373k6.componentArguments;
        String str = c0337im.f923a;
        if (str != null) {
            c0389km.f = str;
            c0389km.g = c0337im.b;
        }
        Map<String, String> map = c0337im.c;
        c0389km.h = map;
        c0389km.i = (Q3) this.b.a(new Q3(map, EnumC0530q8.c));
        C0337im c0337im2 = (C0337im) c0373k6.componentArguments;
        c0389km.k = c0337im2.d;
        c0389km.j = c0337im2.e;
        C0493om c0493om2 = c0373k6.f945a;
        c0389km.l = c0493om2.p;
        c0389km.m = c0493om2.r;
        long j = c0493om2.v;
        if (c0389km.n == 0) {
            c0389km.n = j;
        }
        return c0389km;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0389km();
    }

    public C0363jm(Context context, String str, SafePackageManager safePackageManager, Y3 y3) {
        super(context, str, safePackageManager);
        this.b = y3;
    }

    public final C0389km a() {
        return new C0389km();
    }
}
