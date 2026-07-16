package io.appmetrica.analytics.identifiers.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final IdentifierStatus f402a;
    public final a b;
    public final String c;

    public c(IdentifierStatus identifierStatus, a aVar, String str) {
        this.f402a = identifierStatus;
        this.b = aVar;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f402a == cVar.f402a && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f402a.hashCode() * 31;
        a aVar = this.b;
        int hashCode2 = (hashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
        String str = this.c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "AdvIdResult(status=" + this.f402a + ", advIdInfo=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    public /* synthetic */ c(IdentifierStatus identifierStatus, a aVar, String str, int i) {
        this(identifierStatus, (i & 2) != 0 ? null : aVar, (i & 4) != 0 ? null : str);
    }
}
