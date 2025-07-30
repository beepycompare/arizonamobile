package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0618u implements InterfaceC0643v {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1075a;

    public C0618u(Context context) {
        this.f1075a = context;
    }

    public final String a() {
        C0698x4 l = C0698x4.l();
        Context context = this.f1075a;
        C0306ha c0306ha = l.t;
        if (c0306ha == null) {
            synchronized (l) {
                c0306ha = l.t;
                if (c0306ha == null) {
                    c0306ha = new C0306ha(context);
                    l.t = c0306ha;
                }
            }
        }
        Bundle applicationMetaData = c0306ha.d.getApplicationMetaData(c0306ha.f882a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
