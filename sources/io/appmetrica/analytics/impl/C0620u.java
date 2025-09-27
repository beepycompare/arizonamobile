package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0620u implements InterfaceC0645v {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1101a;

    public C0620u(Context context) {
        this.f1101a = context;
    }

    public final String a() {
        A4 l = A4.l();
        Context context = this.f1101a;
        C0429ma c0429ma = l.t;
        if (c0429ma == null) {
            synchronized (l) {
                c0429ma = l.t;
                if (c0429ma == null) {
                    c0429ma = new C0429ma(context);
                    l.t = c0429ma;
                }
            }
        }
        Bundle applicationMetaData = c0429ma.d.getApplicationMetaData(c0429ma.f991a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
