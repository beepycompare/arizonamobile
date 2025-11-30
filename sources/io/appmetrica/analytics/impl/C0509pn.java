package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.pn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0509pn {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0558rn f1075a;
    public final InterfaceC0558rn b;

    public C0509pn(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f1075a = new M2(new C0482ol(context));
            this.b = new M2(new Mc(context));
            return;
        }
        this.f1075a = new Z7();
        this.b = new Z7();
    }
}
