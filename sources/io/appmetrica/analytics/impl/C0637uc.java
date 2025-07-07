package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.uc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0637uc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0662vc f1074a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0637uc(C0662vc c0662vc) {
        super(0);
        this.f1074a = c0662vc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Nc we;
        C0662vc c0662vc = this.f1074a;
        Oc oc = c0662vc.f;
        J9 j9 = c0662vc.b;
        C0167bh c0167bh = c0662vc.f1091a;
        J4 j4 = c0662vc.c;
        Cif cif = c0662vc.d;
        oc.getClass();
        if (FrameworkDetector.isNative()) {
            C0262fa h = Ga.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f834a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                we = new C0216de();
                return we.a();
            }
        }
        we = new We(j9, c0167bh, j4, cif);
        return we.a();
    }
}
