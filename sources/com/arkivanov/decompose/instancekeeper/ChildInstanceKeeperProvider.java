package com.arkivanov.decompose.instancekeeper;

import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcherKt;
import kotlin.Metadata;
/* compiled from: ChildInstanceKeeper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/arkivanov/decompose/instancekeeper/ChildInstanceKeeperProvider;", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "<init>", "()V", "instanceKeeperRegistry", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "getInstanceKeeperRegistry", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "onDestroy", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ChildInstanceKeeperProvider implements InstanceKeeper.Instance {
    private final InstanceKeeperDispatcher instanceKeeperRegistry = InstanceKeeperDispatcherKt.InstanceKeeperDispatcher();

    public final InstanceKeeperDispatcher getInstanceKeeperRegistry() {
        return this.instanceKeeperRegistry;
    }

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper.Instance
    public void onDestroy() {
        this.instanceKeeperRegistry.destroy();
    }
}
