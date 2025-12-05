package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientExecutorProvider;
/* loaded from: classes5.dex */
public final class Rc implements ModuleClientExecutorProvider {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return C0157c4.l().c.a();
    }
}
