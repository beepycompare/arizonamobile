package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Q7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0376kb f726a;
    public String b = "";

    public Q7(InterfaceC0376kb interfaceC0376kb) {
        this.f726a = interfaceC0376kb;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || Intrinsics.areEqual(this.b, str)) {
                return;
            }
            this.b = str;
            this.f726a.a(str, z);
        }
    }
}
