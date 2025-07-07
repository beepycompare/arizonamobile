package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.f6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0258f6 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f832a;

    public AbstractC0258f6(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public C0283g6 load(C0233e6 c0233e6) {
        C0283g6 c0283g6 = (C0283g6) super.load((AbstractC0258f6) c0233e6);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f832a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            c0283g6.f851a = (i & 2) != 0 ? "1" : "0";
            c0283g6.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            c0283g6.f851a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            c0283g6.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            c0283g6.f851a = "0";
            c0283g6.b = "0";
        }
        C0198cm c0198cm = c0233e6.f816a;
        c0283g6.c = c0198cm;
        c0283g6.setRetryPolicyConfig(c0198cm.t);
        return c0283g6;
    }

    public AbstractC0258f6(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f832a = safePackageManager;
    }
}
