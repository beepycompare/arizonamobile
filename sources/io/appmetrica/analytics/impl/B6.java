package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class B6 extends C0411lh {
    public final Context f;
    public final Rh g;
    public final Q6 h;
    public final T1 i;
    public final M6 j;

    public B6(Context context, C0472o0 c0472o0, InterfaceC0337il interfaceC0337il, Rh rh) {
        super(c0472o0, interfaceC0337il, rh);
        this.f = context;
        this.g = rh;
        this.h = A4.l().i();
        this.i = A4.l().f();
        this.j = new M6(context);
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        String a2 = this.h.f637a.a();
        T1 t1 = this.i;
        Context context = this.f;
        t1.getClass();
        ServiceInfo serviceInfo = PackageManagerUtils.getServiceInfo(context, AppMetricaService.class);
        if (Intrinsics.areEqual(a2, serviceInfo != null ? serviceInfo.processName : null)) {
            this.j.a(this.g);
        } else {
            this.f688a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.Th
    public final boolean c() {
        this.j.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Th, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }
}
