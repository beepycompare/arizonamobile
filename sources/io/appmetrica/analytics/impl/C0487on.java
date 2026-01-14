package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.on  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0487on {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0537qn f1163a;
    public final InterfaceC0537qn b;

    public C0487on(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f1163a = new L2(new C0460nl(context));
            this.b = new L2(new Lc(context));
            return;
        }
        this.f1163a = new Y7();
        this.b = new Y7();
    }
}
