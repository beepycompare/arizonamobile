package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.f6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0250f6 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f833a;

    public AbstractC0250f6(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public C0275g6 load(C0225e6 c0225e6) {
        C0275g6 c0275g6 = (C0275g6) super.load((AbstractC0250f6) c0225e6);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f833a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            c0275g6.f852a = (i & 2) != 0 ? "1" : "0";
            c0275g6.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            c0275g6.f852a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            c0275g6.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            c0275g6.f852a = "0";
            c0275g6.b = "0";
        }
        C0190cm c0190cm = c0225e6.f817a;
        c0275g6.c = c0190cm;
        c0275g6.setRetryPolicyConfig(c0190cm.t);
        return c0275g6;
    }

    public AbstractC0250f6(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f833a = safePackageManager;
    }
}
