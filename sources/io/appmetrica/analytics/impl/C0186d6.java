package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.d6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0186d6 extends Qg {
    public final Context f;
    public final C0677wh g;
    public final C0566s6 h;
    public final L1 i;
    public final C0467o6 j;

    public C0186d6(Context context, C0486p0 c0486p0, InterfaceC0123al interfaceC0123al, C0677wh c0677wh) {
        super(c0486p0, interfaceC0123al, c0677wh);
        this.f = context;
        this.g = c0677wh;
        this.h = C0158c4.l().i();
        this.i = C0158c4.l().f();
        this.j = new C0467o6(context);
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0727yh
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        String a2 = this.h.f1114a.a();
        L1 l1 = this.i;
        Context context = this.f;
        l1.getClass();
        ServiceInfo serviceInfo = PackageManagerUtils.getServiceInfo(context, AppMetricaService.class);
        if (Intrinsics.areEqual(a2, serviceInfo != null ? serviceInfo.processName : null)) {
            this.j.a(this.g);
        } else {
            this.f1221a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0727yh
    public final boolean c() {
        this.j.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC0727yh, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }
}
