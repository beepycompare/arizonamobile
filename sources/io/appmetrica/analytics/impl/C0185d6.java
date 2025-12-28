package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.d6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0185d6 extends Qg {
    public final Context f;
    public final C0676wh g;
    public final C0565s6 h;
    public final L1 i;
    public final C0466o6 j;

    public C0185d6(Context context, C0485p0 c0485p0, InterfaceC0122al interfaceC0122al, C0676wh c0676wh) {
        super(c0485p0, interfaceC0122al, c0676wh);
        this.f = context;
        this.g = c0676wh;
        this.h = C0157c4.l().i();
        this.i = C0157c4.l().f();
        this.j = new C0466o6(context);
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0726yh
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        String a2 = this.h.f1212a.a();
        L1 l1 = this.i;
        Context context = this.f;
        l1.getClass();
        ServiceInfo serviceInfo = PackageManagerUtils.getServiceInfo(context, AppMetricaService.class);
        if (Intrinsics.areEqual(a2, serviceInfo != null ? serviceInfo.processName : null)) {
            this.j.a(this.g);
        } else {
            this.f1319a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0726yh
    public final boolean c() {
        this.j.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0726yh, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }
}
