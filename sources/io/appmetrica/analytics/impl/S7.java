package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider;
/* loaded from: classes5.dex */
public final class S7 implements AskForPermissionStrategyModuleProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0716xe f762a = new C0716xe();

    @Override // io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider
    public final PermissionStrategy getAskForPermissionStrategy() {
        return this.f762a;
    }
}
