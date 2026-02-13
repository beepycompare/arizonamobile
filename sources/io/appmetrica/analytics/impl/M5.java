package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public abstract class M5 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f686a;

    public M5(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public N5 load(L5 l5) {
        N5 n5 = (N5) super.load((M5) l5);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f686a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            n5.f705a = (i & 2) != 0 ? "1" : "0";
            n5.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            n5.f705a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            n5.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            n5.f705a = "0";
            n5.b = "0";
        }
        C0257fm c0257fm = l5.f671a;
        n5.c = c0257fm;
        n5.setRetryPolicyConfig(c0257fm.t);
        return n5;
    }

    public M5(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f686a = safePackageManager;
    }
}
