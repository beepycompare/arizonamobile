package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.UserManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.eo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0237eo {
    public static boolean a(Context context) {
        return ((Boolean) SystemServiceUtils.accessSystemServiceSafelyOrDefault((UserManager) context.getSystemService(UserManager.class), "detect unlocked user state", "User manager", Boolean.TRUE, new Cdo())).booleanValue();
    }
}
