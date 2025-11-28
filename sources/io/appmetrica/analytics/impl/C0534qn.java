package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.qn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0534qn {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0583sn f1081a;
    public final InterfaceC0583sn b;

    public C0534qn(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f1081a = new T2(new C0556rl(context));
            this.b = new T2(new Sc(context));
            return;
        }
        this.f1081a = new C0213e8();
        this.b = new C0213e8();
    }
}
