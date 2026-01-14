package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f470a;
    public final IHandlerExecutor c;
    public final n d;
    public volatile IdSyncConfig e;
    public volatile boolean f;
    public final long b = TimeUnit.MINUTES.toMillis(1);
    public final C0103f g = new C0103f(this);

    public h(ServiceContext serviceContext, SdkIdentifiers sdkIdentifiers) {
        this.f470a = serviceContext;
        this.c = serviceContext.getExecutorProvider().getModuleExecutor();
        this.d = new n(serviceContext, new G(serviceContext.getServiceStorageProvider().modulePreferences("id-sync")), sdkIdentifiers);
    }

    public final synchronized void a(IdSyncConfig idSyncConfig, SdkIdentifiers sdkIdentifiers) {
        this.d.c = sdkIdentifiers;
        if (!Intrinsics.areEqual(this.e, idSyncConfig)) {
            this.e = idSyncConfig;
            if (a(idSyncConfig) && !this.f) {
                this.f470a.getActivationBarrier().subscribe(idSyncConfig.getLaunchDelay(), this.c, new C0104g(this));
                this.f = true;
            } else if (!a(idSyncConfig) && this.f) {
                this.f = false;
                IHandlerExecutor iHandlerExecutor = this.c;
                C0103f c0103f = this.g;
                if (c0103f == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    c0103f = null;
                }
                iHandlerExecutor.remove(c0103f);
            }
        }
    }

    public static boolean a(IdSyncConfig idSyncConfig) {
        idSyncConfig.getEnabled();
        return idSyncConfig.getEnabled() && !idSyncConfig.getRequests().isEmpty();
    }
}
