package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.on  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0486on {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0536qn f1167a;
    public final InterfaceC0536qn b;

    public C0486on(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f1167a = new L2(new C0459nl(context));
            this.b = new L2(new Lc(context));
            return;
        }
        this.f1167a = new Y7();
        this.b = new Y7();
    }
}
