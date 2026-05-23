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
public final class C0479oa {

    /* renamed from: a  reason: collision with root package name */
    public final C0672vm f1127a = new C0672vm();
    public C0531qa b = new C0531qa();

    public final synchronized void a(C0531qa c0531qa) {
        this.b = c0531qa;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f1162a) != null) {
                boolean booleanValue = bool.booleanValue();
                C0531qa c0531qa = this.b;
                IdentifierStatus identifierStatus = c0531qa.b;
                String str2 = c0531qa.c;
                if (booleanValue) {
                    str = "true";
                } else if (!booleanValue) {
                    str = "false";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                hashMap.put("appmetrica_lib_ssl_enabled", this.f1127a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
