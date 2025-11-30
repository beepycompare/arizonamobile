package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class U1 {

    /* renamed from: a  reason: collision with root package name */
    public final List f702a;
    public final C0712y2 b;
    public final List c;

    public U1(List list, C0712y2 c0712y2, List list2) {
        this.f702a = list;
        this.b = c0712y2;
        this.c = list2;
    }

    public final String toString() {
        return "AppPermissionsState{mPermissionStateList=" + this.f702a + ", mBackgroundRestrictionsState=" + this.b + ", mAvailableProviders=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
