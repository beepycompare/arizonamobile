package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.c2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0156c2 {

    /* renamed from: a  reason: collision with root package name */
    public final List f823a;
    public final F2 b;
    public final List c;

    public C0156c2(List list, F2 f2, List list2) {
        this.f823a = list;
        this.b = f2;
        this.c = list2;
    }

    public final String toString() {
        return "AppPermissionsState{mPermissionStateList=" + this.f823a + ", mBackgroundRestrictionsState=" + this.b + ", mAvailableProviders=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
