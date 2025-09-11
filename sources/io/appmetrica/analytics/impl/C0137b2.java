package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.b2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0137b2 {

    /* renamed from: a  reason: collision with root package name */
    public final List f802a;
    public final M2 b;
    public final List c;

    public C0137b2(List list, M2 m2, List list2) {
        this.f802a = list;
        this.b = m2;
        this.c = list2;
    }

    public final String toString() {
        return "AppPermissionsState{mPermissionStateList=" + this.f802a + ", mBackgroundRestrictionsState=" + this.b + ", mAvailableProviders=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
