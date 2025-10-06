package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider;
/* renamed from: io.appmetrica.analytics.impl.a8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0118a8 implements AskForPermissionStrategyModuleProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0561re f789a = new C0561re();

    @Override // io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider
    public final PermissionStrategy getAskForPermissionStrategy() {
        return this.f789a;
    }
}
