package com.arkivanov.decompose.router.children;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arkivanov.decompose.GenericComponentContext;
import com.arkivanov.decompose.backhandler.ChildBackHandler;
import com.arkivanov.decompose.backhandler.ChildBackHandlerKt;
import com.arkivanov.decompose.lifecycle.MergedLifecycle;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcherKt;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.lifecycle.LifecycleRegistry;
import com.arkivanov.essenty.lifecycle.LifecycleRegistryExtKt;
import com.arkivanov.essenty.lifecycle.LifecycleRegistryKt;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcherKt;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
/* compiled from: ChildController.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u0002*\u0010\b\u0002\u0010\u0004 \u0001*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u00020\u0002:\u0003<=>B1\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aJ\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u0013H\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00028\u00002\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010(J\u001f\u0010)\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010*J)\u0010+\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\b\b\u0002\u0010,\u001a\u00020-2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010.J)\u0010/\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\b\b\u0002\u0010,\u001a\u00020-2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010.J3\u00100\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u00101\u001a\u0002022\b\b\u0002\u0010,\u001a\u00020-2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u00103J3\u00104\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u00101\u001a\u0002022\b\b\u0002\u0010,\u001a\u00020-2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u00103J \u00105\u001a\u00020\u0016*\u0006\u0012\u0002\b\u0003062\u0006\u00101\u001a\u0002022\u0006\u0010,\u001a\u00020-H\u0002J\u0014\u00105\u001a\u00020\u0016*\u0002072\u0006\u00101\u001a\u000202H\u0002J\u001c\u00105\u001a\u00020\u0016*\u0002082\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020-H\u0002J%\u0010:\u001a\b\u0012\u0004\u0012\u00028\u0001062\u0006\u0010\u001d\u001a\u00028\u00002\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010;J\u0010\u0010&\u001a\u00020\u0016*\u0006\u0012\u0002\b\u000306H\u0002R\u0010\u0010\u0006\u001a\u00028\u0002X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00130\u0012j\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildController;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Ctx", "Lcom/arkivanov/decompose/GenericComponentContext;", "componentContext", "key", "childFactory", "Lkotlin/Function2;", "<init>", "(Lcom/arkivanov/decompose/GenericComponentContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lcom/arkivanov/decompose/GenericComponentContext;", "retainedInstance", "Lcom/arkivanov/decompose/router/children/ChildController$RetainedInstance;", "childBackHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "items", "Ljava/util/HashMap;", "Lcom/arkivanov/decompose/router/children/ChildController$Item;", "Lkotlin/collections/HashMap;", "init", "", "dropState", "", "block", "Lkotlin/Function0;", "saveState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "configuration", "(Ljava/lang/Object;)Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getLifecycleState", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "(Ljava/lang/Object;)Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "remove", "(Ljava/lang/Object;)V", "destroy", "savedState", "(Ljava/lang/Object;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)V", "create", "(Ljava/lang/Object;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)Ljava/lang/Object;", TtmlNode.START, "backHandlerPriority", "", "(Ljava/lang/Object;ILcom/arkivanov/essenty/statekeeper/SerializableContainer;)Ljava/lang/Object;", "resume", RemoteConfigComponent.ACTIVATE_FILE_NAME, "lifecycleState", "Lcom/arkivanov/decompose/router/children/ChildController$ActiveLifecycleState;", "(Ljava/lang/Object;Lcom/arkivanov/decompose/router/children/ChildController$ActiveLifecycleState;ILcom/arkivanov/essenty/statekeeper/SerializableContainer;)Ljava/lang/Object;", "activateNew", "setState", "Lcom/arkivanov/decompose/router/children/ChildController$Item$Created;", "Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "Lcom/arkivanov/decompose/backhandler/ChildBackHandler;", "priority", "item", "(Ljava/lang/Object;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)Lcom/arkivanov/decompose/router/children/ChildController$Item$Created;", "ActiveLifecycleState", "Item", "RetainedInstance", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChildController<C, T, Ctx extends GenericComponentContext<? extends Ctx>> {
    private final BackHandler childBackHandler;
    private final Function2<C, Ctx, T> childFactory;
    private final Ctx componentContext;
    private final HashMap<C, Item<T>> items;
    private final RetainedInstance<C> retainedInstance;

    /* compiled from: ChildController.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ActiveLifecycleState.values().length];
            try {
                iArr[ActiveLifecycleState.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActiveLifecycleState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActiveLifecycleState.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChildController(Ctx componentContext, Object key, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        this.componentContext = componentContext;
        this.childFactory = childFactory;
        InstanceKeeper instanceKeeper = componentContext.getInstanceKeeper();
        RetainedInstance retainedInstance = instanceKeeper.get(key);
        if (retainedInstance == null) {
            retainedInstance = new RetainedInstance();
            instanceKeeper.put(key, retainedInstance);
        }
        this.retainedInstance = (RetainedInstance) retainedInstance;
        this.childBackHandler = ChildBackHandlerKt.child$default(componentContext.getBackHandler(), null, 1, 1, null);
        this.items = new HashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(ChildController childController, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.router.children.ChildController$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        childController.init(z, function0);
    }

    public final void init(boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (z) {
            this.retainedInstance.onDestroy();
        }
        block.invoke();
        Iterator<Map.Entry<C, InstanceKeeperDispatcher>> it = this.retainedInstance.getMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<C, InstanceKeeperDispatcher> next = it.next();
            C key = next.getKey();
            InstanceKeeperDispatcher value = next.getValue();
            Item<T> item = this.items.get(key);
            if ((item != null ? item.getInstance() : null) == null) {
                value.destroy();
                it.remove();
            }
        }
    }

    public final SerializableContainer saveState(C configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Item<T> item = this.items.get(configuration);
        if (item != null) {
            return saveState((Item<?>) item);
        }
        return null;
    }

    private final SerializableContainer saveState(Item<?> item) {
        if (item instanceof Item.Created) {
            return ((Item.Created) item).getStateKeeperDispatcher().save();
        }
        if (item instanceof Item.Destroyed) {
            return ((Item.Destroyed) item).getSavedState();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final T get(C configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Item<T> item = this.items.get(configuration);
        if (item != null) {
            return item.getInstance();
        }
        return null;
    }

    public final Lifecycle.State getLifecycleState(C configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Item<T> item = this.items.get(configuration);
        if (item instanceof Item.Created) {
            return ((Item.Created) item).getLifecycleRegistry().getState();
        }
        if (item instanceof Item.Destroyed) {
            return Lifecycle.State.DESTROYED;
        }
        if (item == null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void remove(C configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Item<T> remove = this.items.remove(configuration);
        Item.Created<?> created = remove instanceof Item.Created ? (Item.Created) remove : null;
        if (created == null) {
            return;
        }
        destroy(created);
        this.retainedInstance.getMap().remove(configuration);
    }

    public static /* synthetic */ void destroy$default(ChildController childController, Object obj, SerializableContainer serializableContainer, int i, Object obj2) {
        if ((i & 2) != 0) {
            serializableContainer = null;
        }
        childController.destroy(obj, serializableContainer);
    }

    public final void destroy(C configuration, SerializableContainer serializableContainer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Item<T> remove = this.items.remove(configuration);
        Item.Created<?> created = remove instanceof Item.Created ? (Item.Created) remove : null;
        if (created == null) {
            this.items.put(configuration, new Item.Destroyed(serializableContainer));
            return;
        }
        if (serializableContainer == null) {
            serializableContainer = created.getStateKeeperDispatcher().save();
        }
        destroy(created);
        this.retainedInstance.getMap().remove(configuration);
        this.items.put(configuration, new Item.Destroyed(serializableContainer));
    }

    public static /* synthetic */ Object create$default(ChildController childController, Object obj, SerializableContainer serializableContainer, int i, Object obj2) {
        if ((i & 2) != 0) {
            serializableContainer = null;
        }
        return childController.create(obj, serializableContainer);
    }

    public final T create(C configuration, SerializableContainer serializableContainer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return (T) activate$default(this, configuration, ActiveLifecycleState.CREATED, 0, serializableContainer, 4, null);
    }

    public static /* synthetic */ Object start$default(ChildController childController, Object obj, int i, SerializableContainer serializableContainer, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            serializableContainer = null;
        }
        return childController.start(obj, i, serializableContainer);
    }

    public final T start(C configuration, int i, SerializableContainer serializableContainer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return activate(configuration, ActiveLifecycleState.STARTED, i, serializableContainer);
    }

    public static /* synthetic */ Object resume$default(ChildController childController, Object obj, int i, SerializableContainer serializableContainer, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            serializableContainer = null;
        }
        return childController.resume(obj, i, serializableContainer);
    }

    public final T resume(C configuration, int i, SerializableContainer serializableContainer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return activate(configuration, ActiveLifecycleState.RESUMED, i, serializableContainer);
    }

    static /* synthetic */ Object activate$default(ChildController childController, Object obj, ActiveLifecycleState activeLifecycleState, int i, SerializableContainer serializableContainer, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            serializableContainer = null;
        }
        return childController.activate(obj, activeLifecycleState, i, serializableContainer);
    }

    private final T activate(C c, ActiveLifecycleState activeLifecycleState, int i, SerializableContainer serializableContainer) {
        Item<T> item = this.items.get(c);
        if (item instanceof Item.Created) {
            Item.Created<?> created = (Item.Created) item;
            setState(created, activeLifecycleState, i);
            return (T) created.getInstance();
        } else if (item instanceof Item.Destroyed) {
            if (serializableContainer == null) {
                serializableContainer = ((Item.Destroyed) item).getSavedState();
            }
            return activateNew(c, activeLifecycleState, i, serializableContainer);
        } else if (item != null) {
            throw new NoWhenBranchMatchedException();
        } else {
            return activateNew(c, activeLifecycleState, i, serializableContainer);
        }
    }

    static /* synthetic */ Object activateNew$default(ChildController childController, Object obj, ActiveLifecycleState activeLifecycleState, int i, SerializableContainer serializableContainer, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            serializableContainer = null;
        }
        return childController.activateNew(obj, activeLifecycleState, i, serializableContainer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final T activateNew(C c, ActiveLifecycleState activeLifecycleState, int i, SerializableContainer serializableContainer) {
        Item.Created item = item(c, serializableContainer);
        setState(item, activeLifecycleState, i);
        this.retainedInstance.getMap().put(c, item.getInstanceKeeperDispatcher());
        this.items.put(c, item);
        return (T) item.getInstance();
    }

    private final void setState(Item.Created<?> created, ActiveLifecycleState activeLifecycleState, int i) {
        setState(created.getLifecycleRegistry(), activeLifecycleState);
        setState(created.getBackHandler(), activeLifecycleState, i);
    }

    private final void setState(LifecycleRegistry lifecycleRegistry, ActiveLifecycleState activeLifecycleState) {
        int i = WhenMappings.$EnumSwitchMapping$0[activeLifecycleState.ordinal()];
        if (i == 1) {
            if (lifecycleRegistry.getState().compareTo(Lifecycle.State.CREATED) < 0) {
                LifecycleRegistryExtKt.create(lifecycleRegistry);
            } else {
                LifecycleRegistryExtKt.stop(lifecycleRegistry);
            }
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            LifecycleRegistryExtKt.resume(lifecycleRegistry);
        } else if (lifecycleRegistry.getState().compareTo(Lifecycle.State.STARTED) < 0) {
            LifecycleRegistryExtKt.start(lifecycleRegistry);
        } else {
            LifecycleRegistryExtKt.pause(lifecycleRegistry);
        }
    }

    private final void setState(ChildBackHandler childBackHandler, ActiveLifecycleState activeLifecycleState, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[activeLifecycleState.ordinal()];
        if (i2 == 1) {
            childBackHandler.stop();
        } else if (i2 != 2 && i2 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            childBackHandler.start();
        }
        childBackHandler.setPriority(i);
    }

    private final Item.Created<T> item(C c, SerializableContainer serializableContainer) {
        LifecycleRegistry LifecycleRegistry = LifecycleRegistryKt.LifecycleRegistry();
        MergedLifecycle mergedLifecycle = new MergedLifecycle(this.componentContext.getLifecycle(), LifecycleRegistry);
        StateKeeperDispatcher StateKeeperDispatcher = StateKeeperDispatcherKt.StateKeeperDispatcher(serializableContainer);
        InstanceKeeperDispatcher instanceKeeperDispatcher = this.retainedInstance.getMap().get(c);
        if (instanceKeeperDispatcher == null) {
            instanceKeeperDispatcher = InstanceKeeperDispatcherKt.InstanceKeeperDispatcher();
        }
        InstanceKeeperDispatcher instanceKeeperDispatcher2 = instanceKeeperDispatcher;
        ChildBackHandler childBackHandler$default = ChildBackHandlerKt.childBackHandler$default(this.childBackHandler, false, 0, 3, null);
        return new Item.Created<>(this.childFactory.invoke(c, this.componentContext.getComponentContextFactory().invoke(mergedLifecycle, StateKeeperDispatcher, instanceKeeperDispatcher2, childBackHandler$default)), LifecycleRegistry, StateKeeperDispatcher, instanceKeeperDispatcher2, childBackHandler$default);
    }

    private final void destroy(Item.Created<?> created) {
        created.getBackHandler().stop();
        LifecycleRegistryExtKt.destroy(created.getLifecycleRegistry());
        created.getInstanceKeeperDispatcher().destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ChildController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildController$ActiveLifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", DebugCoroutineInfoImplKt.CREATED, "STARTED", "RESUMED", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ActiveLifecycleState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ActiveLifecycleState[] $VALUES;
        public static final ActiveLifecycleState CREATED = new ActiveLifecycleState(DebugCoroutineInfoImplKt.CREATED, 0);
        public static final ActiveLifecycleState STARTED = new ActiveLifecycleState("STARTED", 1);
        public static final ActiveLifecycleState RESUMED = new ActiveLifecycleState("RESUMED", 2);

        private static final /* synthetic */ ActiveLifecycleState[] $values() {
            return new ActiveLifecycleState[]{CREATED, STARTED, RESUMED};
        }

        public static EnumEntries<ActiveLifecycleState> getEntries() {
            return $ENTRIES;
        }

        private ActiveLifecycleState(String str, int i) {
        }

        static {
            ActiveLifecycleState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ActiveLifecycleState valueOf(String str) {
            return (ActiveLifecycleState) Enum.valueOf(ActiveLifecycleState.class, str);
        }

        public static ActiveLifecycleState[] values() {
            return (ActiveLifecycleState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChildController.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000*\n\b\u0003\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0002\u0006\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00018\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildController$Item;", ExifInterface.GPS_DIRECTION_TRUE, "", "instance", "getInstance", "()Ljava/lang/Object;", "Destroyed", "Created", "Lcom/arkivanov/decompose/router/children/ChildController$Item$Created;", "Lcom/arkivanov/decompose/router/children/ChildController$Item$Destroyed;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Item<T> {
        T getInstance();

        /* compiled from: ChildController.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildController$Item$Destroyed;", "Lcom/arkivanov/decompose/router/children/ChildController$Item;", "", "savedState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "<init>", "(Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)V", "getSavedState", "()Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "instance", "getInstance", "()Ljava/lang/Void;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Destroyed implements Item {
            private final Void instance;
            private final SerializableContainer savedState;

            public Destroyed() {
                this(null, 1, null);
            }

            public Destroyed(SerializableContainer serializableContainer) {
                this.savedState = serializableContainer;
            }

            public /* synthetic */ Destroyed(SerializableContainer serializableContainer, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : serializableContainer);
            }

            public final SerializableContainer getSavedState() {
                return this.savedState;
            }

            @Override // com.arkivanov.decompose.router.children.ChildController.Item
            public Void getInstance() {
                return this.instance;
            }
        }

        /* compiled from: ChildController.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000*\n\b\u0004\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B/\u0012\u0006\u0010\u0004\u001a\u00028\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00028\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildController$Item$Created;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/router/children/ChildController$Item;", "instance", "lifecycleRegistry", "Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "stateKeeperDispatcher", "Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;", "instanceKeeperDispatcher", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "backHandler", "Lcom/arkivanov/decompose/backhandler/ChildBackHandler;", "<init>", "(Ljava/lang/Object;Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;Lcom/arkivanov/decompose/backhandler/ChildBackHandler;)V", "getInstance", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLifecycleRegistry", "()Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "getStateKeeperDispatcher", "()Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;", "getInstanceKeeperDispatcher", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "getBackHandler", "()Lcom/arkivanov/decompose/backhandler/ChildBackHandler;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Created<T> implements Item<T> {
            private final ChildBackHandler backHandler;
            private final T instance;
            private final InstanceKeeperDispatcher instanceKeeperDispatcher;
            private final LifecycleRegistry lifecycleRegistry;
            private final StateKeeperDispatcher stateKeeperDispatcher;

            public Created(T instance, LifecycleRegistry lifecycleRegistry, StateKeeperDispatcher stateKeeperDispatcher, InstanceKeeperDispatcher instanceKeeperDispatcher, ChildBackHandler backHandler) {
                Intrinsics.checkNotNullParameter(instance, "instance");
                Intrinsics.checkNotNullParameter(lifecycleRegistry, "lifecycleRegistry");
                Intrinsics.checkNotNullParameter(stateKeeperDispatcher, "stateKeeperDispatcher");
                Intrinsics.checkNotNullParameter(instanceKeeperDispatcher, "instanceKeeperDispatcher");
                Intrinsics.checkNotNullParameter(backHandler, "backHandler");
                this.instance = instance;
                this.lifecycleRegistry = lifecycleRegistry;
                this.stateKeeperDispatcher = stateKeeperDispatcher;
                this.instanceKeeperDispatcher = instanceKeeperDispatcher;
                this.backHandler = backHandler;
            }

            @Override // com.arkivanov.decompose.router.children.ChildController.Item
            public T getInstance() {
                return this.instance;
            }

            public final LifecycleRegistry getLifecycleRegistry() {
                return this.lifecycleRegistry;
            }

            public final StateKeeperDispatcher getStateKeeperDispatcher() {
                return this.stateKeeperDispatcher;
            }

            public final InstanceKeeperDispatcher getInstanceKeeperDispatcher() {
                return this.instanceKeeperDispatcher;
            }

            public final ChildBackHandler getBackHandler() {
                return this.backHandler;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChildController.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildController$RetainedInstance;", "C", "", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "<init>", "()V", "map", "", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "getMap", "()Ljava/util/Map;", "onDestroy", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class RetainedInstance<C> implements InstanceKeeper.Instance {
        private final Map<C, InstanceKeeperDispatcher> map = new HashMap();

        public final Map<C, InstanceKeeperDispatcher> getMap() {
            return this.map;
        }

        @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper.Instance
        public void onDestroy() {
            for (InstanceKeeperDispatcher instanceKeeperDispatcher : this.map.values()) {
                instanceKeeperDispatcher.destroy();
            }
            this.map.clear();
        }
    }
}
