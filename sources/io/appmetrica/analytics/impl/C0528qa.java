package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.qa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0528qa {

    /* renamed from: a  reason: collision with root package name */
    public final Yl f1024a = new Yl();
    public C0577sa b = new C0577sa();

    public final synchronized void a(C0577sa c0577sa) {
        this.b = c0577sa;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f1058a) != null) {
                boolean booleanValue = bool.booleanValue();
                C0577sa c0577sa = this.b;
                IdentifierStatus identifierStatus = c0577sa.b;
                String str2 = c0577sa.c;
                if (booleanValue) {
                    str = "true";
                } else if (!booleanValue) {
                    str = "false";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                hashMap.put("appmetrica_lib_ssl_enabled", this.f1024a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
