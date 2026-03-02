package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.bc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0143bc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0169cc f918a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0143bc(C0169cc c0169cc) {
        super(0);
        this.f918a = c0169cc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InterfaceC0624uc ke;
        C0169cc c0169cc = this.f918a;
        C0649vc c0649vc = c0169cc.f;
        InterfaceC0546r9 interfaceC0546r9 = c0169cc.b;
        Qg qg = c0169cc.f936a;
        C0467o4 c0467o4 = c0169cc.c;
        We we = c0169cc.d;
        c0649vc.getClass();
        if (FrameworkDetector.isNative()) {
            M9 i = C0448na.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f690a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                ke = new Qd();
                return ke.a();
            }
        }
        ke = new Ke(interfaceC0546r9, qg, c0467o4, we);
        return ke.a();
    }
}
