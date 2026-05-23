package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public abstract class Ne {

    /* renamed from: a  reason: collision with root package name */
    public final int f683a = -1;
    public final int b = 0;
    public final int c = 1;

    public final int a(Boolean bool) {
        if (bool == null) {
            return this.f683a;
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            return this.b;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return this.c;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Boolean a(int i) {
        if (i == this.b) {
            return Boolean.FALSE;
        }
        if (i == this.c) {
            return Boolean.TRUE;
        }
        return null;
    }
}
