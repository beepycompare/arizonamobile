package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Y7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0327ib f749a;
    public String b = "";

    public Y7(InterfaceC0327ib interfaceC0327ib) {
        this.f749a = interfaceC0327ib;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || Intrinsics.areEqual(this.b, str)) {
                return;
            }
            this.b = str;
            this.f749a.a(str, z);
        }
    }
}
