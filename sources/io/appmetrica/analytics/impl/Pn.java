package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* loaded from: classes5.dex */
public final class Pn {

    /* renamed from: a  reason: collision with root package name */
    public final Rn f721a;
    public final Rn b;

    public Pn(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f721a = new Y2(new Sl(context));
            this.b = new Y2(new C0430md(context));
            return;
        }
        this.f721a = new C0554r8();
        this.b = new C0554r8();
    }
}
