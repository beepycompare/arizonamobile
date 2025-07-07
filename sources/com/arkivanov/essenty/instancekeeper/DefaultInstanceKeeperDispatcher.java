package com.arkivanov.essenty.instancekeeper;

import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultInstanceKeeperDispatcher.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/arkivanov/essenty/instancekeeper/DefaultInstanceKeeperDispatcher;", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "<init>", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "Lkotlin/collections/HashMap;", "isDestroyed", "", "get", "key", "put", "", "instance", "remove", "destroy", "instance-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultInstanceKeeperDispatcher implements InstanceKeeperDispatcher {
    private boolean isDestroyed;
    private final HashMap<Object, InstanceKeeper.Instance> map = new HashMap<>();

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper
    public InstanceKeeper.Instance get(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.map.get(key);
    }

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper
    public void put(Object key, InstanceKeeper.Instance instance) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (this.map.containsKey(key)) {
            throw new IllegalStateException(("Another instance is already associated with the key: " + key).toString());
        }
        this.map.put(key, instance);
        if (this.isDestroyed) {
            instance.onDestroy();
        }
    }

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper
    public InstanceKeeper.Instance remove(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.map.remove(key);
    }

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher
    public void destroy() {
        if (this.isDestroyed) {
            return;
        }
        this.isDestroyed = true;
        Collection<InstanceKeeper.Instance> values = this.map.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (InstanceKeeper.Instance instance : CollectionsKt.toList(values)) {
            instance.onDestroy();
        }
    }
}
