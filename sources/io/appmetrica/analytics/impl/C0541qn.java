package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.qn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0541qn {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0590sn f1032a;
    public final InterfaceC0590sn b;

    public C0541qn(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f1032a = new Y2(new C0588sl(context));
            this.b = new Y2(new C0329id(context));
            return;
        }
        this.f1032a = new C0625u8();
        this.b = new C0625u8();
    }
}
