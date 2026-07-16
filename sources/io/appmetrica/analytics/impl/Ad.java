package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleObserver;
/* loaded from: classes5.dex */
public final class Ad implements ModuleServiceLifecycleController {

    /* renamed from: a  reason: collision with root package name */
    public final W1 f459a;

    public Ad(W1 w1) {
        this.f459a = w1;
    }

    public static final void a(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onFirstClientConnected();
    }

    public static final void b(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onAllClientsDisconnected();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController
    public final void registerObserver(final ModuleServiceLifecycleObserver moduleServiceLifecycleObserver) {
        this.f459a.b(new V1() { // from class: io.appmetrica.analytics.impl.Ad$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.V1
            public final void a(Intent intent) {
                Ad.a(ModuleServiceLifecycleObserver.this, intent);
            }
        });
        this.f459a.a(new V1() { // from class: io.appmetrica.analytics.impl.Ad$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.V1
            public final void a(Intent intent) {
                Ad.b(ModuleServiceLifecycleObserver.this, intent);
            }
        });
    }
}
