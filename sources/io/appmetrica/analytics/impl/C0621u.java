package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0621u implements InterfaceC0646v {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1101a;

    public C0621u(Context context) {
        this.f1101a = context;
    }

    public final String a() {
        A4 l = A4.l();
        Context context = this.f1101a;
        C0430ma c0430ma = l.t;
        if (c0430ma == null) {
            synchronized (l) {
                c0430ma = l.t;
                if (c0430ma == null) {
                    c0430ma = new C0430ma(context);
                    l.t = c0430ma;
                }
            }
        }
        Bundle applicationMetaData = c0430ma.d.getApplicationMetaData(c0430ma.f991a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
