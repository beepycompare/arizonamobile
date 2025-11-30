package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.cc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0166cc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0192dc f830a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0166cc(C0192dc c0192dc) {
        super(0);
        this.f830a = c0192dc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InterfaceC0647vc le;
        C0192dc c0192dc = this.f830a;
        C0672wc c0672wc = c0192dc.f;
        InterfaceC0569s9 interfaceC0569s9 = c0192dc.b;
        Rg rg = c0192dc.f849a;
        C0490p4 c0490p4 = c0192dc.c;
        Xe xe = c0192dc.d;
        c0672wc.getClass();
        if (FrameworkDetector.isNative()) {
            N9 i = C0471oa.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f602a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                le = new Rd();
                return le.a();
            }
        }
        le = new Le(interfaceC0569s9, rg, c0490p4, xe);
        return le.a();
    }
}
