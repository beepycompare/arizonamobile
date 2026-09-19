package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class Dc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ec f514a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Dc(Ec ec) {
        super(0);
        this.f514a = ec;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Vc c0404lf;
        Ec ec = this.f514a;
        Wc wc = ec.f;
        L9 l9 = ec.b;
        C0277gh c0277gh = ec.f529a;
        F4 f4 = ec.c;
        C0689wf c0689wf = ec.d;
        wc.getClass();
        if (FrameworkDetector.isNative()) {
            C0296ha i = Na.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f1013a);
            if (StringUtils.isNullOrEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                c0404lf = new C0558re();
                return c0404lf.a();
            }
        }
        c0404lf = new C0404lf(l9, c0277gh, f4, c0689wf);
        return c0404lf.a();
    }
}
