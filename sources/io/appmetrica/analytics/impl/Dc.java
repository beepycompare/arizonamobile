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
        Vc c0405lf;
        Ec ec = this.f514a;
        Wc wc = ec.f;
        L9 l9 = ec.b;
        C0278gh c0278gh = ec.f529a;
        F4 f4 = ec.c;
        C0690wf c0690wf = ec.d;
        wc.getClass();
        if (FrameworkDetector.isNative()) {
            C0297ha i = Na.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f1013a);
            if (StringUtils.isNullOrEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                c0405lf = new C0559re();
                return c0405lf.a();
            }
        }
        c0405lf = new C0405lf(l9, c0278gh, f4, c0690wf);
        return c0405lf.a();
    }
}
