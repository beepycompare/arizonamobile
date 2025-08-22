package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.pc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0505pc implements InterfaceC0430mc, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1010a = new ArrayList();
    public final IHandlerExecutor b = Ka.j().w().c();
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
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.pc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0505pc.a(C0505pc.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.pc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0505pc.a(C0505pc.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(C0505pc c0505pc, LocationControllerObserver locationControllerObserver, boolean z) {
        c0505pc.f1010a.add(locationControllerObserver);
        if (z) {
            if (c0505pc.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(C0505pc c0505pc, boolean z) {
        if (c0505pc.d != z) {
            c0505pc.d = z;
            Function1 function1 = z ? C0455nc.f982a : C0480oc.f999a;
            for (LocationControllerObserver locationControllerObserver : c0505pc.f1010a) {
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
        mn.f567a.a(z);
    }
}
