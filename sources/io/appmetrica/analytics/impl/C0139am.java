package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.am  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0139am extends AbstractC0328i6 {
    public final V3 b;

    public C0139am(Context context, String str) {
        this(context, str, new SafePackageManager(), Ia.j().e());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0328i6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0165bm load(C0303h6 c0303h6) {
        C0165bm c0165bm = (C0165bm) super.load(c0303h6);
        C0268fm c0268fm = c0303h6.f878a;
        c0165bm.d = c0268fm.f;
        c0165bm.e = c0268fm.g;
        Zl zl = (Zl) c0303h6.componentArguments;
        String str = zl.f754a;
        if (str != null) {
            c0165bm.f = str;
            c0165bm.g = zl.b;
        }
        Map<String, String> map = zl.c;
        c0165bm.h = map;
        c0165bm.i = (N3) this.b.a(new N3(map, EnumC0404l8.c));
        Zl zl2 = (Zl) c0303h6.componentArguments;
        c0165bm.k = zl2.d;
        c0165bm.j = zl2.e;
        C0268fm c0268fm2 = c0303h6.f878a;
        c0165bm.l = c0268fm2.p;
        c0165bm.m = c0268fm2.r;
        long j = c0268fm2.v;
        if (c0165bm.n == 0) {
            c0165bm.n = j;
        }
        return c0165bm;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0165bm();
    }

    public C0139am(Context context, String str, SafePackageManager safePackageManager, V3 v3) {
        super(context, str, safePackageManager);
        this.b = v3;
    }

    public final C0165bm a() {
        return new C0165bm();
    }
}
