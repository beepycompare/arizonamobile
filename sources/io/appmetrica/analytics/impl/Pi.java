package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class Pi {

    /* renamed from: a  reason: collision with root package name */
    public final Context f741a;
    public final SafePackageManager b;

    public Pi(Context context, SafePackageManager safePackageManager) {
        this.f741a = context;
        this.b = safePackageManager;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        SafePackageManager safePackageManager = this.b;
        Context context = this.f741a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 4096);
        if (packageInfo != null) {
            String[] strArr = packageInfo.requestedPermissions;
            int[] iArr = packageInfo.requestedPermissionsFlags;
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i++) {
                    String str = strArr[i];
                    if (iArr != null && iArr.length > i && (iArr[i] & 2) != 0) {
                        arrayList.add(new PermissionState(str, true));
                    } else {
                        arrayList.add(new PermissionState(str, false));
                    }
                }
            }
        }
        return arrayList;
    }
}
