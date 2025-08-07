package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.y6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0726y6 extends C0186ch {
    public final Context f;
    public final Ih g;
    public final M6 h;
    public final R1 i;
    public final J6 j;

    public C0726y6(Context context, C0421m0 c0421m0, Zk zk, Ih ih) {
        super(c0421m0, zk, ih);
        this.f = context;
        this.g = ih;
        this.h = C0699x4.l().i();
        this.i = C0699x4.l().f();
        this.j = new J6(context);
    }

    @Override // io.appmetrica.analytics.impl.Kh
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        String b = this.h.b();
        R1 r1 = this.i;
        Context context = this.f;
        r1.getClass();
        ServiceInfo serviceInfo = PackageManagerUtils.getServiceInfo(context, AppMetricaService.class);
        if (Intrinsics.areEqual(b, serviceInfo != null ? serviceInfo.processName : null)) {
            this.j.a(this.g);
        } else {
            this.f523a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.Kh
    public final boolean c() {
        this.j.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Kh, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }
}
