package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.aa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0112aa {

    /* renamed from: a  reason: collision with root package name */
    public final Xl f800a = new Xl();
    public C0164ca b = new C0164ca();

    public final synchronized void a(C0164ca c0164ca) {
        this.b = c0164ca;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f827a) != null) {
                boolean booleanValue = bool.booleanValue();
                C0164ca c0164ca = this.b;
                IdentifierStatus identifierStatus = c0164ca.b;
                String str2 = c0164ca.c;
                if (booleanValue) {
                    str = "true";
                } else if (!booleanValue) {
                    str = "false";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                hashMap.put("appmetrica_lib_ssl_enabled", this.f800a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
