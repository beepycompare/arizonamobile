package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public abstract class T5 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f698a;

    public T5(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public U5 load(S5 s5) {
        U5 u5 = (U5) super.load((T5) s5);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f698a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            u5.f717a = (i & 2) != 0 ? "1" : "0";
            u5.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            u5.f717a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            u5.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            u5.f717a = "0";
            u5.b = "0";
        }
        C0356jm c0356jm = s5.f677a;
        u5.c = c0356jm;
        u5.setRetryPolicyConfig(c0356jm.t);
        return u5;
    }

    public T5(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f698a = safePackageManager;
    }
}
