package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0624u implements InterfaceC0649v {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1064a;

    public C0624u(Context context) {
        this.f1064a = context;
    }

    public final String a() {
        C0704x4 l = C0704x4.l();
        Context context = this.f1064a;
        C0262fa c0262fa = l.t;
        if (c0262fa == null) {
            synchronized (l) {
                c0262fa = l.t;
                if (c0262fa == null) {
                    c0262fa = new C0262fa(context);
                    l.t = c0262fa;
                }
            }
        }
        Bundle applicationMetaData = c0262fa.d.getApplicationMetaData(c0262fa.f834a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
