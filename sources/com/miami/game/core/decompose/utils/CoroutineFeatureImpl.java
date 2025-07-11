package com.miami.game.core.decompose.utils;

import com.arkivanov.essenty.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
/* compiled from: CoroutineFeatureImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/miami/game/core/decompose/utils/CoroutineFeatureImpl;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "lifecycleOwner", "Lcom/arkivanov/essenty/lifecycle/LifecycleOwner;", "<init>", "(Lcom/arkivanov/essenty/lifecycle/LifecycleOwner;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "decompose-utils_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoroutineFeatureImpl implements CoroutineFeature {
    private final CoroutineScope scope;

    public CoroutineFeatureImpl(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.scope = CoroutineScopeKt.coroutineScope(lifecycleOwner, Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    @Override // com.miami.game.core.decompose.utils.CoroutineFeature
    public CoroutineScope getScope() {
        return this.scope;
    }
}
