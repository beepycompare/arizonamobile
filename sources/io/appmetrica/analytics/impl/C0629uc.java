package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.uc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0629uc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0654vc f1075a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0629uc(C0654vc c0654vc) {
        super(0);
        this.f1075a = c0654vc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Nc we;
        C0654vc c0654vc = this.f1075a;
        Oc oc = c0654vc.f;
        J9 j9 = c0654vc.b;
        C0159bh c0159bh = c0654vc.f1092a;
        J4 j4 = c0654vc.c;
        Cif cif = c0654vc.d;
        oc.getClass();
        if (FrameworkDetector.isNative()) {
            C0254fa h = Ga.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f835a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                we = new C0208de();
                return we.a();
            }
        }
        we = new We(j9, c0159bh, j4, cif);
        return we.a();
    }
}
