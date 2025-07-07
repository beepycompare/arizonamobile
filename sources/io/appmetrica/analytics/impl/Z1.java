package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Z1 {

    /* renamed from: a  reason: collision with root package name */
    public final List f729a;
    public final J2 b;
    public final List c;

    public Z1(List list, J2 j2, List list2) {
        this.f729a = list;
        this.b = j2;
        this.c = list2;
    }

    public final String toString() {
        return "AppPermissionsState{mPermissionStateList=" + this.f729a + ", mBackgroundRestrictionsState=" + this.b + ", mAvailableProviders=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
