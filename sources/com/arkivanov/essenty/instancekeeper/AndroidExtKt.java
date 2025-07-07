package com.arkivanov.essenty.instancekeeper;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidExt.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\b"}, d2 = {"InstanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "discardRetainedInstances", "", "instanceKeeper", "Landroidx/lifecycle/ViewModelStoreOwner;", "instance-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidExtKt {
    public static /* synthetic */ InstanceKeeper InstanceKeeper$default(ViewModelStore viewModelStore, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return InstanceKeeper(viewModelStore, z);
    }

    public static final InstanceKeeper InstanceKeeper(ViewModelStore viewModelStore, boolean z) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        InstanceKeeperViewModel instanceKeeperViewModel = (InstanceKeeperViewModel) new ViewModelProvider(viewModelStore, new ViewModelProvider.Factory() { // from class: com.arkivanov.essenty.instancekeeper.AndroidExtKt$InstanceKeeper$1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(Class<T> modelClass) {
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                return new InstanceKeeperViewModel();
            }
        }, null, 4, null).get(InstanceKeeperViewModel.class);
        if (z) {
            instanceKeeperViewModel.recreate();
        }
        return instanceKeeperViewModel.getInstanceKeeperDispatcher();
    }

    public static /* synthetic */ InstanceKeeper instanceKeeper$default(ViewModelStoreOwner viewModelStoreOwner, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return instanceKeeper(viewModelStoreOwner, z);
    }

    public static final InstanceKeeper instanceKeeper(ViewModelStoreOwner viewModelStoreOwner, boolean z) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "<this>");
        return InstanceKeeper(viewModelStoreOwner.getViewModelStore(), z);
    }
}
