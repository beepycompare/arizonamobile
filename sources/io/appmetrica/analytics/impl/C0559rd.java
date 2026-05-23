package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientExecutorProvider;
/* renamed from: io.appmetrica.analytics.impl.rd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0559rd implements ModuleClientExecutorProvider {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return C0576s4.l().c.a();
    }
}
