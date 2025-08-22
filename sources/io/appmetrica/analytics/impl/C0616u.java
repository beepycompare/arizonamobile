package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0616u implements InterfaceC0641v {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1079a;

    public C0616u(Context context) {
        this.f1079a = context;
    }

    public final String a() {
        C0696x4 l = C0696x4.l();
        Context context = this.f1079a;
        C0351ja c0351ja = l.t;
        if (c0351ja == null) {
            synchronized (l) {
                c0351ja = l.t;
                if (c0351ja == null) {
                    c0351ja = new C0351ja(context);
                    l.t = c0351ja;
                }
            }
        }
        Bundle applicationMetaData = c0351ja.d.getApplicationMetaData(c0351ja.f921a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
