package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.yc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0729yc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0754zc f1158a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0729yc(C0754zc c0754zc) {
        super(0);
        this.f1158a = c0754zc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Rc c0124af;
        C0754zc c0754zc = this.f1158a;
        Sc sc = c0754zc.f;
        O9 o9 = c0754zc.b;
        C0332ih c0332ih = c0754zc.f1179a;
        J4 j4 = c0754zc.c;
        C0433mf c0433mf = c0754zc.d;
        sc.getClass();
        if (FrameworkDetector.isNative()) {
            C0351ja h = Ka.F.h();
            Bundle applicationMetaData = h.d.getApplicationMetaData(h.f921a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                c0124af = new C0304he();
                return c0124af.a();
            }
        }
        c0124af = new C0124af(o9, c0332ih, j4, c0433mf);
        return c0124af.a();
    }
}
