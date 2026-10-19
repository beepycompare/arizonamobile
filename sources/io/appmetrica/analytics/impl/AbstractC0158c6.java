package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.c6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0158c6 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f926a;

    public AbstractC0158c6(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public C0184d6 load(C0132b6 c0132b6) {
        C0184d6 c0184d6 = (C0184d6) super.load((AbstractC0158c6) c0132b6);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f926a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            c0184d6.f944a = (i & 2) != 0 ? "1" : "0";
            c0184d6.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            c0184d6.f944a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            c0184d6.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            c0184d6.f944a = "0";
            c0184d6.b = "0";
        }
        Hm hm = c0132b6.f907a;
        c0184d6.c = hm;
        c0184d6.setRetryPolicyConfig(hm.t);
        return c0184d6;
    }

    public AbstractC0158c6(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f926a = safePackageManager;
    }
}
