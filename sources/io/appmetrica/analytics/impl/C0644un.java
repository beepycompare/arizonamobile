package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.un  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0644un {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0694wn f1117a;
    public final InterfaceC0694wn b;

    public C0644un(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f1117a = new C0138b3(new C0692wl(context));
            this.b = new C0138b3(new C0406ld(context));
            return;
        }
        this.f1117a = new C0704x8();
        this.b = new C0704x8();
    }
}
