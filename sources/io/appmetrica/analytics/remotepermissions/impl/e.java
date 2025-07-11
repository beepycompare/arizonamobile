package io.appmetrica.analytics.remotepermissions.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import java.util.Set;
import kotlin.collections.SetsKt;
/* loaded from: classes4.dex */
public final class e implements PermissionStrategy {

    /* renamed from: a  reason: collision with root package name */
    public Set f1265a = SetsKt.emptySet();

    public final synchronized void a(Set<String> set) {
        this.f1265a = set;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy
    public final synchronized boolean forbidUsePermission(String str) {
        return !this.f1265a.contains(str);
    }
}
