package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.oa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0478oa {

    /* renamed from: a  reason: collision with root package name */
    public final C0671vm f1130a = new C0671vm();
    public C0530qa b = new C0530qa();

    public final synchronized void a(C0530qa c0530qa) {
        this.b = c0530qa;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f1165a) != null) {
                boolean booleanValue = bool.booleanValue();
                C0530qa c0530qa = this.b;
                IdentifierStatus identifierStatus = c0530qa.b;
                String str2 = c0530qa.c;
                if (booleanValue) {
                    str = "true";
                } else if (!booleanValue) {
                    str = "false";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                hashMap.put("appmetrica_lib_ssl_enabled", this.f1130a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
