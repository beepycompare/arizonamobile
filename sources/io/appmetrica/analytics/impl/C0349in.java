package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.in  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0349in {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0399kn f881a;
    public final InterfaceC0399kn b;

    public C0349in(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f881a = new Y2(new C0397kl(context));
            this.b = new Y2(new C0240ed(context));
            return;
        }
        this.f881a = new C0509p8();
        this.b = new C0509p8();
    }
}
