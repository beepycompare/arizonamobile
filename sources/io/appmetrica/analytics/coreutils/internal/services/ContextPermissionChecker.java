package io.appmetrica.analytics.coreutils.internal.services;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/services/ContextPermissionChecker;", "", "Landroid/content/Context;", "context", "", "permission", "", "hasPermission", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class ContextPermissionChecker {
    public static final ContextPermissionChecker INSTANCE = new ContextPermissionChecker();

    private ContextPermissionChecker() {
    }

    @JvmStatic
    public static final boolean hasPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
