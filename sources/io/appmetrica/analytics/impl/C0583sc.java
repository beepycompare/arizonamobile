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
public final class C0583sc implements InterfaceC0509pc, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1080a = new ArrayList();
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
                C0583sc.a(C0583sc.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.sc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0583sc.a(C0583sc.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(C0583sc c0583sc, LocationControllerObserver locationControllerObserver, boolean z) {
        c0583sc.f1080a.add(locationControllerObserver);
        if (z) {
            if (c0583sc.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(C0583sc c0583sc, boolean z) {
        if (c0583sc.d != z) {
            c0583sc.d = z;
            Function1 function1 = z ? C0534qc.f1048a : C0558rc.f1065a;
            for (LocationControllerObserver locationControllerObserver : c0583sc.f1080a) {
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
        qn.f646a.a(z);
    }
}
