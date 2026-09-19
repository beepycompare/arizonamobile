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
public final class C0477oa {

    /* renamed from: a  reason: collision with root package name */
    public final C0670vm f1130a = new C0670vm();
    public C0529qa b = new C0529qa();

    public final synchronized void a(C0529qa c0529qa) {
        this.b = c0529qa;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f1165a) != null) {
                boolean booleanValue = bool.booleanValue();
                C0529qa c0529qa = this.b;
                IdentifierStatus identifierStatus = c0529qa.b;
                String str2 = c0529qa.c;
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
