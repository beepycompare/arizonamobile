package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleObserver;
/* renamed from: io.appmetrica.analytics.impl.ad  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0119ad implements ModuleServiceLifecycleController {

    /* renamed from: a  reason: collision with root package name */
    public final J1 f904a;

    public C0119ad(J1 j1) {
        this.f904a = j1;
    }

    public static final void a(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onFirstClientConnected();
    }

    public static final void b(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onAllClientsDisconnected();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController
    public final void registerObserver(final ModuleServiceLifecycleObserver moduleServiceLifecycleObserver) {
        this.f904a.b(new I1() { // from class: io.appmetrica.analytics.impl.ad$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.I1
            public final void a(Intent intent) {
                C0119ad.a(ModuleServiceLifecycleObserver.this, intent);
            }
        });
        this.f904a.a(new I1() { // from class: io.appmetrica.analytics.impl.ad$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.I1
            public final void a(Intent intent) {
                C0119ad.b(ModuleServiceLifecycleObserver.this, intent);
            }
        });
    }
}
