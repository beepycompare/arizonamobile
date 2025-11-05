package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.ic  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0321ic extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0346jc f932a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0321ic(C0346jc c0346jc) {
        super(0);
        this.f932a = c0346jc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bc pe;
        C0346jc c0346jc = this.f932a;
        Cc cc = c0346jc.f;
        InterfaceC0719y9 interfaceC0719y9 = c0346jc.b;
        Vg vg = c0346jc.f952a;
        C0639v4 c0639v4 = c0346jc.c;
        C0143bf c0143bf = c0346jc.d;
        cc.getClass();
        if (FrameworkDetector.isNative()) {
            T9 i = C0620ua.H.i();
            Bundle applicationMetaData = i.d.getApplicationMetaData(i.f702a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                pe = new Xd();
                return pe.a();
            }
        }
        pe = new Pe(interfaceC0719y9, vg, c0639v4, c0143bf);
        return pe.a();
    }
}
