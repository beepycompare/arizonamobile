package com.arkivanov.decompose.router.panels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildPanelsMode.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"isSingle", "", "Lcom/arkivanov/decompose/router/panels/ChildPanelsMode;", "(Lcom/arkivanov/decompose/router/panels/ChildPanelsMode;)Z", "isDual", "isTriple", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildPanelsModeKt {
    public static final boolean isSingle(ChildPanelsMode childPanelsMode) {
        Intrinsics.checkNotNullParameter(childPanelsMode, "<this>");
        return childPanelsMode == ChildPanelsMode.SINGLE;
    }

    public static final boolean isDual(ChildPanelsMode childPanelsMode) {
        Intrinsics.checkNotNullParameter(childPanelsMode, "<this>");
        return childPanelsMode == ChildPanelsMode.DUAL;
    }

    public static final boolean isTriple(ChildPanelsMode childPanelsMode) {
        Intrinsics.checkNotNullParameter(childPanelsMode, "<this>");
        return childPanelsMode == ChildPanelsMode.TRIPLE;
    }
}
