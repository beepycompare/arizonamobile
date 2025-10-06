package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class Bc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Cc f370a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bc(Cc cc) {
        super(0);
        this.f370a = cc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Uc c0228ef;
        Cc cc = this.f370a;
        Vc vc = cc.f;
        R9 r9 = cc.b;
        C0437mh c0437mh = cc.f390a;
        M4 m4 = cc.c;
        C0538qf c0538qf = cc.d;
        vc.getClass();
        if (FrameworkDetector.isNative()) {
            C0430ma h = Na.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f991a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                c0228ef = new C0408le();
                return c0228ef.a();
            }
        }
        c0228ef = new C0228ef(r9, c0437mh, m4, c0538qf);
        return c0228ef.a();
    }
}
