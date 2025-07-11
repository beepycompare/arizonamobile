package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0616u implements InterfaceC0641v {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1065a;

    public C0616u(Context context) {
        this.f1065a = context;
    }

    public final String a() {
        C0696x4 l = C0696x4.l();
        Context context = this.f1065a;
        C0254fa c0254fa = l.t;
        if (c0254fa == null) {
            synchronized (l) {
                c0254fa = l.t;
                if (c0254fa == null) {
                    c0254fa = new C0254fa(context);
                    l.t = c0254fa;
                }
            }
        }
        Bundle applicationMetaData = c0254fa.d.getApplicationMetaData(c0254fa.f835a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
