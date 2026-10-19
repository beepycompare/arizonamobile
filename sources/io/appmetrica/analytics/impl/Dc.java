package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class Dc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ec f517a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Dc(Ec ec) {
        super(0);
        this.f517a = ec;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Vc c0399lf;
        Ec ec = this.f517a;
        Wc wc = ec.f;
        L9 l9 = ec.b;
        C0272gh c0272gh = ec.f532a;
        F4 f4 = ec.c;
        C0684wf c0684wf = ec.d;
        wc.getClass();
        if (FrameworkDetector.isNative()) {
            C0291ha i = Na.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f1016a);
            if (StringUtils.isNullOrEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                c0399lf = new C0553re();
                return c0399lf.a();
            }
        }
        c0399lf = new C0399lf(l9, c0272gh, f4, c0684wf);
        return c0399lf.a();
    }
}
