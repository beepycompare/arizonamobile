package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.cc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0165cc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0191dc f913a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0165cc(C0191dc c0191dc) {
        super(0);
        this.f913a = c0191dc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InterfaceC0646vc le;
        C0191dc c0191dc = this.f913a;
        C0671wc c0671wc = c0191dc.f;
        InterfaceC0568s9 interfaceC0568s9 = c0191dc.b;
        Rg rg = c0191dc.f932a;
        C0489p4 c0489p4 = c0191dc.c;
        Xe xe = c0191dc.d;
        c0671wc.getClass();
        if (FrameworkDetector.isNative()) {
            N9 i = C0470oa.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f685a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                le = new Rd();
                return le.a();
            }
        }
        le = new Le(interfaceC0568s9, rg, c0489p4, xe);
        return le.a();
    }
}
