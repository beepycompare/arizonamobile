package com.miami.game.core.decompose.utils;

import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
/* compiled from: CoroutineScope.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/arkivanov/essenty/lifecycle/LifecycleOwner;", "context", "Lkotlin/coroutines/CoroutineContext;", "decompose-utils_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoroutineScopeKt {
    public static /* synthetic */ CoroutineScope coroutineScope$default(LifecycleOwner lifecycleOwner, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain().getImmediate();
        }
        return coroutineScope(lifecycleOwner, coroutineContext);
    }

    public static final CoroutineScope coroutineScope(LifecycleOwner lifecycleOwner, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        final CoroutineScope CoroutineScope = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(context);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            kotlinx.coroutines.CoroutineScopeKt.cancel$default(CoroutineScope, null, 1, null);
            return CoroutineScope;
        }
        lifecycle.subscribe(new Lifecycle.Callbacks() { // from class: com.miami.game.core.decompose.utils.CoroutineScopeKt$coroutineScope$lambda$0$$inlined$doOnDestroy$1
            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onCreate() {
                Lifecycle.Callbacks.DefaultImpls.onCreate(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onPause() {
                Lifecycle.Callbacks.DefaultImpls.onPause(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onResume() {
                Lifecycle.Callbacks.DefaultImpls.onResume(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onStart() {
                Lifecycle.Callbacks.DefaultImpls.onStart(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onStop() {
                Lifecycle.Callbacks.DefaultImpls.onStop(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onDestroy() {
                kotlinx.coroutines.CoroutineScopeKt.cancel$default(CoroutineScope.this, null, 1, null);
            }
        });
        return CoroutineScope;
    }
}
