package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0436ma {

    /* renamed from: a  reason: collision with root package name */
    public final Ql f936a = new Ql();
    public C0486oa b = new C0486oa();

    public final synchronized void a(C0486oa c0486oa) {
        this.b = c0486oa;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f970a) != null) {
                boolean booleanValue = bool.booleanValue();
                C0486oa c0486oa = this.b;
                IdentifierStatus identifierStatus = c0486oa.b;
                String str2 = c0486oa.c;
                if (booleanValue) {
                    str = "true";
                } else if (!booleanValue) {
                    str = "false";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                hashMap.put("appmetrica_lib_ssl_enabled", this.f936a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
