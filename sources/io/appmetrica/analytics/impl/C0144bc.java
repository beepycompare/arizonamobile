package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.bc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0144bc extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0170cc f918a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0144bc(C0170cc c0170cc) {
        super(0);
        this.f918a = c0170cc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InterfaceC0625uc ke;
        C0170cc c0170cc = this.f918a;
        C0650vc c0650vc = c0170cc.f;
        InterfaceC0547r9 interfaceC0547r9 = c0170cc.b;
        Qg qg = c0170cc.f936a;
        C0468o4 c0468o4 = c0170cc.c;
        We we = c0170cc.d;
        c0650vc.getClass();
        if (FrameworkDetector.isNative()) {
            M9 i = C0449na.I.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f690a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                ke = new Qd();
                return ke.a();
            }
        }
        ke = new Ke(interfaceC0547r9, qg, c0468o4, we);
        return ke.a();
    }
}
