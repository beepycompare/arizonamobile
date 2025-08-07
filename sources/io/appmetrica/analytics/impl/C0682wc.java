package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.wc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0682wc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0707xc f1120a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0682wc(C0707xc c0707xc) {
        super(0);
        this.f1120a = c0707xc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Pc ye;
        C0707xc c0707xc = this.f1120a;
        Qc qc = c0707xc.f;
        M9 m9 = c0707xc.b;
        C0212dh c0212dh = c0707xc.f1137a;
        J4 j4 = c0707xc.c;
        C0386kf c0386kf = c0707xc.d;
        qc.getClass();
        if (FrameworkDetector.isNative()) {
            C0307ha h = Ia.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f881a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                ye = new C0260fe();
                return ye.a();
            }
        }
        ye = new Ye(m9, c0212dh, j4, c0386kf);
        return ye.a();
    }
}
