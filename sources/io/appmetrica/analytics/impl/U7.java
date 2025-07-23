package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class U7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0205db f665a;
    public String b = "";

    public U7(InterfaceC0205db interfaceC0205db) {
        this.f665a = interfaceC0205db;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || Intrinsics.areEqual(this.b, str)) {
                return;
            }
            this.b = str;
            this.f665a.a(str, z);
        }
    }
}
