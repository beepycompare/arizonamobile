package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class C5 implements PermissionStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final PermissionStrategy[] f367a;

    public C5(PermissionStrategy... permissionStrategyArr) {
        this.f367a = permissionStrategyArr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy
    public final boolean forbidUsePermission(String str) {
        for (PermissionStrategy permissionStrategy : this.f367a) {
            if (permissionStrategy.forbidUsePermission(str)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "CompositePermissionStrategy(strategies=" + Arrays.toString(this.f367a) + ')';
    }
}
