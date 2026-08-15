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
public final class C0635uc implements InterfaceC0557rc, ToggleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1232a = new ArrayList();
    public final IHandlerExecutor b = Na.k().w().c();
    public C0466no c;
    public boolean d;

    public final void a(Toggle toggle) {
        C0466no c0466no = new C0466no(toggle);
        this.c = c0466no;
        c0466no.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        C0466no c0466no = this.c;
        if (c0466no == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c0466no = null;
        }
        c0466no.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.uc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0635uc.a(C0635uc.this, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.uc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0635uc.a(C0635uc.this, locationControllerObserver, z);
            }
        });
    }

    public static final void a(C0635uc c0635uc, LocationControllerObserver locationControllerObserver, boolean z) {
        c0635uc.f1232a.add(locationControllerObserver);
        if (z) {
            if (c0635uc.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(C0635uc c0635uc, boolean z) {
        if (c0635uc.d != z) {
            c0635uc.d = z;
            Function1 function1 = z ? C0583sc.f1198a : C0609tc.f1216a;
            for (LocationControllerObserver locationControllerObserver : c0635uc.f1232a) {
                function1.invoke(locationControllerObserver);
            }
        }
    }

    public final void a(Object obj) {
        C0466no c0466no = this.c;
        if (c0466no == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c0466no = null;
        }
        c0466no.b.a(obj);
    }

    public final void a(boolean z) {
        C0466no c0466no = this.c;
        if (c0466no == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c0466no = null;
        }
        c0466no.f1123a.a(z);
    }
}
