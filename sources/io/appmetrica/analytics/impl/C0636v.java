package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0636v implements InterfaceC0661w {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1264a;

    public C0636v(Context context) {
        this.f1264a = context;
    }

    public final String a() {
        C0135b4 l = C0135b4.l();
        Context context = this.f1264a;
        M9 m9 = l.t;
        if (m9 == null) {
            synchronized (l) {
                m9 = l.t;
                if (m9 == null) {
                    m9 = new M9(context);
                    l.t = m9;
                }
            }
        }
        Bundle applicationMetaData = m9.d.getApplicationMetaData(m9.f690a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
