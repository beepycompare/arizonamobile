package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Sb implements Pb, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f779a = new ArrayList();
    public final IHandlerExecutor b = C0448na.k().w().b();
    public Kn c;
    public boolean d;

    public final void a(Toggle toggle) {
        Kn kn = new Kn(toggle);
        this.c = kn;
        kn.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        Kn kn = this.c;
        if (kn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            kn = null;
        }
        kn.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Sb$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Sb.a(Sb.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Sb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Sb.a(Sb.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(Sb sb, LocationControllerObserver locationControllerObserver, boolean z) {
        sb.f779a.add(locationControllerObserver);
        if (z) {
            if (sb.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(Sb sb, boolean z) {
        if (sb.d != z) {
            sb.d = z;
            Function1 function1 = z ? Qb.f749a : Rb.f765a;
            for (LocationControllerObserver locationControllerObserver : sb.f779a) {
                function1.invoke(locationControllerObserver);
            }
        }
    }

    public final void a(Object obj) {
        Kn kn = this.c;
        if (kn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            kn = null;
        }
        kn.b.a(obj);
    }

    public final void a(boolean z) {
        Kn kn = this.c;
        if (kn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            kn = null;
        }
        kn.f664a.a(z);
    }
}
