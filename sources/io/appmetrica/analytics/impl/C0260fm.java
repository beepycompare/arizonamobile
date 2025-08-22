package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.fm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0260fm extends AbstractC0322i6 {
    public final V3 b;

    public C0260fm(Context context, String str) {
        this(context, str, new SafePackageManager(), Ka.j().e());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0322i6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0286gm load(C0296h6 c0296h6) {
        C0286gm c0286gm = (C0286gm) super.load(c0296h6);
        C0389km c0389km = c0296h6.f882a;
        c0286gm.d = c0389km.f;
        c0286gm.e = c0389km.g;
        C0234em c0234em = (C0234em) c0296h6.componentArguments;
        String str = c0234em.f846a;
        if (str != null) {
            c0286gm.f = str;
            c0286gm.g = c0234em.b;
        }
        Map<String, String> map = c0234em.c;
        c0286gm.h = map;
        c0286gm.i = (N3) this.b.a(new N3(map, EnumC0451n8.c));
        C0234em c0234em2 = (C0234em) c0296h6.componentArguments;
        c0286gm.k = c0234em2.d;
        c0286gm.j = c0234em2.e;
        C0389km c0389km2 = c0296h6.f882a;
        c0286gm.l = c0389km2.p;
        c0286gm.m = c0389km2.r;
        long j = c0389km2.v;
        if (c0286gm.n == 0) {
            c0286gm.n = j;
        }
        return c0286gm;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0286gm();
    }

    public C0260fm(Context context, String str, SafePackageManager safePackageManager, V3 v3) {
        super(context, str, safePackageManager);
        this.b = v3;
    }

    public final C0286gm a() {
        return new C0286gm();
    }
}
