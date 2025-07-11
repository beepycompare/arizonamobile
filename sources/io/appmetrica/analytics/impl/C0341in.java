package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.in  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0341in {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0391kn f882a;
    public final InterfaceC0391kn b;

    public C0341in(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f882a = new Y2(new C0389kl(context));
            this.b = new Y2(new C0232ed(context));
            return;
        }
        this.f882a = new C0501p8();
        this.b = new C0501p8();
    }
}
