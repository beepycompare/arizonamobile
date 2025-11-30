package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleObserver;
/* renamed from: io.appmetrica.analytics.impl.bd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0141bd implements ModuleServiceLifecycleController {

    /* renamed from: a  reason: collision with root package name */
    public final K1 f816a;

    public C0141bd(K1 k1) {
        this.f816a = k1;
    }

    public static final void a(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onFirstClientConnected();
    }

    public static final void b(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onAllClientsDisconnected();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController
    public final void registerObserver(final ModuleServiceLifecycleObserver moduleServiceLifecycleObserver) {
        this.f816a.b(new J1() { // from class: io.appmetrica.analytics.impl.bd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.J1
            public final void a(Intent intent) {
                C0141bd.a(ModuleServiceLifecycleObserver.this, intent);
            }
        });
        this.f816a.a(new J1() { // from class: io.appmetrica.analytics.impl.bd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.J1
            public final void a(Intent intent) {
                C0141bd.b(ModuleServiceLifecycleObserver.this, intent);
            }
        });
    }
}
