package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ServiceInfo;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.internal.AppMetricaService;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.s6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0578s6 extends C0253fh {
    public final Context f;
    public final Ph g;
    public final boolean h;
    public final J6 i;
    public final X1 j;
    public final E6 k;

    public /* synthetic */ C0578s6(Context context, C0546r0 c0546r0, El el, Ph ph, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, c0546r0, el, ph, (i & 16) != 0 ? false : z);
    }

    @Override // io.appmetrica.analytics.impl.Rh
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        String a2 = this.i.f607a.a();
        X1 x1 = this.j;
        Context context = this.f;
        x1.getClass();
        ServiceInfo serviceInfo = PackageManagerUtils.getServiceInfo(context, AppMetricaService.class);
        String str = serviceInfo != null ? serviceInfo.processName : null;
        if (!this.h && Intrinsics.areEqual(a2, str)) {
            this.k.a(this.g);
        } else {
            this.f749a.c();
            this.c = false;
            super.a();
        }
    }

    @Override // io.appmetrica.analytics.impl.Rh
    public final boolean c() {
        this.k.a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Rh, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }

    public C0578s6(Context context, C0546r0 c0546r0, El el, Ph ph, boolean z) {
        super(c0546r0, el, ph);
        this.f = context;
        this.g = ph;
        this.h = z;
        this.i = C0576s4.l().i();
        this.j = C0576s4.l().f();
        this.k = new E6(context);
    }
}
