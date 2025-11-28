package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.j6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0340j6 extends Ug {
    public final Context f;
    public final Ah g;
    public final C0716y6 h;
    public final U1 i;
    public final C0616u6 j;

    public C0340j6(Context context, C0486p0 c0486p0, InterfaceC0201dl interfaceC0201dl, Ah ah) {
        super(c0486p0, interfaceC0201dl, ah);
        this.f = context;
        this.g = ah;
        this.h = C0338j4.l().i();
        this.i = C0338j4.l().f();
        this.j = new C0616u6(context);
    }

    @Override // io.appmetrica.analytics.impl.Ch
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        String a2 = this.h.f1210a.a();
        U1 u1 = this.i;
        Context context = this.f;
        u1.getClass();
        ServiceInfo serviceInfo = PackageManagerUtils.getServiceInfo(context, AppMetricaService.class);
        if (Intrinsics.areEqual(a2, serviceInfo != null ? serviceInfo.processName : null)) {
            this.j.a(this.g);
        } else {
            this.f427a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.Ch
    public final boolean c() {
        this.j.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Ch, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }
}
