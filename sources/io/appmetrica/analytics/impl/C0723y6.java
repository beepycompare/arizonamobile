package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.y6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0723y6 extends C0307hh {
    public final Context f;
    public final Nh g;
    public final N6 h;
    public final R1 i;
    public final J6 j;

    public C0723y6(Context context, C0418m0 c0418m0, InterfaceC0233el interfaceC0233el, Nh nh) {
        super(c0418m0, interfaceC0233el, nh);
        this.f = context;
        this.g = nh;
        this.h = C0696x4.l().i();
        this.i = C0696x4.l().f();
        this.j = new J6(context);
    }

    @Override // io.appmetrica.analytics.impl.Ph
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        String a2 = this.h.f574a.a();
        R1 r1 = this.i;
        Context context = this.f;
        r1.getClass();
        ServiceInfo serviceInfo = PackageManagerUtils.getServiceInfo(context, AppMetricaService.class);
        if (Intrinsics.areEqual(a2, serviceInfo != null ? serviceInfo.processName : null)) {
            this.j.a(this.g);
        } else {
            this.f607a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.Ph
    public final boolean c() {
        this.j.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Ph, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }
}
