package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.i6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0327i6 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f897a;

    public AbstractC0327i6(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public C0351j6 load(C0302h6 c0302h6) {
        C0351j6 c0351j6 = (C0351j6) super.load((AbstractC0327i6) c0302h6);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f897a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            c0351j6.f915a = (i & 2) != 0 ? "1" : "0";
            c0351j6.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            c0351j6.f915a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            c0351j6.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            c0351j6.f915a = "0";
            c0351j6.b = "0";
        }
        C0267fm c0267fm = c0302h6.f879a;
        c0351j6.c = c0267fm;
        c0351j6.setRetryPolicyConfig(c0267fm.t);
        return c0351j6;
    }

    public AbstractC0327i6(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f897a = safePackageManager;
    }
}
