package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class Zb implements Wb, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f783a = new ArrayList();
    public final IHandlerExecutor b = C0620ua.k().x().c();
    public Mn c;
    public boolean d;

    public final void a(Toggle toggle) {
        Mn mn = new Mn(toggle);
        this.c = mn;
        mn.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        Mn mn = this.c;
        if (mn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            mn = null;
        }
        mn.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Zb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Zb.a(Zb.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Zb$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Zb.a(Zb.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(Zb zb, LocationControllerObserver locationControllerObserver, boolean z) {
        zb.f783a.add(locationControllerObserver);
        if (z) {
            if (zb.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(Zb zb, boolean z) {
        if (zb.d != z) {
            zb.d = z;
            Function1 function1 = z ? Xb.f754a : Yb.f770a;
            for (LocationControllerObserver locationControllerObserver : zb.f783a) {
                function1.invoke(locationControllerObserver);
            }
        }
    }

    public final void a(Object obj) {
        Mn mn = this.c;
        if (mn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            mn = null;
        }
        mn.b.a(obj);
    }

    public final void a(boolean z) {
        Mn mn = this.c;
        if (mn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            mn = null;
        }
        mn.f597a.a(z);
    }
}
