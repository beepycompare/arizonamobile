package com.arkivanov.decompose.instancekeeper;

import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InstanceKeeperExt.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"attachTo", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstanceKeeperExtKt {
    public static final InstanceKeeperDispatcher attachTo(final InstanceKeeperDispatcher instanceKeeperDispatcher, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(instanceKeeperDispatcher, "<this>");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            instanceKeeperDispatcher.destroy();
            return instanceKeeperDispatcher;
        }
        lifecycle.subscribe(new Lifecycle.Callbacks() { // from class: com.arkivanov.decompose.instancekeeper.InstanceKeeperExtKt$attachTo$$inlined$doOnDestroy$1
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
                InstanceKeeperDispatcher.this.destroy();
            }
        });
        return instanceKeeperDispatcher;
    }
}
