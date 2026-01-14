package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.c6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0164c6 extends Pg {
    public final Context f;
    public final C0655vh g;
    public final C0544r6 h;
    public final K1 i;
    public final C0445n6 j;

    public C0164c6(Context context, C0489p0 c0489p0, Zk zk, C0655vh c0655vh) {
        super(c0489p0, zk, c0655vh);
        this.f = context;
        this.g = c0655vh;
        this.h = C0136b4.l().i();
        this.i = C0136b4.l().f();
        this.j = new C0445n6(context);
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0705xh
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        String a2 = this.h.f1203a.a();
        K1 k1 = this.i;
        Context context = this.f;
        k1.getClass();
        ServiceInfo serviceInfo = PackageManagerUtils.getServiceInfo(context, AppMetricaService.class);
        if (Intrinsics.areEqual(a2, serviceInfo != null ? serviceInfo.processName : null)) {
            this.j.a(this.g);
        } else {
            this.f1309a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0705xh
    public final boolean c() {
        this.j.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0705xh, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }
}
