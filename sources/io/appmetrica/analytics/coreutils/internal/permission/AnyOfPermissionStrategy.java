package io.appmetrica.analytics.coreutils.internal.permission;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016¨\u0006\r"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/permission/AnyOfPermissionStrategy;", "Lio/appmetrica/analytics/coreutils/internal/permission/MultiplePermissionBaseStrategy;", "permissionExtractor", "Lio/appmetrica/analytics/coreapi/internal/system/PermissionExtractor;", "permissions", "", "", "(Lio/appmetrica/analytics/coreapi/internal/system/PermissionExtractor;[Ljava/lang/String;)V", "hasNecessaryPermissions", "", "context", "Landroid/content/Context;", "", "core-utils_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnyOfPermissionStrategy extends MultiplePermissionBaseStrategy {
    public AnyOfPermissionStrategy(PermissionExtractor permissionExtractor, String... strArr) {
        super(permissionExtractor, ArraysKt.toList(strArr));
    }

    @Override // io.appmetrica.analytics.coreutils.internal.permission.MultiplePermissionBaseStrategy
    public boolean hasNecessaryPermissions(Context context, PermissionExtractor permissionExtractor, List<String> list) {
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            if (permissionExtractor.hasPermission(context, str)) {
                return true;
            }
        }
        return false;
    }
}
