package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleObserver;
/* renamed from: io.appmetrica.analytics.impl.hd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0296hd implements ModuleServiceLifecycleController {

    /* renamed from: a  reason: collision with root package name */
    public final T1 f910a;

    public C0296hd(T1 t1) {
        this.f910a = t1;
    }

    public static final void a(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onFirstClientConnected();
    }

    public static final void b(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onAllClientsDisconnected();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController
    public final void registerObserver(final ModuleServiceLifecycleObserver moduleServiceLifecycleObserver) {
        this.f910a.b(new S1() { // from class: io.appmetrica.analytics.impl.hd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.S1
            public final void a(Intent intent) {
                C0296hd.a(ModuleServiceLifecycleObserver.this, intent);
            }
        });
        this.f910a.a(new S1() { // from class: io.appmetrica.analytics.impl.hd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.S1
            public final void a(Intent intent) {
                C0296hd.b(ModuleServiceLifecycleObserver.this, intent);
            }
        });
    }
}
