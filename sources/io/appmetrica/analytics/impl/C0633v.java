package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0633v implements InterfaceC0658w {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1239a;

    public C0633v(Context context) {
        this.f1239a = context;
    }

    public final String a() {
        C0157c4 l = C0157c4.l();
        Context context = this.f1239a;
        N9 n9 = l.t;
        if (n9 == null) {
            synchronized (l) {
                n9 = l.t;
                if (n9 == null) {
                    n9 = new N9(context);
                    l.t = n9;
                }
            }
        }
        Bundle applicationMetaData = n9.d.getApplicationMetaData(n9.f685a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
