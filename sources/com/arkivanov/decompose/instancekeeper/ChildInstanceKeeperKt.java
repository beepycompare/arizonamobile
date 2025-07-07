package com.arkivanov.decompose.instancekeeper;

import com.arkivanov.decompose.UtilsKt;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcherKt;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildInstanceKeeper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, d2 = {"child", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "key", "", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildInstanceKeeperKt {
    public static /* synthetic */ InstanceKeeper child$default(InstanceKeeper instanceKeeper, String str, Lifecycle lifecycle, int i, Object obj) {
        if ((i & 2) != 0) {
            lifecycle = null;
        }
        return child(instanceKeeper, str, lifecycle);
    }

    public static final InstanceKeeper child(final InstanceKeeper instanceKeeper, final String key, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(instanceKeeper, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (lifecycle != null && UtilsKt.isDestroyed(lifecycle)) {
            return InstanceKeeperDispatcherKt.InstanceKeeperDispatcher();
        }
        ChildInstanceKeeperProvider childInstanceKeeperProvider = instanceKeeper.get(key);
        if (childInstanceKeeperProvider == null) {
            childInstanceKeeperProvider = new ChildInstanceKeeperProvider();
            instanceKeeper.put(key, childInstanceKeeperProvider);
        }
        InstanceKeeperDispatcher instanceKeeperRegistry = ((ChildInstanceKeeperProvider) childInstanceKeeperProvider).getInstanceKeeperRegistry();
        if (lifecycle != null) {
            if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
                InstanceKeeper.Instance remove = instanceKeeper.remove(key);
                if (remove != null) {
                    remove.onDestroy();
                }
            } else {
                lifecycle.subscribe(new Lifecycle.Callbacks() { // from class: com.arkivanov.decompose.instancekeeper.ChildInstanceKeeperKt$child$$inlined$doOnDestroy$1
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
                        InstanceKeeper.Instance remove2 = InstanceKeeper.this.remove(key);
                        if (remove2 != null) {
                            remove2.onDestroy();
                        }
                    }
                });
            }
        }
        return instanceKeeperRegistry;
    }
}
