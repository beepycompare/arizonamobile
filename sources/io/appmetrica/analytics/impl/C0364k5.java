package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.k5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0364k5 implements PermissionStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final PermissionStrategy[] f1066a;

    public C0364k5(PermissionStrategy... permissionStrategyArr) {
        this.f1066a = permissionStrategyArr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy
    public final boolean forbidUsePermission(String str) {
        for (PermissionStrategy permissionStrategy : this.f1066a) {
            if (permissionStrategy.forbidUsePermission(str)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "CompositePermissionStrategy(strategies=" + Arrays.toString(this.f1066a) + ')';
    }
}
