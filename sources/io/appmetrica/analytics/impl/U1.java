package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class U1 {

    /* renamed from: a  reason: collision with root package name */
    public final List f800a;
    public final C0711y2 b;
    public final List c;

    public U1(List list, C0711y2 c0711y2, List list2) {
        this.f800a = list;
        this.b = c0711y2;
        this.c = list2;
    }

    public final String toString() {
        return "AppPermissionsState{mPermissionStateList=" + this.f800a + ", mBackgroundRestrictionsState=" + this.b + ", mAvailableProviders=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
