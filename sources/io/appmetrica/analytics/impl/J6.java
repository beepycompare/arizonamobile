package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class J6 {

    /* renamed from: a  reason: collision with root package name */
    public volatile String f487a;

    public static String a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (String) cls.getMethod("getProcessName", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public final String b() {
        if (this.f487a != null) {
            return this.f487a;
        }
        synchronized (this) {
            if (this.f487a == null) {
                this.f487a = a();
            }
        }
        return this.f487a;
    }

    public final boolean c() {
        try {
            if (TextUtils.isEmpty(b())) {
                return false;
            }
            return !b().contains(StringUtils.PROCESS_POSTFIX_DELIMITER);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean a(String str) {
        try {
            if (!TextUtils.isEmpty(b())) {
                if (b().endsWith(StringUtils.PROCESS_POSTFIX_DELIMITER + str)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
