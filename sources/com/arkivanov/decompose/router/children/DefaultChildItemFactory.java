package com.arkivanov.decompose.router.children;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.ComponentContextFactory;
import com.arkivanov.decompose.backhandler.ChildBackHandler;
import com.arkivanov.decompose.backhandler.ChildBackHandlerKt;
import com.arkivanov.decompose.lifecycle.MergedLifecycle;
import com.arkivanov.decompose.router.children.ChildItem;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcherKt;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.lifecycle.LifecycleRegistry;
import com.arkivanov.essenty.lifecycle.LifecycleRegistryKt;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcherKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultChildItemFactory.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\n\b\u0002\u0010\u0004 \u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0005BN\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012'\u0010\f\u001a#\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J6\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00142\u0006\u0010\u0010\u001a\u00028\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\f\u001a#\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/arkivanov/decompose/router/children/DefaultChildItemFactory;", "Ctx", "", "C", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/router/children/ChildItemFactory;", "contextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "childFactory", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "configuration", "<init>", "(Lcom/arkivanov/decompose/ComponentContextFactory;Lcom/arkivanov/essenty/lifecycle/Lifecycle;Lcom/arkivanov/essenty/backhandler/BackHandler;Lkotlin/jvm/functions/Function2;)V", "invoke", "Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "savedState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "instanceKeeperDispatcher", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "(Ljava/lang/Object;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;)Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultChildItemFactory<Ctx, C, T> implements ChildItemFactory<C, T> {
    private final BackHandler backHandler;
    private final Function2<C, Ctx, T> childFactory;
    private final ComponentContextFactory<Ctx> contextFactory;
    private final Lifecycle lifecycle;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultChildItemFactory(ComponentContextFactory<? extends Ctx> contextFactory, Lifecycle lifecycle, BackHandler backHandler, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(contextFactory, "contextFactory");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        this.contextFactory = contextFactory;
        this.lifecycle = lifecycle;
        this.backHandler = backHandler;
        this.childFactory = childFactory;
    }

    @Override // com.arkivanov.decompose.router.children.ChildItemFactory
    public ChildItem.Created<C, T> invoke(C configuration, SerializableContainer serializableContainer, InstanceKeeperDispatcher instanceKeeperDispatcher) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        LifecycleRegistry LifecycleRegistry = LifecycleRegistryKt.LifecycleRegistry();
        MergedLifecycle mergedLifecycle = new MergedLifecycle(this.lifecycle, LifecycleRegistry);
        StateKeeperDispatcher StateKeeperDispatcher = StateKeeperDispatcherKt.StateKeeperDispatcher(serializableContainer);
        if (instanceKeeperDispatcher == null) {
            instanceKeeperDispatcher = InstanceKeeperDispatcherKt.InstanceKeeperDispatcher();
        }
        InstanceKeeperDispatcher instanceKeeperDispatcher2 = instanceKeeperDispatcher;
        ChildBackHandler childBackHandler$default = ChildBackHandlerKt.childBackHandler$default(this.backHandler, false, 0, 3, null);
        return new ChildItem.Created<>(configuration, this.childFactory.invoke(configuration, this.contextFactory.invoke(mergedLifecycle, StateKeeperDispatcher, instanceKeeperDispatcher2, childBackHandler$default)), LifecycleRegistry, StateKeeperDispatcher, instanceKeeperDispatcher2, childBackHandler$default);
    }
}
