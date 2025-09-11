package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class Bc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Cc f369a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bc(Cc cc) {
        super(0);
        this.f369a = cc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Uc c0227ef;
        Cc cc = this.f369a;
        Vc vc = cc.f;
        R9 r9 = cc.b;
        C0436mh c0436mh = cc.f389a;
        M4 m4 = cc.c;
        C0537qf c0537qf = cc.d;
        vc.getClass();
        if (FrameworkDetector.isNative()) {
            C0429ma h = Na.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f990a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                c0227ef = new C0407le();
                return c0227ef.a();
            }
        }
        c0227ef = new C0227ef(r9, c0436mh, m4, c0537qf);
        return c0227ef.a();
    }
}
