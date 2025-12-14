package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.services.ContextPermissionChecker;
/* renamed from: io.appmetrica.analytics.impl.ul  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0630ul implements PermissionExtractor {
    public static final String b = "[SimplePermissionExtractor]";

    /* renamed from: a  reason: collision with root package name */
    public final PermissionStrategy f1250a;

    public C0630ul(PermissionStrategy permissionStrategy) {
        this.f1250a = permissionStrategy;
    }

    public final PermissionStrategy a() {
        return this.f1250a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor
    public final boolean hasPermission(Context context, String str) {
        if (this.f1250a.forbidUsePermission(str)) {
            return false;
        }
        return ContextPermissionChecker.hasPermission(context, str);
    }
}
