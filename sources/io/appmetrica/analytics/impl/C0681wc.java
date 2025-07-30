package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.wc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0681wc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0706xc f1121a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0681wc(C0706xc c0706xc) {
        super(0);
        this.f1121a = c0706xc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Pc ye;
        C0706xc c0706xc = this.f1121a;
        Qc qc = c0706xc.f;
        M9 m9 = c0706xc.b;
        C0211dh c0211dh = c0706xc.f1138a;
        J4 j4 = c0706xc.c;
        C0385kf c0385kf = c0706xc.d;
        qc.getClass();
        if (FrameworkDetector.isNative()) {
            C0306ha h = Ia.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f882a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                ye = new C0259fe();
                return ye.a();
            }
        }
        ye = new Ye(m9, c0211dh, j4, c0385kf);
        return ye.a();
    }
}
