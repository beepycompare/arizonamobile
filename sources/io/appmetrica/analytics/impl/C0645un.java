package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.un  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0645un {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0695wn f1117a;
    public final InterfaceC0695wn b;

    public C0645un(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f1117a = new C0139b3(new C0693wl(context));
            this.b = new C0139b3(new C0407ld(context));
            return;
        }
        this.f1117a = new C0705x8();
        this.b = new C0705x8();
    }
}
