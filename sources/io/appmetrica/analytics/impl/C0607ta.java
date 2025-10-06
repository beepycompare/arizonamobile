package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.ta  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0607ta {

    /* renamed from: a  reason: collision with root package name */
    public final C0184cm f1094a = new C0184cm();
    public C0657va b = new C0657va();

    public final synchronized void a(C0657va c0657va) {
        this.b = c0657va;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f1124a) != null) {
                boolean booleanValue = bool.booleanValue();
                C0657va c0657va = this.b;
                IdentifierStatus identifierStatus = c0657va.b;
                String str2 = c0657va.c;
                if (booleanValue) {
                    str = "true";
                } else if (!booleanValue) {
                    str = "false";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                hashMap.put("appmetrica_lib_ssl_enabled", this.f1094a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
