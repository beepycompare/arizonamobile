package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider;
/* loaded from: classes4.dex */
public final class W7 implements AskForPermissionStrategyModuleProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0410le f697a = new C0410le();

    @Override // io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider
    public final PermissionStrategy getAskForPermissionStrategy() {
        return this.f697a;
    }
}
