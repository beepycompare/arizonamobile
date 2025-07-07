package com.arkivanov.decompose.statekeeper;

import com.arkivanov.decompose.UtilsKt;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcherKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildStateKeeper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, d2 = {"child", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "key", "", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildStateKeeperKt {
    public static /* synthetic */ StateKeeper child$default(StateKeeper stateKeeper, String str, Lifecycle lifecycle, int i, Object obj) {
        if ((i & 2) != 0) {
            lifecycle = null;
        }
        return child(stateKeeper, str, lifecycle);
    }

    public static final StateKeeper child(final StateKeeper stateKeeper, final String key, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(stateKeeper, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (stateKeeper.isRegistered(key)) {
            throw new IllegalStateException(("The key \"" + key + "\" is already in use.").toString());
        }
        StateKeeperDispatcher StateKeeperDispatcher = StateKeeperDispatcherKt.StateKeeperDispatcher((SerializableContainer) stateKeeper.consume(key, SerializableContainer.Companion.serializer()));
        if (lifecycle == null) {
            stateKeeper.register(key, SerializableContainer.Companion.serializer(), new ChildStateKeeperKt$child$2(StateKeeperDispatcher));
        } else if (!UtilsKt.isDestroyed(lifecycle)) {
            stateKeeper.register(key, SerializableContainer.Companion.serializer(), new ChildStateKeeperKt$child$3(StateKeeperDispatcher));
            if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
                stateKeeper.unregister(key);
            } else {
                lifecycle.subscribe(new Lifecycle.Callbacks() { // from class: com.arkivanov.decompose.statekeeper.ChildStateKeeperKt$child$$inlined$doOnDestroy$1
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
                        StateKeeper.this.unregister(key);
                    }
                });
            }
        }
        return StateKeeperDispatcher;
    }
}
