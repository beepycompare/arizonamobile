package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.v6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0656v6 extends C0141ah {
    public final Context f;
    public final Gh g;
    public final J6 h;
    public final R1 i;
    public final G6 j;

    public C0656v6(Context context, C0426m0 c0426m0, Wk wk, Gh gh) {
        super(c0426m0, wk, gh);
        this.f = context;
        this.g = gh;
        this.h = C0704x4.l().i();
        this.i = C0704x4.l().f();
        this.j = new G6(context);
    }

    @Override // io.appmetrica.analytics.impl.Ih
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
            this.f477a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.Ih
    public final boolean c() {
        this.j.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Ih, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }
}
