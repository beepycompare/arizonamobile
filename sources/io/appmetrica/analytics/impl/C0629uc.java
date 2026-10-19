package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.uc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0629uc implements InterfaceC0551rc, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1235a = new ArrayList();
    public final IHandlerExecutor b = Na.k().w().c();
    public C0460no c;
    public boolean d;

    public final void a(Toggle toggle) {
        C0460no c0460no = new C0460no(toggle);
        this.c = c0460no;
        c0460no.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        C0460no c0460no = this.c;
        if (c0460no == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c0460no = null;
        }
        c0460no.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.uc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0629uc.a(C0629uc.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.uc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0629uc.a(C0629uc.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(C0629uc c0629uc, LocationControllerObserver locationControllerObserver, boolean z) {
        c0629uc.f1235a.add(locationControllerObserver);
        if (z) {
            if (c0629uc.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(C0629uc c0629uc, boolean z) {
        if (c0629uc.d != z) {
            c0629uc.d = z;
            Function1 function1 = z ? C0577sc.f1201a : C0603tc.f1219a;
            for (LocationControllerObserver locationControllerObserver : c0629uc.f1235a) {
                function1.invoke(locationControllerObserver);
            }
        }
    }

    public final void a(Object obj) {
        C0460no c0460no = this.c;
        if (c0460no == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c0460no = null;
        }
        c0460no.b.a(obj);
    }

    public final void a(boolean z) {
        C0460no c0460no = this.c;
        if (c0460no == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c0460no = null;
        }
        c0460no.f1126a.a(z);
    }
}
