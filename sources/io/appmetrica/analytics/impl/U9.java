package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class U9 {

    /* renamed from: a  reason: collision with root package name */
    public final Ul f806a = new Ul();
    public W9 b = new W9();

    public final synchronized void a(W9 w9) {
        this.b = w9;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f835a) != null) {
                boolean booleanValue = bool.booleanValue();
                W9 w9 = this.b;
                IdentifierStatus identifierStatus = w9.b;
                String str2 = w9.c;
                if (booleanValue) {
                    str = "true";
                } else if (!booleanValue) {
                    str = "false";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                hashMap.put("appmetrica_lib_ssl_enabled", this.f806a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
