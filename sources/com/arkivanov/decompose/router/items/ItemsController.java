package com.arkivanov.decompose.router.items;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.Relay;
import com.arkivanov.decompose.UtilsKt;
import com.arkivanov.decompose.router.children.ChildController;
import com.arkivanov.decompose.router.children.NavStateSaver;
import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.items.Items;
import com.arkivanov.decompose.router.items.ItemsNavigation;
import com.arkivanov.decompose.value.MutableValue;
import com.arkivanov.decompose.value.MutableValueBuilderKt;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: ItemsController.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u00029:B\u001f\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJT\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00182\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0014\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0018\u00010!JN\u0010\"\u001a\u00020#2\u001e\u0010$\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0%2$\u0010&\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020#0'H\u0016J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)H\u0002J\u0016\u0010,\u001a\u00020#2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002J\u0016\u0010.\u001a\u00020#2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0002J6\u00100\u001a\u00020#2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u001e\u00101\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u000203020)H\u0002J\u0016\u0010,\u001a\u00020#2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0002J)\u00104\u001a\u00028\u00012\u0006\u00105\u001a\u00028\u00002\u0006\u00106\u001a\u0002032\n\b\u0002\u00107\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u00108R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006;"}, d2 = {"Lcom/arkivanov/decompose/router/items/ItemsController;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/router/items/ItemsNavigator;", "controller", "Lcom/arkivanov/decompose/router/children/ChildController;", "<init>", "(Lcom/arkivanov/decompose/router/children/ChildController;)V", "nav", "Lcom/arkivanov/decompose/Relay;", "Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent;", "navState", "Lcom/arkivanov/decompose/value/MutableValue;", "Lcom/arkivanov/decompose/router/items/Items;", "_state", "Lcom/arkivanov/decompose/router/items/ChildItems;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arkivanov/decompose/value/Value;", "getState", "()Lcom/arkivanov/decompose/value/Value;", "init", "Lcom/arkivanov/decompose/Cancellation;", "source", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "Lcom/arkivanov/decompose/router/items/ItemsNavigation$Event;", "initialState", "Lkotlin/Function0;", "key", "", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "stateSaver", "Lcom/arkivanov/decompose/router/children/NavStateSaver;", "navigate", "", "transformer", "Lkotlin/Function1;", "onComplete", "Lkotlin/Function2;", "saveChildState", "", "", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "onEvent", "event", "onInit", "Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent$Init;", "setState", "activeItems", "Lkotlin/Pair;", "Lcom/arkivanov/decompose/router/items/Items$ActiveLifecycleState;", "activateChild", "configuration", "lifecycleState", "savedState", "(Ljava/lang/Object;Lcom/arkivanov/decompose/router/items/Items$ActiveLifecycleState;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)Ljava/lang/Object;", "SavedState", "NavEvent", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ItemsController<C, T> implements ItemsNavigator<C> {
    private final MutableValue<ChildItems<C, T>> _state;
    private final ChildController<C, T, ?> controller;
    private final Relay<NavEvent<C>> nav;
    private final MutableValue<Items<C>> navState;
    private final Value<ChildItems<C, T>> state;

    /* compiled from: ItemsController.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Items.ActiveLifecycleState.values().length];
            try {
                iArr[Items.ActiveLifecycleState.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Items.ActiveLifecycleState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Items.ActiveLifecycleState.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemsController(ChildController<C, ? extends T, ?> controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.controller = controller;
        this.nav = new Relay<>();
        this.navState = MutableValueBuilderKt.MutableValue(new Items((List) null, (Map) null, 3, (DefaultConstructorMarker) null));
        MutableValue<ChildItems<C, T>> MutableValue = MutableValueBuilderKt.MutableValue(new ChildItems(null, null, 3, null));
        this._state = MutableValue;
        this.state = MutableValue;
    }

    public final Value<ChildItems<C, T>> getState() {
        return this.state;
    }

    public final Cancellation init(NavigationSource<ItemsNavigation.Event<C>> source, Function0<Items<C>> initialState, String key, StateKeeper stateKeeper, final NavStateSaver<Items<C>> navStateSaver) {
        Map<Integer, SerializableContainer> childState;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(stateKeeper, "stateKeeper");
        SavedState savedState = (SavedState) stateKeeper.consume(key, SavedState.Companion.serializer());
        Map<Integer, SerializableContainer> map = null;
        Items<C> restoreState = (savedState == null || navStateSaver == null) ? null : navStateSaver.restoreState(savedState.getNavState());
        if (navStateSaver != null) {
            stateKeeper.register(key, SavedState.Companion.serializer(), new Function0() { // from class: com.arkivanov.decompose.router.items.ItemsController$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ItemsController.init$lambda$2(NavStateSaver.this, this);
                }
            });
        }
        this.nav.subscribe(new ItemsController$init$2(this));
        Cancellation subscribe = source.subscribe(new Function1() { // from class: com.arkivanov.decompose.router.items.ItemsController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ItemsController.init$lambda$3(ItemsController.this, (ItemsNavigation.Event) obj);
            }
        });
        Relay<NavEvent<C>> relay = this.nav;
        Items<C> invoke = restoreState == null ? initialState.invoke() : restoreState;
        if (savedState != null && (childState = savedState.getChildState()) != null && restoreState != null) {
            map = childState;
        }
        relay.accept(new NavEvent.Init(invoke, map));
        return subscribe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final SavedState init$lambda$2(NavStateSaver navStateSaver, ItemsController itemsController) {
        SerializableContainer saveState = navStateSaver.saveState(itemsController.navState.getValue());
        if (saveState != null) {
            return new SavedState(saveState, itemsController.saveChildState());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit init$lambda$3(ItemsController itemsController, ItemsNavigation.Event it) {
        Intrinsics.checkNotNullParameter(it, "it");
        itemsController.nav.accept(new NavEvent.Event(it));
        return Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.router.items.ItemsNavigator
    public void navigate(Function1<? super Items<C>, Items<C>> transformer, Function2<? super Items<C>, ? super Items<C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.nav.accept(new NavEvent.Event(new ItemsNavigation.Event(transformer, onComplete)));
    }

    private final Map<Integer, SerializableContainer> saveChildState() {
        HashMap hashMap = new HashMap();
        int i = 0;
        for (T t : this.navState.getValue().getItems()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SerializableContainer saveState = this.controller.saveState((ChildController<C, T, ?>) t);
            if (saveState != null) {
                hashMap.put(Integer.valueOf(i), saveState);
            }
            i = i2;
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEvent(NavEvent<C> navEvent) {
        if (navEvent instanceof NavEvent.Init) {
            onInit((NavEvent.Init) navEvent);
        } else if (!(navEvent instanceof NavEvent.Event)) {
            throw new NoWhenBranchMatchedException();
        } else {
            onEvent(((NavEvent.Event) navEvent).getEvent());
        }
    }

    private final void onInit(NavEvent.Init<C> init) {
        final Items<C> initialState = init.getInitialState();
        final Map<Integer, SerializableContainer> savedChildState = init.getSavedChildState();
        final HashMap hashMap = new HashMap();
        this.controller.init(savedChildState == null, new Function0() { // from class: com.arkivanov.decompose.router.items.ItemsController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ItemsController.onInit$lambda$8(Items.this, savedChildState, this, hashMap);
            }
        });
        setState(initialState, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onInit$lambda$8(Items items, Map map, ItemsController itemsController, HashMap hashMap) {
        int i = 0;
        for (T t : items.getItems()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SerializableContainer serializableContainer = map != null ? (SerializableContainer) map.get(Integer.valueOf(i)) : null;
            Items.ActiveLifecycleState activeLifecycleState = items.getActiveItems().get(t);
            if (activeLifecycleState != null) {
                hashMap.put(t, TuplesKt.to(itemsController.activateChild(t, activeLifecycleState, serializableContainer), activeLifecycleState));
            } else {
                itemsController.controller.destroy(t, serializableContainer);
            }
            i = i2;
        }
        return Unit.INSTANCE;
    }

    private final void setState(Items<C> items, Map<C, ? extends Pair<? extends T, ? extends Items.ActiveLifecycleState>> map) {
        this.navState.setValue(items);
        this._state.setValue(new ChildItems<>(items.getItems(), map));
    }

    private final void onEvent(ItemsNavigation.Event<C> event) {
        Items<C> value = this.navState.getValue();
        Items<C> invoke = event.getTransformer().invoke(value);
        Items<C> items = invoke;
        List<C> items2 = items.getItems();
        if (items2 == value.getItems()) {
            items2 = null;
        }
        Set set = items2 != null ? CollectionsKt.toSet(items2) : null;
        if (set != null) {
            if (set.size() != items.getItems().size()) {
                Pair findFirstDuplicate = UtilsKt.findFirstDuplicate(items.getItems(), set);
                throw new IllegalStateException(("Configurations must be unique. First duplicate: " + (findFirstDuplicate != null ? findFirstDuplicate.getSecond() : null) + " at index " + (findFirstDuplicate != null ? (Integer) findFirstDuplicate.getFirst() : null) + ". List size: " + items.getItems().size() + '.').toString());
            }
            HashSet hashSet = new HashSet();
            for (T t : items.getActiveItems().keySet()) {
                if (!set.contains(t)) {
                    hashSet.add(t);
                }
            }
            HashSet hashSet2 = hashSet;
            if (!hashSet2.isEmpty()) {
                invoke = Items.copy$default(items, null, MapsKt.minus((Map) items.getActiveItems(), (Iterable) hashSet2), 1, null);
            }
        }
        Items<C> items3 = invoke;
        Items<C> items4 = items3;
        Map<C, Items.ActiveLifecycleState> activeItems = items4.getActiveItems();
        Map<C, ? extends Pair<? extends T, ? extends Items.ActiveLifecycleState>> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(activeItems.size()));
        Iterator<T> it = activeItems.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object key2 = entry.getKey();
            Items.ActiveLifecycleState activeLifecycleState = (Items.ActiveLifecycleState) entry.getValue();
            linkedHashMap.put(key, TuplesKt.to(activateChild$default(this, key2, activeLifecycleState, null, 4, null), activeLifecycleState));
        }
        for (Map.Entry<C, Items.ActiveLifecycleState> entry2 : value.getActiveItems().entrySet()) {
            C key3 = entry2.getKey();
            if (!items4.getActiveItems().containsKey(key3)) {
                if (set == null || set.contains(key3)) {
                    ChildController.destroy$default(this.controller, key3, null, 2, null);
                } else {
                    this.controller.remove(key3);
                }
            }
        }
        setState(items4, linkedHashMap);
        event.getOnComplete().invoke(items3, value);
    }

    static /* synthetic */ Object activateChild$default(ItemsController itemsController, Object obj, Items.ActiveLifecycleState activeLifecycleState, SerializableContainer serializableContainer, int i, Object obj2) {
        if ((i & 4) != 0) {
            serializableContainer = null;
        }
        return itemsController.activateChild(obj, activeLifecycleState, serializableContainer);
    }

    private final T activateChild(C c, Items.ActiveLifecycleState activeLifecycleState, SerializableContainer serializableContainer) {
        int i = WhenMappings.$EnumSwitchMapping$0[activeLifecycleState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                return (T) ChildController.resume$default(this.controller, c, 0, serializableContainer, 2, null);
            }
            return (T) ChildController.start$default(this.controller, c, 0, serializableContainer, 2, null);
        }
        return this.controller.create(c, serializableContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ItemsController.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\b\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/arkivanov/decompose/router/items/ItemsController$SavedState;", "", "navState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "childState", "", "", "<init>", "(Lcom/arkivanov/essenty/statekeeper/SerializableContainer;Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/arkivanov/essenty/statekeeper/SerializableContainer;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNavState", "()Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "getChildState", "()Ljava/util/Map;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$decompose_release", "$serializer", "Companion", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes4.dex */
    public static final class SavedState {
        private final Map<Integer, SerializableContainer> childState;
        private final SerializableContainer navState;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new LinkedHashMapSerializer(IntSerializer.INSTANCE, SerializableContainer.Serializer.INSTANCE)};

        /* compiled from: ItemsController.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/items/ItemsController$SavedState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/decompose/router/items/ItemsController$SavedState;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SavedState> serializer() {
                return ItemsController$SavedState$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SavedState(int i, SerializableContainer serializableContainer, Map map, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, ItemsController$SavedState$$serializer.INSTANCE.getDescriptor());
            }
            this.navState = serializableContainer;
            this.childState = map;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$decompose_release(SavedState savedState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, SerializableContainer.Serializer.INSTANCE, savedState.navState);
            compositeEncoder.encodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], savedState.childState);
        }

        public SavedState(SerializableContainer navState, Map<Integer, SerializableContainer> childState) {
            Intrinsics.checkNotNullParameter(navState, "navState");
            Intrinsics.checkNotNullParameter(childState, "childState");
            this.navState = navState;
            this.childState = childState;
        }

        public final SerializableContainer getNavState() {
            return this.navState;
        }

        public final Map<Integer, SerializableContainer> getChildState() {
            return this.childState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ItemsController.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent;", "C", "", "Init", "Event", "Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent$Event;", "Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent$Init;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface NavEvent<C> {

        /* compiled from: ItemsController.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent$Init;", "C", "", "Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent;", "initialState", "Lcom/arkivanov/decompose/router/items/Items;", "savedChildState", "", "", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "<init>", "(Lcom/arkivanov/decompose/router/items/Items;Ljava/util/Map;)V", "getInitialState", "()Lcom/arkivanov/decompose/router/items/Items;", "getSavedChildState", "()Ljava/util/Map;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Init<C> implements NavEvent<C> {
            private final Items<C> initialState;
            private final Map<Integer, SerializableContainer> savedChildState;

            public Init(Items<C> initialState, Map<Integer, SerializableContainer> map) {
                Intrinsics.checkNotNullParameter(initialState, "initialState");
                this.initialState = initialState;
                this.savedChildState = map;
            }

            public final Items<C> getInitialState() {
                return this.initialState;
            }

            public final Map<Integer, SerializableContainer> getSavedChildState() {
                return this.savedChildState;
            }
        }

        /* compiled from: ItemsController.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent$Event;", "C", "", "Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent;", "event", "Lcom/arkivanov/decompose/router/items/ItemsNavigation$Event;", "<init>", "(Lcom/arkivanov/decompose/router/items/ItemsNavigation$Event;)V", "getEvent", "()Lcom/arkivanov/decompose/router/items/ItemsNavigation$Event;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Event<C> implements NavEvent<C> {
            private final ItemsNavigation.Event<C> event;

            public Event(ItemsNavigation.Event<C> event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.event = event;
            }

            public final ItemsNavigation.Event<C> getEvent() {
                return this.event;
            }
        }
    }
}
