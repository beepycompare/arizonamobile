package com.arkivanov.essenty.lifecycle;

import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LifecycleRegistry.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"LifecycleRegistry", "Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "initialState", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "lifecycle_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LifecycleRegistryKt {
    public static final LifecycleRegistry LifecycleRegistry() {
        return LifecycleRegistry(Lifecycle.State.INITIALIZED);
    }

    public static final LifecycleRegistry LifecycleRegistry(Lifecycle.State initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        return new LifecycleRegistryImpl(initialState);
    }
}
