package com.arkivanov.decompose.router.children;

import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildControllerExt.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"isActive", "", "C", "", "Lcom/arkivanov/decompose/router/children/ChildController;", "configuration", "(Lcom/arkivanov/decompose/router/children/ChildController;Ljava/lang/Object;)Z", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChildControllerExtKt {
    public static final <C> boolean isActive(ChildController<C, ?, ?> childController, C configuration) {
        Intrinsics.checkNotNullParameter(childController, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Lifecycle.State lifecycleState = childController.getLifecycleState(configuration);
        if (lifecycleState == null || lifecycleState.compareTo(Lifecycle.State.DESTROYED) <= 0) {
            lifecycleState = null;
        }
        return lifecycleState != null;
    }
}
