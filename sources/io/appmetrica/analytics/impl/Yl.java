package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.services.ContextPermissionChecker;
/* loaded from: classes5.dex */
public final class Yl implements PermissionExtractor {
    public static final String b = "[SimplePermissionExtractor]";

    /* renamed from: a  reason: collision with root package name */
    public final PermissionStrategy f863a;

    public Yl(PermissionStrategy permissionStrategy) {
        this.f863a = permissionStrategy;
    }

    public final PermissionStrategy a() {
        return this.f863a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor
    public final boolean hasPermission(Context context, String str) {
        if (this.f863a.forbidUsePermission(str)) {
            return false;
        }
        return ContextPermissionChecker.hasPermission(context, str);
    }
}
