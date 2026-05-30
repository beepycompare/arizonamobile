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
public final class C0636uc implements InterfaceC0558rc, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1230a = new ArrayList();
    public final IHandlerExecutor b = Na.k().w().c();
    public C0467no c;
    public boolean d;

    public final void a(Toggle toggle) {
        C0467no c0467no = new C0467no(toggle);
        this.c = c0467no;
        c0467no.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        C0467no c0467no = this.c;
        if (c0467no == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c0467no = null;
        }
        c0467no.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.uc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0636uc.a(C0636uc.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.uc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0636uc.a(C0636uc.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(C0636uc c0636uc, LocationControllerObserver locationControllerObserver, boolean z) {
        c0636uc.f1230a.add(locationControllerObserver);
        if (z) {
            if (c0636uc.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(C0636uc c0636uc, boolean z) {
        if (c0636uc.d != z) {
            c0636uc.d = z;
            Function1 function1 = z ? C0584sc.f1196a : C0610tc.f1214a;
            for (LocationControllerObserver locationControllerObserver : c0636uc.f1230a) {
                function1.invoke(locationControllerObserver);
            }
        }
    }

    public final void a(Object obj) {
        C0467no c0467no = this.c;
        if (c0467no == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c0467no = null;
        }
        c0467no.b.a(obj);
    }

    public final void a(boolean z) {
        C0467no c0467no = this.c;
        if (c0467no == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c0467no = null;
        }
        c0467no.f1121a.a(z);
    }
}
