package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;
@DoNotMock("Use an instance of one of the Finalizable*Reference classes")
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface FinalizableReference {
    void finalizeReferent();
}
