package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0634v implements InterfaceC0659w {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1156a;

    public C0634v(Context context) {
        this.f1156a = context;
    }

    public final String a() {
        C0158c4 l = C0158c4.l();
        Context context = this.f1156a;
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
        Bundle applicationMetaData = n9.d.getApplicationMetaData(n9.f602a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
