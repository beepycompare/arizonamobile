package io.appmetrica.analytics.remotepermissions.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import java.util.Set;
import kotlin.collections.SetsKt;
/* loaded from: classes5.dex */
public final class d implements PermissionStrategy {

    /* renamed from: a  reason: collision with root package name */
    public Set f1426a = SetsKt.emptySet();

    public final synchronized void a(Set<String> set) {
        this.f1426a = set;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy
    public final synchronized boolean forbidUsePermission(String str) {
        return !this.f1426a.contains(str);
    }
}
