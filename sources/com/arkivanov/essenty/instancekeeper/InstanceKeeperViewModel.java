package com.arkivanov.essenty.instancekeeper;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
/* compiled from: AndroidExt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0014J\u0006\u0010\u000b\u001a\u00020\nR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "value", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "instanceKeeperDispatcher", "getInstanceKeeperDispatcher", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "onCleared", "", "recreate", "instance-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstanceKeeperViewModel extends ViewModel {
    private InstanceKeeperDispatcher instanceKeeperDispatcher = InstanceKeeperDispatcherKt.InstanceKeeperDispatcher();

    public final InstanceKeeperDispatcher getInstanceKeeperDispatcher() {
        return this.instanceKeeperDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.instanceKeeperDispatcher.destroy();
    }

    public final void recreate() {
        this.instanceKeeperDispatcher.destroy();
        this.instanceKeeperDispatcher = InstanceKeeperDispatcherKt.InstanceKeeperDispatcher();
    }
}
