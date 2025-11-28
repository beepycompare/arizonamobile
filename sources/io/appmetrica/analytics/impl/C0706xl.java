package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.services.ContextPermissionChecker;
/* renamed from: io.appmetrica.analytics.impl.xl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0706xl implements PermissionExtractor {
    public static final String b = "[SimplePermissionExtractor]";

    /* renamed from: a  reason: collision with root package name */
    public final PermissionStrategy f1203a;

    public C0706xl(PermissionStrategy permissionStrategy) {
        this.f1203a = permissionStrategy;
    }

    public final PermissionStrategy a() {
        return this.f1203a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor
    public final boolean hasPermission(Context context, String str) {
        if (this.f1203a.forbidUsePermission(str)) {
            return false;
        }
        return ContextPermissionChecker.hasPermission(context, str);
    }
}
