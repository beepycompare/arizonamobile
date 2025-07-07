package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientExecutorProvider;
/* renamed from: io.appmetrica.analytics.impl.jd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0364jd implements ModuleClientExecutorProvider {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return C0704x4.l().c.a();
    }
}
