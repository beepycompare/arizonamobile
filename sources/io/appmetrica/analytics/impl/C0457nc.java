package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.nc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0457nc implements InterfaceC0382kc, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f967a = new ArrayList();
    public final IHandlerExecutor b = Ia.j().w().c();
    public Hn c;
    public boolean d;

    public final void a(Toggle toggle) {
        Hn hn = new Hn(toggle);
        this.c = hn;
        hn.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        Hn hn = this.c;
        if (hn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            hn = null;
        }
        hn.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.nc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0457nc.a(C0457nc.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.nc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0457nc.a(C0457nc.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(C0457nc c0457nc, LocationControllerObserver locationControllerObserver, boolean z) {
        c0457nc.f967a.add(locationControllerObserver);
        if (z) {
            if (c0457nc.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(C0457nc c0457nc, boolean z) {
        if (c0457nc.d != z) {
            c0457nc.d = z;
            Function1 function1 = z ? C0407lc.f937a : C0432mc.f952a;
            for (LocationControllerObserver locationControllerObserver : c0457nc.f967a) {
                function1.invoke(locationControllerObserver);
            }
        }
    }

    public final void a(Object obj) {
        Hn hn = this.c;
        if (hn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            hn = null;
        }
        hn.b.a(obj);
    }

    public final void a(boolean z) {
        Hn hn = this.c;
        if (hn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            hn = null;
        }
        hn.f478a.a(z);
    }
}
