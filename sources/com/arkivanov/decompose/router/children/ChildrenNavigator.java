package com.arkivanov.decompose.router.children;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.DecomposeSettings;
import com.arkivanov.decompose.ItemKey;
import com.arkivanov.decompose.UtilsKt;
import com.arkivanov.decompose.router.children.ChildItem;
import com.arkivanov.decompose.router.children.ChildItemFactory;
import com.arkivanov.decompose.router.children.ChildNavState;
import com.arkivanov.decompose.router.children.NavState;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.lifecycle.LifecycleRegistryExtKt;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: ChildrenNavigator.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\b\b\u0000\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u0002*\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00020\u0002:\u0002IJBd\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012'\u0010\b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00028\u0002\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010)\u001a\u00020*2\u0006\u0010\u0011\u001a\u00028\u00022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0002\u0010,JK\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010.\u001a\u00020/2\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000010\n2\u0018\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001030\nH\u0082\bJ\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u001a\u00105\u001a\u0004\u0018\u000106*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0002J\u0013\u00107\u001a\u00020*2\u0006\u0010\u0011\u001a\u00028\u0002¢\u0006\u0002\u00108J\u001c\u00109\u001a\u00020*2\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0\u0013H\u0002J`\u0010<\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!\u0012\u0004\u0012\u00020/0=0\u00132\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00020?\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0>2\u001e\u0010@\u001a\u001a\u0012\u0004\u0012\u00020?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0>H\u0002J6\u0010A\u001a\u00020*2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020?0C2\u001e\u0010@\u001a\u001a\u0012\u0004\u0012\u00020?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0>H\u0002J.\u0010D\u001a\u00020*2$\u0010E\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!\u0012\u0004\u0012\u00020/0=0\u0013H\u0002J0\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001032\u0006\u0010.\u001a\u00020/H\u0002J\u0014\u0010H\u001a\u00020**\n\u0012\u0002\b\u0003\u0012\u0002\b\u000303H\u0002R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u00028\u00022\u0006\u0010\u0017\u001a\u00028\u0002@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001eR-\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0 8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b$\u0010%*\u0004\b\"\u0010#R#\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u00138F¢\u0006\u0006\u001a\u0004\b(\u0010%¨\u0006K"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildrenNavigator;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "N", "Lcom/arkivanov/decompose/router/children/NavState;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "retainedInstanceSupplier", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "Lkotlin/ParameterName;", "name", "factory", "childItemFactory", "Lcom/arkivanov/decompose/router/children/ChildItemFactory;", "navState", "savedChildState", "", "Lcom/arkivanov/decompose/router/children/ChildrenNavigator$SavedChildState;", "<init>", "(Lcom/arkivanov/essenty/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;Lcom/arkivanov/decompose/router/children/ChildItemFactory;Lcom/arkivanov/decompose/router/children/NavState;Ljava/util/List;)V", "value", "getNavState", "()Lcom/arkivanov/decompose/router/children/NavState;", "Lcom/arkivanov/decompose/router/children/NavState;", "retainedInstance", "Lcom/arkivanov/decompose/router/children/ChildrenNavigator$RetainedInstance;", "getRetainedInstance$annotations", "()V", "items", "", "Lcom/arkivanov/decompose/router/children/ChildItem;", "getItems$delegate", "(Lcom/arkivanov/decompose/router/children/ChildrenNavigator;)Ljava/lang/Object;", "getItems", "()Ljava/util/List;", "children", "Lcom/arkivanov/decompose/Child;", "getChildren", "restore", "", "savedStates", "(Lcom/arkivanov/decompose/router/children/NavState;Ljava/util/List;)V", "restoreItem", NotificationCompat.CATEGORY_STATUS, "Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", "getDestroyedItem", "Lcom/arkivanov/decompose/router/children/ChildItem$Destroyed;", "getCreatedItem", "Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "saveChildState", "saveState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "navigate", "(Lcom/arkivanov/decompose/router/children/NavState;)V", "switch", "newStates", "Lcom/arkivanov/decompose/router/children/ChildNavState;", "prepareNewItems", "Lkotlin/Pair;", "", "Lcom/arkivanov/decompose/ItemKey;", "oldItems", "destroyOldItems", "newKeys", "", "processNewItems", "newItems", "processNewItem", "item", "destroy", "SavedChildState", "RetainedInstance", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildrenNavigator<C, T, N extends NavState<? extends C>> {
    private final ChildItemFactory<C, T> childItemFactory;
    private N navState;
    private final RetainedInstance<C, T> retainedInstance;

    /* compiled from: ChildrenNavigator.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChildNavState.Status.values().length];
            try {
                iArr[ChildNavState.Status.DESTROYED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChildNavState.Status.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChildNavState.Status.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChildNavState.Status.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getRetainedInstance$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChildrenNavigator(Lifecycle lifecycle, Function1<? super Function0<? extends InstanceKeeper.Instance>, ? extends InstanceKeeper.Instance> retainedInstanceSupplier, ChildItemFactory<C, ? extends T> childItemFactory, N navState, List<SavedChildState> list) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(retainedInstanceSupplier, "retainedInstanceSupplier");
        Intrinsics.checkNotNullParameter(childItemFactory, "childItemFactory");
        Intrinsics.checkNotNullParameter(navState, "navState");
        this.childItemFactory = childItemFactory;
        this.navState = navState;
        InstanceKeeper.Instance invoke = retainedInstanceSupplier.invoke(new Function0() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ChildrenNavigator.retainedInstance$lambda$0();
            }
        });
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type com.arkivanov.decompose.router.children.ChildrenNavigator.RetainedInstance<C of com.arkivanov.decompose.router.children.ChildrenNavigator, T of com.arkivanov.decompose.router.children.ChildrenNavigator>");
        RetainedInstance<C, T> retainedInstance = (RetainedInstance) invoke;
        this.retainedInstance = retainedInstance;
        if (list == null) {
            retainedInstance.onDestroy();
            m9475switch(navState.getChildren());
        } else {
            restore(navState, list);
        }
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            for (ChildItem childItem : CollectionsKt.asReversedMutable(getItems())) {
                if (childItem instanceof ChildItem.Created) {
                    ChildItem.Created created = (ChildItem.Created) childItem;
                    created.getBackHandler().stop();
                    LifecycleRegistryExtKt.destroy(created.getLifecycleRegistry());
                } else if (!(childItem instanceof ChildItem.Destroyed)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return;
        }
        lifecycle.subscribe(new Lifecycle.Callbacks() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$special$$inlined$doOnDestroy$1
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
                for (ChildItem childItem2 : CollectionsKt.asReversedMutable(ChildrenNavigator.this.getItems())) {
                    if (childItem2 instanceof ChildItem.Created) {
                        ChildItem.Created created2 = (ChildItem.Created) childItem2;
                        created2.getBackHandler().stop();
                        LifecycleRegistryExtKt.destroy(created2.getLifecycleRegistry());
                    } else if (!(childItem2 instanceof ChildItem.Destroyed)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
        });
    }

    public final N getNavState() {
        return this.navState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final InstanceKeeper.Instance retainedInstance$lambda$0() {
        return new RetainedInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ChildItem<C, T>> getItems() {
        return this.retainedInstance.getItems();
    }

    public final List<Child<C, T>> getChildren() {
        Child destroyed;
        List<ChildItem<C, T>> items = getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            ChildItem childItem = (ChildItem) it.next();
            Object childItem2 = childItem.getInstance();
            if (childItem2 != null) {
                destroyed = new Child.Created(childItem.getConfiguration(), childItem2, childItem.getKey());
            } else {
                destroyed = new Child.Destroyed(childItem.getConfiguration(), childItem.getKey());
            }
            arrayList.add(destroyed);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void restore(N n, List<SavedChildState> list) {
        HashMap hashMap;
        Collection<ChildItem> values;
        ChildItem<C, T> destroyed;
        ChildItem childItem;
        ChildItem childItem2;
        ChildItem childItem3;
        List<ChildItem<C, T>> items = getItems();
        if (items.isEmpty()) {
            items = null;
        }
        int i = 0;
        if (items != null) {
            List<ChildItem<C, T>> list2 = items;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            int i2 = 0;
            for (T t : list2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new Pair(Integer.valueOf(i2), (ChildItem) t));
                i2 = i3;
            }
            hashMap = (HashMap) MapsKt.toMap(arrayList, new HashMap());
        } else {
            hashMap = null;
        }
        getItems().clear();
        for (T t2 : CollectionsKt.zip(n.getChildren(), list)) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) t2;
            ChildNavState childNavState = (ChildNavState) pair.component1();
            SavedChildState savedChildState = (SavedChildState) pair.component2();
            List<ChildItem<C, T>> items2 = getItems();
            int i5 = WhenMappings.$EnumSwitchMapping$0[childNavState.getStatus().ordinal()];
            if (i5 == 1) {
                destroyed = new ChildItem.Destroyed(childNavState.getConfiguration(), savedChildState.getKey(), savedChildState.getSavedState());
            } else if (i5 == 2) {
                destroyed = this.childItemFactory.invoke(childNavState.getConfiguration(), savedChildState.getKey(), savedChildState.getSavedState(), (hashMap == null || (childItem = (ChildItem) hashMap.remove(Integer.valueOf(i))) == null) ? null : childItem.getInstanceKeeperDispatcher());
                LifecycleRegistryExtKt.create(destroyed.getLifecycleRegistry());
            } else if (i5 == 3) {
                destroyed = this.childItemFactory.invoke(childNavState.getConfiguration(), savedChildState.getKey(), savedChildState.getSavedState(), (hashMap == null || (childItem2 = (ChildItem) hashMap.remove(Integer.valueOf(i))) == null) ? null : childItem2.getInstanceKeeperDispatcher());
                destroyed.getBackHandler().start();
                LifecycleRegistryExtKt.start(destroyed.getLifecycleRegistry());
            } else if (i5 != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                destroyed = this.childItemFactory.invoke(childNavState.getConfiguration(), savedChildState.getKey(), savedChildState.getSavedState(), (hashMap == null || (childItem3 = (ChildItem) hashMap.remove(Integer.valueOf(i))) == null) ? null : childItem3.getInstanceKeeperDispatcher());
                destroyed.getBackHandler().start();
                LifecycleRegistryExtKt.resume(destroyed.getLifecycleRegistry());
            }
            items2.add(destroyed);
            i = i4;
        }
        if (hashMap == null || (values = hashMap.values()) == null) {
            return;
        }
        for (ChildItem childItem4 : values) {
            InstanceKeeperDispatcher instanceKeeperDispatcher = childItem4.getInstanceKeeperDispatcher();
            if (instanceKeeperDispatcher != null) {
                instanceKeeperDispatcher.destroy();
            }
        }
    }

    private final ChildItem<C, T> restoreItem(ChildNavState.Status status, Function0<? extends ChildItem.Destroyed<? extends C>> function0, Function0<? extends ChildItem.Created<? extends C, ? extends T>> function02) {
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i != 1) {
            if (i == 2) {
                ChildItem.Created<? extends C, ? extends T> invoke = function02.invoke();
                LifecycleRegistryExtKt.create(invoke.getLifecycleRegistry());
                return invoke;
            } else if (i == 3) {
                ChildItem.Created<? extends C, ? extends T> invoke2 = function02.invoke();
                ChildItem.Created<? extends C, ? extends T> created = invoke2;
                created.getBackHandler().start();
                LifecycleRegistryExtKt.start(created.getLifecycleRegistry());
                return invoke2;
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                ChildItem.Created<? extends C, ? extends T> invoke3 = function02.invoke();
                ChildItem.Created<? extends C, ? extends T> created2 = invoke3;
                created2.getBackHandler().start();
                LifecycleRegistryExtKt.resume(created2.getLifecycleRegistry());
                return invoke3;
            }
        }
        return function0.invoke();
    }

    public final List<SavedChildState> saveChildState() {
        List<ChildItem<C, T>> items = getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            ChildItem<? extends C, ? extends T> childItem = (ChildItem) it.next();
            arrayList.add(new SavedChildState(childItem.getKey(), saveState(childItem)));
        }
        return arrayList;
    }

    private final SerializableContainer saveState(ChildItem<? extends C, ? extends T> childItem) {
        if (childItem instanceof ChildItem.Created) {
            return ((ChildItem.Created) childItem).getStateKeeperDispatcher().save();
        }
        if (childItem instanceof ChildItem.Destroyed) {
            return ((ChildItem.Destroyed) childItem).getSavedState();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void navigate(N navState) {
        Intrinsics.checkNotNullParameter(navState, "navState");
        m9475switch(navState.getChildren());
        this.navState = navState;
    }

    /* renamed from: switch  reason: not valid java name */
    private final void m9475switch(List<? extends ChildNavState<? extends C>> list) {
        Map<ItemKey, ? extends ChildNavState<? extends C>> keyed = UtilsKt.keyed(list, new PropertyReference1Impl() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$switch$newKeyedStates$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ChildNavState) obj).getConfiguration();
            }
        });
        if (!DecomposeSettings.Companion.getSettings().getDuplicateConfigurationsEnabled()) {
            List<? extends ChildNavState<? extends C>> list2 = list;
            HashSet hashSet = new HashSet();
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                hashSet.add(((ChildNavState) it.next()).getConfiguration());
            }
            if (hashSet.size() != list.size()) {
                StringBuilder sb = new StringBuilder("Configurations must be unique: ");
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((ChildNavState) it2.next()).getConfiguration());
                }
                throw new IllegalStateException(sb.append(arrayList).append('.').toString().toString());
            }
        }
        Map<ItemKey, ? extends ChildItem<? extends C, ? extends T>> keyed2 = UtilsKt.keyed(getItems(), new PropertyReference1Impl() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$switch$oldKeyedItems$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ChildItem) obj).getConfiguration();
            }
        });
        List<Pair<ChildItem<C, T>, ChildNavState.Status>> prepareNewItems = prepareNewItems(keyed, keyed2);
        destroyOldItems(keyed.keySet(), keyed2);
        processNewItems(prepareNewItems);
    }

    private final List<Pair<ChildItem<C, T>, ChildNavState.Status>> prepareNewItems(Map<ItemKey, ? extends ChildNavState<? extends C>> map, Map<ItemKey, ? extends ChildItem<? extends C, ? extends T>> map2) {
        Pair pair;
        Pair pair2;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<ItemKey, ? extends ChildNavState<? extends C>> entry : map.entrySet()) {
            ChildNavState<? extends C> value = entry.getValue();
            ArrayList arrayList2 = arrayList;
            ChildItem<? extends C, ? extends T> childItem = map2.get(entry.getKey());
            if (childItem instanceof ChildItem.Created) {
                pair = TuplesKt.to(childItem, value.getStatus());
            } else if (childItem instanceof ChildItem.Destroyed) {
                int i = WhenMappings.$EnumSwitchMapping$0[value.getStatus().ordinal()];
                if (i == 1) {
                    pair = TuplesKt.to(childItem, value.getStatus());
                } else if (i != 2 && i != 3 && i != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    ChildItem.Destroyed destroyed = (ChildItem.Destroyed) childItem;
                    ChildItem.Created invoke$default = ChildItemFactory.DefaultImpls.invoke$default(this.childItemFactory, value.getConfiguration(), destroyed.getKey(), destroyed.getSavedState(), null, 8, null);
                    LifecycleRegistryExtKt.create(invoke$default.getLifecycleRegistry());
                    pair2 = new Pair(invoke$default, value.getStatus());
                    pair = pair2;
                }
            } else if (childItem != null) {
                throw new NoWhenBranchMatchedException();
            } else {
                int i2 = WhenMappings.$EnumSwitchMapping$0[value.getStatus().ordinal()];
                if (i2 == 1) {
                    pair = TuplesKt.to(new ChildItem.Destroyed(value.getConfiguration(), ChildItemKt.randomKey(), null, 4, null), value.getStatus());
                } else if (i2 != 2 && i2 != 3 && i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    ChildItem.Created invoke$default2 = ChildItemFactory.DefaultImpls.invoke$default(this.childItemFactory, value.getConfiguration(), ChildItemKt.randomKey(), null, null, 12, null);
                    LifecycleRegistryExtKt.create(invoke$default2.getLifecycleRegistry());
                    pair2 = new Pair(invoke$default2, value.getStatus());
                    pair = pair2;
                }
            }
            arrayList2.add(pair);
        }
        return arrayList;
    }

    private final void destroyOldItems(Set<ItemKey> set, Map<ItemKey, ? extends ChildItem<? extends C, ? extends T>> map) {
        for (Map.Entry<ItemKey, ? extends ChildItem<? extends C, ? extends T>> entry : map.entrySet()) {
            ItemKey key = entry.getKey();
            ChildItem<? extends C, ? extends T> value = entry.getValue();
            ChildItem.Created<?, ?> created = value instanceof ChildItem.Created ? (ChildItem.Created) value : null;
            if (created != null && !set.contains(key)) {
                destroy(created);
            }
        }
    }

    private final void processNewItems(List<? extends Pair<? extends ChildItem<? extends C, ? extends T>, ? extends ChildNavState.Status>> list) {
        getItems().clear();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ChildItem<C, T> childItem = (ChildItem) pair.component1();
            ChildNavState.Status status = (ChildNavState.Status) pair.component2();
            List<ChildItem<C, T>> items = getItems();
            if (childItem instanceof ChildItem.Created) {
                childItem = processNewItem((ChildItem.Created) childItem, status);
            } else if (!(childItem instanceof ChildItem.Destroyed)) {
                throw new NoWhenBranchMatchedException();
            }
            items.add(childItem);
        }
    }

    private final ChildItem<C, T> processNewItem(ChildItem.Created<? extends C, ? extends T> created, ChildNavState.Status status) {
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            SerializableContainer save = created.getStateKeeperDispatcher().save();
            destroy(created);
            return new ChildItem.Destroyed(created.getConfiguration(), created.getKey(), save);
        } else if (i == 2) {
            if (created.getLifecycleRegistry().getState() != Lifecycle.State.CREATED) {
                created.getBackHandler().stop();
                LifecycleRegistryExtKt.stop(created.getLifecycleRegistry());
            }
            return created;
        } else if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (created.getLifecycleRegistry().getState() != Lifecycle.State.RESUMED) {
                created.getBackHandler().start();
                LifecycleRegistryExtKt.resume(created.getLifecycleRegistry());
            }
            return created;
        } else {
            if (created.getLifecycleRegistry().getState().compareTo(Lifecycle.State.STARTED) < 0) {
                created.getBackHandler().start();
                LifecycleRegistryExtKt.start(created.getLifecycleRegistry());
            } else if (created.getLifecycleRegistry().getState().compareTo(Lifecycle.State.STARTED) > 0) {
                LifecycleRegistryExtKt.pause(created.getLifecycleRegistry());
            }
            return created;
        }
    }

    private final void destroy(ChildItem.Created<?, ?> created) {
        created.getBackHandler().stop();
        LifecycleRegistryExtKt.destroy(created.getLifecycleRegistry());
        created.getInstanceKeeperDispatcher().destroy();
    }

    /* compiled from: ChildrenNavigator.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildrenNavigator$SavedChildState;", "", "key", "", "savedState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "<init>", "(Ljava/lang/String;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey", "()Ljava/lang/String;", "getSavedState", "()Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$decompose_release", "$serializer", "Companion", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes3.dex */
    public static final class SavedChildState {
        public static final Companion Companion = new Companion(null);
        private final String key;
        private final SerializableContainer savedState;

        public static /* synthetic */ SavedChildState copy$default(SavedChildState savedChildState, String str, SerializableContainer serializableContainer, int i, Object obj) {
            if ((i & 1) != 0) {
                str = savedChildState.key;
            }
            if ((i & 2) != 0) {
                serializableContainer = savedChildState.savedState;
            }
            return savedChildState.copy(str, serializableContainer);
        }

        public final String component1() {
            return this.key;
        }

        public final SerializableContainer component2() {
            return this.savedState;
        }

        public final SavedChildState copy(String key, SerializableContainer serializableContainer) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new SavedChildState(key, serializableContainer);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SavedChildState) {
                SavedChildState savedChildState = (SavedChildState) obj;
                return Intrinsics.areEqual(this.key, savedChildState.key) && Intrinsics.areEqual(this.savedState, savedChildState.savedState);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.key.hashCode() * 31;
            SerializableContainer serializableContainer = this.savedState;
            return hashCode + (serializableContainer == null ? 0 : serializableContainer.hashCode());
        }

        public String toString() {
            return "SavedChildState(key=" + this.key + ", savedState=" + this.savedState + ')';
        }

        /* compiled from: ChildrenNavigator.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildrenNavigator$SavedChildState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/decompose/router/children/ChildrenNavigator$SavedChildState;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SavedChildState> serializer() {
                return ChildrenNavigator$SavedChildState$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SavedChildState(int i, String str, SerializableContainer serializableContainer, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, ChildrenNavigator$SavedChildState$$serializer.INSTANCE.getDescriptor());
            }
            this.key = str;
            this.savedState = serializableContainer;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$decompose_release(SavedChildState savedChildState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.encodeStringElement(serialDescriptor, 0, savedChildState.key);
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, SerializableContainer.Serializer.INSTANCE, savedChildState.savedState);
        }

        public SavedChildState(String key, SerializableContainer serializableContainer) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.savedState = serializableContainer;
        }

        public final String getKey() {
            return this.key;
        }

        public final SerializableContainer getSavedState() {
            return this.savedState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChildrenNavigator.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u0002*\b\b\u0004\u0010\u0003*\u00020\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildrenNavigator$RetainedInstance;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "<init>", "()V", "items", "", "Lcom/arkivanov/decompose/router/children/ChildItem;", "getItems", "()Ljava/util/List;", "onDestroy", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RetainedInstance<C, T> implements InstanceKeeper.Instance {
        private final List<ChildItem<C, T>> items = new ArrayList();

        public final List<ChildItem<C, T>> getItems() {
            return this.items;
        }

        @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper.Instance
        public void onDestroy() {
            for (ChildItem childItem : CollectionsKt.toList(this.items)) {
                InstanceKeeperDispatcher instanceKeeperDispatcher = childItem.getInstanceKeeperDispatcher();
                if (instanceKeeperDispatcher != null) {
                    instanceKeeperDispatcher.destroy();
                }
            }
            this.items.clear();
        }
    }
}
