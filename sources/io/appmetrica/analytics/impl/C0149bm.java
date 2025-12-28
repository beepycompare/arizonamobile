package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.bm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0149bm extends N5 {
    public final A3 b;

    public C0149bm(Context context, String str) {
        this(context, str, new SafePackageManager(), C0470oa.k().f());
    }

    @Override // io.appmetrica.analytics.impl.N5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0175cm load(M5 m5) {
        C0175cm c0175cm = (C0175cm) super.load(m5);
        C0278gm c0278gm = m5.f681a;
        c0175cm.d = c0278gm.f;
        c0175cm.e = c0278gm.g;
        C0123am c0123am = (C0123am) m5.componentArguments;
        String str = c0123am.f902a;
        if (str != null) {
            c0175cm.f = str;
            c0175cm.g = c0123am.b;
        }
        Map<String, String> map = c0123am.c;
        c0175cm.h = map;
        c0175cm.i = (C0562s3) this.b.a(new C0562s3(map, T7.c));
        C0123am c0123am2 = (C0123am) m5.componentArguments;
        c0175cm.k = c0123am2.d;
        c0175cm.j = c0123am2.e;
        C0278gm c0278gm2 = m5.f681a;
        c0175cm.l = c0278gm2.p;
        c0175cm.m = c0278gm2.r;
        long j = c0278gm2.v;
        if (c0175cm.n == 0) {
            c0175cm.n = j;
        }
        return c0175cm;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0175cm();
    }

    public C0149bm(Context context, String str, SafePackageManager safePackageManager, A3 a3) {
        super(context, str, safePackageManager);
        this.b = a3;
    }

    public final C0175cm a() {
        return new C0175cm();
    }
}
