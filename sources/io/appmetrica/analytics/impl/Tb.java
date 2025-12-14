package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Tb implements Qb, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f788a = new ArrayList();
    public final IHandlerExecutor b = C0470oa.k().w().b();
    public Ln c;
    public boolean d;

    public final void a(Toggle toggle) {
        Ln ln = new Ln(toggle);
        this.c = ln;
        ln.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        Ln ln = this.c;
        if (ln == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            ln = null;
        }
        ln.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Tb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Tb.a(Tb.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Tb$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Tb.a(Tb.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(Tb tb, LocationControllerObserver locationControllerObserver, boolean z) {
        tb.f788a.add(locationControllerObserver);
        if (z) {
            if (tb.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(Tb tb, boolean z) {
        if (tb.d != z) {
            tb.d = z;
            Function1 function1 = z ? Rb.f757a : Sb.f774a;
            for (LocationControllerObserver locationControllerObserver : tb.f788a) {
                function1.invoke(locationControllerObserver);
            }
        }
    }

    public final void a(Object obj) {
        Ln ln = this.c;
        if (ln == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            ln = null;
        }
        ln.b.a(obj);
    }

    public final void a(boolean z) {
        Ln ln = this.c;
        if (ln == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            ln = null;
        }
        ln.f673a.a(z);
    }
}
