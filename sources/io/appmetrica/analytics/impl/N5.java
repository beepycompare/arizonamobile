package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public abstract class N5 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f696a;

    public N5(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public O5 load(M5 m5) {
        O5 o5 = (O5) super.load((N5) m5);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f696a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            o5.f715a = (i & 2) != 0 ? "1" : "0";
            o5.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            o5.f715a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            o5.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            o5.f715a = "0";
            o5.b = "0";
        }
        C0278gm c0278gm = m5.f681a;
        o5.c = c0278gm;
        o5.setRetryPolicyConfig(c0278gm.t);
        return o5;
    }

    public N5(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f696a = safePackageManager;
    }
}
