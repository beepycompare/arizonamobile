package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class R7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0153bb f604a;
    public String b = "";

    public R7(InterfaceC0153bb interfaceC0153bb) {
        this.f604a = interfaceC0153bb;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || Intrinsics.areEqual(this.b, str)) {
                return;
            }
            this.b = str;
            this.f604a.a(str, z);
        }
    }
}
