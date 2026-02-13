package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class T1 {

    /* renamed from: a  reason: collision with root package name */
    public final List f790a;
    public final C0690x2 b;
    public final List c;

    public T1(List list, C0690x2 c0690x2, List list2) {
        this.f790a = list;
        this.b = c0690x2;
        this.c = list2;
    }

    public final String toString() {
        return "AppPermissionsState{mPermissionStateList=" + this.f790a + ", mBackgroundRestrictionsState=" + this.b + ", mAvailableProviders=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
