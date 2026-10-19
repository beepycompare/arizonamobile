package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.w  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0668w implements InterfaceC0694x {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1259a;

    public C0668w(Context context) {
        this.f1259a = context;
    }

    public final String a() {
        C0569s4 l = C0569s4.l();
        Context context = this.f1259a;
        C0291ha c0291ha = l.u;
        if (c0291ha == null) {
            synchronized (l) {
                c0291ha = l.u;
                if (c0291ha == null) {
                    c0291ha = new C0291ha(context);
                    l.u = c0291ha;
                }
            }
        }
        Bundle applicationMetaData = c0291ha.d.getApplicationMetaData(c0291ha.f1016a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
