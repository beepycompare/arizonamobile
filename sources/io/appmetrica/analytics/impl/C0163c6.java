package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.c6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0163c6 extends Pg {
    public final Context f;
    public final C0654vh g;
    public final C0543r6 h;
    public final K1 i;
    public final C0444n6 j;

    public C0163c6(Context context, C0488p0 c0488p0, Zk zk, C0654vh c0654vh) {
        super(c0488p0, zk, c0654vh);
        this.f = context;
        this.g = c0654vh;
        this.h = C0135b4.l().i();
        this.i = C0135b4.l().f();
        this.j = new C0444n6(context);
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0704xh
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        String a2 = this.h.f1207a.a();
        K1 k1 = this.i;
        Context context = this.f;
        k1.getClass();
        ServiceInfo serviceInfo = PackageManagerUtils.getServiceInfo(context, AppMetricaService.class);
        if (Intrinsics.areEqual(a2, serviceInfo != null ? serviceInfo.processName : null)) {
            this.j.a(this.g);
        } else {
            this.f1313a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0704xh
    public final boolean c() {
        this.j.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0704xh, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }
}
