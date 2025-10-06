package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.l6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0400l6 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f966a;

    public AbstractC0400l6(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public C0426m6 load(C0374k6 c0374k6) {
        C0426m6 c0426m6 = (C0426m6) super.load((AbstractC0400l6) c0374k6);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f966a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            c0426m6.f989a = (i & 2) != 0 ? "1" : "0";
            c0426m6.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            c0426m6.f989a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            c0426m6.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            c0426m6.f989a = "0";
            c0426m6.b = "0";
        }
        C0494om c0494om = c0374k6.f950a;
        c0426m6.c = c0494om;
        c0426m6.setRetryPolicyConfig(c0494om.t);
        return c0426m6;
    }

    public AbstractC0400l6(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f966a = safePackageManager;
    }
}
