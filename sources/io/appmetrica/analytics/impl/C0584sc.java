package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.sc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0584sc implements InterfaceC0510pc, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1081a = new ArrayList();
    public final IHandlerExecutor b = Na.j().w().c();
    public Qn c;
    public boolean d;

    public final void a(Toggle toggle) {
        Qn qn = new Qn(toggle);
        this.c = qn;
        qn.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        Qn qn = this.c;
        if (qn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            qn = null;
        }
        qn.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.sc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0584sc.a(C0584sc.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.sc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0584sc.a(C0584sc.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(C0584sc c0584sc, LocationControllerObserver locationControllerObserver, boolean z) {
        c0584sc.f1081a.add(locationControllerObserver);
        if (z) {
            if (c0584sc.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(C0584sc c0584sc, boolean z) {
        if (c0584sc.d != z) {
            c0584sc.d = z;
            Function1 function1 = z ? C0535qc.f1049a : C0559rc.f1066a;
            for (LocationControllerObserver locationControllerObserver : c0584sc.f1081a) {
                function1.invoke(locationControllerObserver);
            }
        }
    }

    public final void a(Object obj) {
        Qn qn = this.c;
        if (qn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            qn = null;
        }
        qn.b.a(obj);
    }

    public final void a(boolean z) {
        Qn qn = this.c;
        if (qn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            qn = null;
        }
        qn.f647a.a(z);
    }
}
