package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.am  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0127am extends M5 {
    public final C0740z3 b;

    public C0127am(Context context, String str) {
        this(context, str, new SafePackageManager(), C0448na.k().f());
    }

    @Override // io.appmetrica.analytics.impl.M5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0153bm load(L5 l5) {
        C0153bm c0153bm = (C0153bm) super.load(l5);
        C0256fm c0256fm = l5.f676a;
        c0153bm.d = c0256fm.f;
        c0153bm.e = c0256fm.g;
        Zl zl = (Zl) l5.componentArguments;
        String str = zl.f896a;
        if (str != null) {
            c0153bm.f = str;
            c0153bm.g = zl.b;
        }
        Map<String, String> map = zl.c;
        c0153bm.h = map;
        c0153bm.i = (C0540r3) this.b.a(new C0540r3(map, S7.c));
        Zl zl2 = (Zl) l5.componentArguments;
        c0153bm.k = zl2.d;
        c0153bm.j = zl2.e;
        C0256fm c0256fm2 = l5.f676a;
        c0153bm.l = c0256fm2.p;
        c0153bm.m = c0256fm2.r;
        long j = c0256fm2.v;
        if (c0153bm.n == 0) {
            c0153bm.n = j;
        }
        return c0153bm;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0153bm();
    }

    public C0127am(Context context, String str, SafePackageManager safePackageManager, C0740z3 c0740z3) {
        super(context, str, safePackageManager);
        this.b = c0740z3;
    }

    public final C0153bm a() {
        return new C0153bm();
    }
}
