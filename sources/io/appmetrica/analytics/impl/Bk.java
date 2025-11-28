package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentLifecycle;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentLifecycleListener;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class Bk implements ServiceModuleReporterComponentLifecycle, ServiceModuleReporterComponentLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f416a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentLifecycleListener
    public final void onMainReporterCreated(ServiceModuleReporterComponentContext serviceModuleReporterComponentContext) {
        for (ServiceModuleReporterComponentLifecycleListener serviceModuleReporterComponentLifecycleListener : this.f416a) {
            serviceModuleReporterComponentLifecycleListener.onMainReporterCreated(serviceModuleReporterComponentContext);
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentLifecycle
    public final void subscribe(ServiceModuleReporterComponentLifecycleListener serviceModuleReporterComponentLifecycleListener) {
        this.f416a.add(serviceModuleReporterComponentLifecycleListener);
    }
}
