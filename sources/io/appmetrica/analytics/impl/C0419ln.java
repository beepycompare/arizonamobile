package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ln  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0419ln {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0469nn f943a;
    public final InterfaceC0469nn b;

    public C0419ln(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f943a = new Y2(new C0467nl(context));
            this.b = new Y2(new C0285gd(context));
            return;
        }
        this.f943a = new C0578s8();
        this.b = new C0578s8();
    }
}
