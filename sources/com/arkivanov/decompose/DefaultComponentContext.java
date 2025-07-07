package com.arkivanov.decompose;

import com.arkivanov.decompose.instancekeeper.InstanceKeeperExtKt;
import com.arkivanov.essenty.backhandler.BackDispatcher;
import com.arkivanov.essenty.backhandler.BackDispatcherKt;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcherKt;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcherKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultComponentContext.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/decompose/DefaultComponentContext;", "Lcom/arkivanov/decompose/ComponentContext;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "<init>", "(Lcom/arkivanov/essenty/lifecycle/Lifecycle;Lcom/arkivanov/essenty/statekeeper/StateKeeper;Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;Lcom/arkivanov/essenty/backhandler/BackHandler;)V", "(Lcom/arkivanov/essenty/lifecycle/Lifecycle;)V", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultComponentContext implements ComponentContext {
    private final BackHandler backHandler;
    private final ComponentContextFactory<ComponentContext> componentContextFactory;
    private final InstanceKeeper instanceKeeper;
    private final Lifecycle lifecycle;
    private final StateKeeper stateKeeper;

    public DefaultComponentContext(Lifecycle lifecycle, StateKeeperDispatcher stateKeeperDispatcher, InstanceKeeperDispatcher instanceKeeperDispatcher, BackDispatcher backDispatcher) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.lifecycle = lifecycle;
        this.stateKeeper = stateKeeperDispatcher == null ? StateKeeperDispatcherKt.StateKeeperDispatcher$default(null, 1, null) : stateKeeperDispatcher;
        this.instanceKeeper = instanceKeeperDispatcher == null ? InstanceKeeperExtKt.attachTo(InstanceKeeperDispatcherKt.InstanceKeeperDispatcher(), getLifecycle()) : instanceKeeperDispatcher;
        this.backHandler = backDispatcher == null ? BackDispatcherKt.BackDispatcher() : backDispatcher;
        this.componentContextFactory = DefaultComponentContext$componentContextFactory$1.INSTANCE;
    }

    public /* synthetic */ DefaultComponentContext(Lifecycle lifecycle, StateKeeper stateKeeper, InstanceKeeper instanceKeeper, BackHandler backHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycle, (i & 2) != 0 ? null : stateKeeper, (i & 4) != 0 ? null : instanceKeeper, (i & 8) != 0 ? null : backHandler);
    }

    @Override // com.arkivanov.essenty.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // com.arkivanov.essenty.statekeeper.StateKeeperOwner
    public StateKeeper getStateKeeper() {
        return this.stateKeeper;
    }

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeperOwner
    public InstanceKeeper getInstanceKeeper() {
        return this.instanceKeeper;
    }

    @Override // com.arkivanov.essenty.backhandler.BackHandlerOwner
    public BackHandler getBackHandler() {
        return this.backHandler;
    }

    @Override // com.arkivanov.decompose.ComponentContextFactoryOwner
    public ComponentContextFactory<ComponentContext> getComponentContextFactory() {
        return this.componentContextFactory;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultComponentContext(Lifecycle lifecycle) {
        this(lifecycle, null, null, null);
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
    }
}
