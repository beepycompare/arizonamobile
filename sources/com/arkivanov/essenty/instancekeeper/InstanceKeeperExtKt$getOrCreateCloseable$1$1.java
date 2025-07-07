package com.arkivanov.essenty.instancekeeper;

import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import kotlin.Metadata;
/* JADX WARN: Incorrect field signature: TT; */
/* compiled from: InstanceKeeperExt.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0013\u0010\u0002\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"com/arkivanov/essenty/instancekeeper/InstanceKeeperExtKt$getOrCreateCloseable$1$1", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "instance", "getInstance", "()Ljava/lang/AutoCloseable;", "Ljava/lang/AutoCloseable;", "onDestroy", "", "instance-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class InstanceKeeperExtKt$getOrCreateCloseable$1$1 implements InstanceKeeper.Instance {
    final /* synthetic */ AutoCloseable $instance;
    private final AutoCloseable instance;

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public InstanceKeeperExtKt$getOrCreateCloseable$1$1(AutoCloseable autoCloseable) {
        this.$instance = autoCloseable;
        this.instance = autoCloseable;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    public final AutoCloseable getInstance() {
        return this.instance;
    }

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper.Instance
    public void onDestroy() {
        this.$instance.close();
    }
}
