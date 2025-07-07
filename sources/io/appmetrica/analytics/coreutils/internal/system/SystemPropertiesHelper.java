package io.appmetrica.analytics.coreutils.internal.system;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0005"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/system/SystemPropertiesHelper;", "", "", "name", "readSystemProperty", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class SystemPropertiesHelper {
    public static final SystemPropertiesHelper INSTANCE = new SystemPropertiesHelper();

    private SystemPropertiesHelper() {
    }

    @JvmStatic
    public static final String readSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties", true, Context.class.getClassLoader());
            Object invoke = cls.getMethod("get", String.class).invoke(cls, str);
            String str2 = invoke instanceof String ? (String) invoke : null;
            return str2 == null ? "" : str2;
        } catch (Exception unused) {
            return "";
        }
    }
}
