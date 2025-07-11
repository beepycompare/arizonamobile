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
public final class C0428ma {

    /* renamed from: a  reason: collision with root package name */
    public final Ql f937a = new Ql();
    public C0478oa b = new C0478oa();

    public final synchronized void a(C0478oa c0478oa) {
        this.b = c0478oa;
    }

    public final synchronized void a(List list, HashMap hashMap) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f971a) != null) {
                boolean booleanValue = bool.booleanValue();
                C0478oa c0478oa = this.b;
                IdentifierStatus identifierStatus = c0478oa.b;
                String str2 = c0478oa.c;
                if (booleanValue) {
                    str = "true";
                } else if (!booleanValue) {
                    str = "false";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                hashMap.put("appmetrica_lib_ssl_enabled", this.f937a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
