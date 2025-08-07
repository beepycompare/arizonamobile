package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0619u implements InterfaceC0644v {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1074a;

    public C0619u(Context context) {
        this.f1074a = context;
    }

    public final String a() {
        C0699x4 l = C0699x4.l();
        Context context = this.f1074a;
        C0307ha c0307ha = l.t;
        if (c0307ha == null) {
            synchronized (l) {
                c0307ha = l.t;
                if (c0307ha == null) {
                    c0307ha = new C0307ha(context);
                    l.t = c0307ha;
                }
            }
        }
        Bundle applicationMetaData = c0307ha.d.getApplicationMetaData(c0307ha.f881a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
