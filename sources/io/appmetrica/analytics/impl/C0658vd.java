package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleObserver;
/* renamed from: io.appmetrica.analytics.impl.vd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0658vd implements ModuleServiceLifecycleController {

    /* renamed from: a  reason: collision with root package name */
    public final Q1 f1100a;

    public C0658vd(Q1 q1) {
        this.f1100a = q1;
    }

    public static final void a(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onFirstClientConnected();
    }

    public static final void b(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onAllClientsDisconnected();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController
    public final void registerObserver(final ModuleServiceLifecycleObserver moduleServiceLifecycleObserver) {
        this.f1100a.b(new P1() { // from class: io.appmetrica.analytics.impl.vd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.P1
            public final void a(Intent intent) {
                C0658vd.a(ModuleServiceLifecycleObserver.this, intent);
            }
        });
        this.f1100a.a(new P1() { // from class: io.appmetrica.analytics.impl.vd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.P1
            public final void a(Intent intent) {
                C0658vd.b(ModuleServiceLifecycleObserver.this, intent);
            }
        });
    }
}
