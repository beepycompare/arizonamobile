package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class V7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0249fb f690a;
    public String b = "";

    public V7(InterfaceC0249fb interfaceC0249fb) {
        this.f690a = interfaceC0249fb;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || Intrinsics.areEqual(this.b, str)) {
                return;
            }
            this.b = str;
            this.f690a.a(str, z);
        }
    }
}
