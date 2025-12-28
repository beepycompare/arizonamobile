package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.pn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0508pn {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0557rn f1173a;
    public final InterfaceC0557rn b;

    public C0508pn(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f1173a = new M2(new C0481ol(context));
            this.b = new M2(new Mc(context));
            return;
        }
        this.f1173a = new Z7();
        this.b = new Z7();
    }
}
