package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class T9 {

    /* renamed from: a  reason: collision with root package name */
    public final Tl f801a = new Tl();
    public V9 b = new V9();

    public final synchronized void a(V9 v9) {
        this.b = v9;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f830a) != null) {
                boolean booleanValue = bool.booleanValue();
                V9 v9 = this.b;
                IdentifierStatus identifierStatus = v9.b;
                String str2 = v9.c;
                if (booleanValue) {
                    str = "true";
                } else if (!booleanValue) {
                    str = "false";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                hashMap.put("appmetrica_lib_ssl_enabled", this.f801a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
