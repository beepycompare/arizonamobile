package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.ze  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0756ze {

    /* renamed from: a  reason: collision with root package name */
    public final int f1166a = -1;
    public final int b = 0;
    public final int c = 1;

    public final int a(Boolean bool) {
        if (bool == null) {
            return this.f1166a;
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
