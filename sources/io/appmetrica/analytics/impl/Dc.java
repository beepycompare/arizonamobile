package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class Dc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ec f512a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Dc(Ec ec) {
        super(0);
        this.f512a = ec;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Vc c0406lf;
        Ec ec = this.f512a;
        Wc wc = ec.f;
        L9 l9 = ec.b;
        C0279gh c0279gh = ec.f527a;
        F4 f4 = ec.c;
        C0691wf c0691wf = ec.d;
        wc.getClass();
        if (FrameworkDetector.isNative()) {
            C0298ha i = Na.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f1011a);
            if (StringUtils.isNullOrEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                c0406lf = new C0560re();
                return c0406lf.a();
            }
        }
        c0406lf = new C0406lf(l9, c0279gh, f4, c0691wf);
        return c0406lf.a();
    }
}
