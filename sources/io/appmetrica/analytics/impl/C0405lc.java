package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.lc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0405lc implements InterfaceC0331ic, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f921a = new ArrayList();
    public final IHandlerExecutor b = Ga.j().w().c();
    public En c;
    public boolean d;

    public final void a(Toggle toggle) {
        En en = new En(toggle);
        this.c = en;
        en.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        En en = this.c;
        if (en == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            en = null;
        }
        en.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.lc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0405lc.a(C0405lc.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.lc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0405lc.a(C0405lc.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(C0405lc c0405lc, LocationControllerObserver locationControllerObserver, boolean z) {
        c0405lc.f921a.add(locationControllerObserver);
        if (z) {
            if (c0405lc.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(C0405lc c0405lc, boolean z) {
        if (c0405lc.d != z) {
            c0405lc.d = z;
            Function1 function1 = z ? C0355jc.f891a : C0380kc.f905a;
            for (LocationControllerObserver locationControllerObserver : c0405lc.f921a) {
                function1.invoke(locationControllerObserver);
            }
        }
    }

    public final void a(Object obj) {
        En en = this.c;
        if (en == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            en = null;
        }
        en.b.a(obj);
    }

    public final void a(boolean z) {
        En en = this.c;
        if (en == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            en = null;
        }
        en.f417a.a(z);
    }
}
