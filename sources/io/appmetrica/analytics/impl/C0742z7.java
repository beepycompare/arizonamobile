package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.z7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0742z7 {

    /* renamed from: a  reason: collision with root package name */
    public final Ja f1229a;
    public String b = "";

    public C0742z7(Ja ja) {
        this.f1229a = ja;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || Intrinsics.areEqual(this.b, str)) {
                return;
            }
            this.b = str;
            this.f1229a.a(str, z);
        }
    }
}
