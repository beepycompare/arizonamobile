package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.g2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0264g2 {

    /* renamed from: a  reason: collision with root package name */
    public final List f989a;
    public final K2 b;
    public final List c;

    public C0264g2(List list, K2 k2, List list2) {
        this.f989a = list;
        this.b = k2;
        this.c = list2;
    }

    public final String toString() {
        return "AppPermissionsState{mPermissionStateList=" + this.f989a + ", mBackgroundRestrictionsState=" + this.b + ", mAvailableProviders=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
