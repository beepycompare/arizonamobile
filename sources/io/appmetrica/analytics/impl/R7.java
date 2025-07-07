package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class R7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0161bb f603a;
    public String b = "";

    public R7(InterfaceC0161bb interfaceC0161bb) {
        this.f603a = interfaceC0161bb;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || Intrinsics.areEqual(this.b, str)) {
                return;
            }
            this.b = str;
            this.f603a.a(str, z);
        }
    }
}
