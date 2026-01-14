package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.y7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0720y7 {

    /* renamed from: a  reason: collision with root package name */
    public final Ia f1318a;
    public String b = "";

    public C0720y7(Ia ia) {
        this.f1318a = ia;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || Intrinsics.areEqual(this.b, str)) {
                return;
            }
            this.b = str;
            this.f1318a.a(str, z);
        }
    }
}
