package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ln  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0418ln {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0468nn f944a;
    public final InterfaceC0468nn b;

    public C0418ln(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f944a = new Y2(new C0466nl(context));
            this.b = new Y2(new C0284gd(context));
            return;
        }
        this.f944a = new C0577s8();
        this.b = new C0577s8();
    }
}
