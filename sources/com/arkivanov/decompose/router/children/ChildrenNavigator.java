package com.arkivanov.decompose.router.children;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.DecomposeExperimentFlags;
import com.arkivanov.decompose.GettingList;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.ranges.RangesKt;
/* compiled from: ChildrenNavigator.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u001e\n\u0002\b\u000b\b\u0000\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u0002*\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00020\u0002:\u0001NBf\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012'\u0010\b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00028\u0002\u0012\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 0\u0013H\u0002J\u001a\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 0\u0013H\u0002J%\u0010)\u001a\u00020*2\u0006\u0010\u0011\u001a\u00028\u00022\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002¢\u0006\u0002\u0010,J%\u0010-\u001a\u00020*2\u0006\u0010\u0011\u001a\u00028\u00022\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002¢\u0006\u0002\u0010,J%\u0010.\u001a\u00020*2\u0006\u0010\u0011\u001a\u00028\u00022\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002¢\u0006\u0002\u0010,JK\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000030\n2\u0018\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001050\nH\u0082\bJ\u000e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013J\u0013\u00107\u001a\u00020*2\u0006\u0010\u0011\u001a\u00028\u0002¢\u0006\u0002\u00108J\u001c\u00109\u001a\u00020*2\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0\u0013H\u0002J\u001c\u0010<\u001a\u00020*2\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0\u0013H\u0002JZ\u0010=\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d\u0012\u0004\u0012\u0002010>0\u00132\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0\u00132\u001e\u0010?\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d0@H\u0002J0\u0010A\u001a\u00020*2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000C2\u0018\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d0DH\u0002J\u001c\u0010E\u001a\u00020*2\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0\u0013H\u0002J`\u0010F\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d\u0012\u0004\u0012\u0002010>0\u00132\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0@2\u001e\u0010?\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d0@H\u0002J6\u0010G\u001a\u00020*2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020C2\u001e\u0010?\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d0@H\u0002J.\u0010I\u001a\u00020*2$\u0010J\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d\u0012\u0004\u0012\u0002010>0\u0013H\u0002J0\u0010K\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001052\u0006\u00100\u001a\u000201H\u0002J\u0014\u0010M\u001a\u00020**\n\u0012\u0002\b\u0003\u0012\u0002\b\u000305H\u0002R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u00028\u00022\u0006\u0010\u0017\u001a\u00028\u0002@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R6\u0010\u001b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d0\u001cj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 0\u00138F¢\u0006\u0006\u001a\u0004\b!\u0010\"R \u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010(¨\u0006O"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildrenNavigator;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "N", "Lcom/arkivanov/decompose/router/children/NavState;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "retainedInstanceSupplier", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "Lkotlin/ParameterName;", "name", "factory", "childItemFactory", "Lcom/arkivanov/decompose/router/children/ChildItemFactory;", "navState", "savedChildState", "", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "<init>", "(Lcom/arkivanov/essenty/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;Lcom/arkivanov/decompose/router/children/ChildItemFactory;Lcom/arkivanov/decompose/router/children/NavState;Ljava/util/List;)V", "value", "getNavState", "()Lcom/arkivanov/decompose/router/children/NavState;", "Lcom/arkivanov/decompose/router/children/NavState;", FirebaseAnalytics.Param.ITEMS, "Ljava/util/ArrayList;", "Lcom/arkivanov/decompose/router/children/ChildItem;", "Lkotlin/collections/ArrayList;", "children", "Lcom/arkivanov/decompose/Child;", "getChildren", "()Ljava/util/List;", "getChildrenDefault", "getChildrenExperimental", "retainedInstance", "Lcom/arkivanov/decompose/router/children/ChildrenNavigator$RetainedInstance;", "getRetainedInstance$annotations", "()V", "restore", "", "savedStates", "(Lcom/arkivanov/decompose/router/children/NavState;Ljava/util/List;)V", "restoreDefault", "restoreExperimental", "restoreItem", NotificationCompat.CATEGORY_STATUS, "Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", "getDestroyedItem", "Lcom/arkivanov/decompose/router/children/ChildItem$Destroyed;", "getCreatedItem", "Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "saveChildState", "navigate", "(Lcom/arkivanov/decompose/router/children/NavState;)V", "switch", "newStates", "Lcom/arkivanov/decompose/router/children/ChildNavState;", "switchDefault", "prepareNewItemsDefault", "Lkotlin/Pair;", "oldItems", "", "destroyOldItemsDefault", "newConfigurations", "", "", "switchExperimental", "prepareNewItemsExperimental", "destroyOldItemsExperimental", "newKeys", "processNewItems", "newItems", "processNewItem", "item", "destroy", "RetainedInstance", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildrenNavigator<C, T, N extends NavState<? extends C>> {
    private final ChildItemFactory<C, T> childItemFactory;
    private final ArrayList<ChildItem<C, T>> items;
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
    public ChildrenNavigator(Lifecycle lifecycle, Function1<? super Function0<? extends InstanceKeeper.Instance>, ? extends InstanceKeeper.Instance> retainedInstanceSupplier, ChildItemFactory<C, ? extends T> childItemFactory, N navState, List<SerializableContainer> list) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(retainedInstanceSupplier, "retainedInstanceSupplier");
        Intrinsics.checkNotNullParameter(childItemFactory, "childItemFactory");
        Intrinsics.checkNotNullParameter(navState, "navState");
        this.childItemFactory = childItemFactory;
        this.navState = navState;
        this.items = new ArrayList<>();
        InstanceKeeper.Instance invoke = retainedInstanceSupplier.invoke(new Function0() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                InstanceKeeper.Instance retainedInstance$lambda$3;
                retainedInstance$lambda$3 = ChildrenNavigator.retainedInstance$lambda$3();
                return retainedInstance$lambda$3;
            }
        });
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type com.arkivanov.decompose.router.children.ChildrenNavigator.RetainedInstance<C of com.arkivanov.decompose.router.children.ChildrenNavigator, T of com.arkivanov.decompose.router.children.ChildrenNavigator>");
        RetainedInstance<C, T> retainedInstance = (RetainedInstance) invoke;
        this.retainedInstance = retainedInstance;
        if (list == null) {
            retainedInstance.onDestroy();
            m8015switch(navState.getChildren());
        } else {
            restore(navState, list);
        }
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            for (ChildItem childItem : CollectionsKt.asReversedMutable(this.items)) {
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
                for (ChildItem childItem2 : CollectionsKt.asReversedMutable(ChildrenNavigator.this.items)) {
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

    public final List<Child<C, T>> getChildren() {
        if (DecomposeExperimentFlags.INSTANCE.getDuplicateConfigurationsEnabled()) {
            return getChildrenExperimental();
        }
        return getChildrenDefault();
    }

    private final List<Child<C, T>> getChildrenDefault() {
        Child destroyed;
        ArrayList<ChildItem<C, T>> arrayList = this.items;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ChildItem childItem = (ChildItem) it.next();
            Object childItem2 = childItem.getInstance();
            if (childItem2 != null) {
                destroyed = new Child.Created(childItem.getConfiguration(), childItem2);
            } else {
                destroyed = new Child.Destroyed(childItem.getConfiguration());
            }
            arrayList2.add(destroyed);
        }
        return arrayList2;
    }

    private final List<Child<C, T>> getChildrenExperimental() {
        Child destroyed;
        Map keyed = UtilsKt.keyed(this.items, new Function1() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object childrenExperimental$lambda$1;
                childrenExperimental$lambda$1 = ChildrenNavigator.getChildrenExperimental$lambda$1((ChildItem) obj);
                return childrenExperimental$lambda$1;
            }
        });
        ArrayList arrayList = new ArrayList(keyed.size());
        for (Map.Entry entry : keyed.entrySet()) {
            Object key = entry.getKey();
            ChildItem childItem = (ChildItem) entry.getValue();
            Object childItem2 = childItem.getInstance();
            if (childItem2 != null) {
                destroyed = new Child.Created(childItem.getConfiguration(), childItem2, key);
            } else {
                destroyed = new Child.Destroyed(childItem.getConfiguration(), key);
            }
            arrayList.add(destroyed);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getChildrenExperimental$lambda$1(ChildItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getConfiguration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstanceKeeper.Instance retainedInstance$lambda$3() {
        return new RetainedInstance();
    }

    private final void restore(N n, List<SerializableContainer> list) {
        if (DecomposeExperimentFlags.INSTANCE.getDuplicateConfigurationsEnabled()) {
            restoreExperimental(n, list);
        } else {
            restoreDefault(n, list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.arkivanov.decompose.router.children.ChildItemFactory, com.arkivanov.decompose.router.children.ChildItemFactory<C, T>] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.arkivanov.decompose.router.children.ChildItemFactory, com.arkivanov.decompose.router.children.ChildItemFactory<C, T>] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.arkivanov.decompose.router.children.ChildItemFactory, com.arkivanov.decompose.router.children.ChildItemFactory<C, T>] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15, types: [com.arkivanov.decompose.router.children.ChildItem$Created, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v16, types: [com.arkivanov.decompose.router.children.ChildItem$Created, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v17, types: [com.arkivanov.decompose.router.children.ChildItem$Created, java.lang.Object] */
    private final void restoreDefault(N n, List<SerializableContainer> list) {
        ?? destroyed;
        HashMap hashMap = new HashMap();
        for (T t : this.retainedInstance.getItems()) {
            hashMap.put(((ChildItem.Created) t).getConfiguration(), t);
        }
        HashMap hashMap2 = hashMap;
        this.retainedInstance.getItems().clear();
        for (Pair pair : CollectionsKt.zip(n.getChildren(), list)) {
            ChildNavState childNavState = (ChildNavState) pair.component1();
            SerializableContainer serializableContainer = (SerializableContainer) pair.component2();
            ArrayList<ChildItem<C, T>> arrayList = this.items;
            int i = WhenMappings.$EnumSwitchMapping$0[childNavState.getStatus().ordinal()];
            if (i == 1) {
                destroyed = new ChildItem.Destroyed(childNavState.getConfiguration(), serializableContainer);
            } else if (i == 2) {
                ChildItemFactory<C, T> childItemFactory = this.childItemFactory;
                Object configuration = childNavState.getConfiguration();
                ChildItem.Created created = (ChildItem.Created) hashMap2.remove(childNavState.getConfiguration());
                destroyed = childItemFactory.invoke(configuration, serializableContainer, created != null ? created.getInstanceKeeperDispatcher() : null);
                ((List<ChildItem.Created<C, T>>) this.retainedInstance.getItems()).add(destroyed);
                LifecycleRegistryExtKt.create(destroyed.getLifecycleRegistry());
            } else if (i == 3) {
                ChildItemFactory<C, T> childItemFactory2 = this.childItemFactory;
                Object configuration2 = childNavState.getConfiguration();
                ChildItem.Created created2 = (ChildItem.Created) hashMap2.remove(childNavState.getConfiguration());
                destroyed = childItemFactory2.invoke(configuration2, serializableContainer, created2 != null ? created2.getInstanceKeeperDispatcher() : null);
                ((List<ChildItem.Created<C, T>>) this.retainedInstance.getItems()).add(destroyed);
                destroyed.getBackHandler().start();
                LifecycleRegistryExtKt.start(destroyed.getLifecycleRegistry());
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                ChildItemFactory<C, T> childItemFactory3 = this.childItemFactory;
                Object configuration3 = childNavState.getConfiguration();
                ChildItem.Created created3 = (ChildItem.Created) hashMap2.remove(childNavState.getConfiguration());
                destroyed = childItemFactory3.invoke(configuration3, serializableContainer, created3 != null ? created3.getInstanceKeeperDispatcher() : null);
                ((List<ChildItem.Created<C, T>>) this.retainedInstance.getItems()).add(destroyed);
                destroyed.getBackHandler().start();
                LifecycleRegistryExtKt.resume(destroyed.getLifecycleRegistry());
            }
            arrayList.add((ChildItem) destroyed);
        }
        Collection<ChildItem.Created> values = hashMap2.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (ChildItem.Created created4 : values) {
            created4.getInstanceKeeperDispatcher().destroy();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v15, types: [com.arkivanov.decompose.router.children.ChildItem$Created, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v16, types: [com.arkivanov.decompose.router.children.ChildItem$Created, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v17, types: [com.arkivanov.decompose.router.children.ChildItem$Created, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.arkivanov.decompose.router.children.ChildItemFactory, com.arkivanov.decompose.router.children.ChildItemFactory<C, T>] */
    /* JADX WARN: Type inference failed for: r6v6, types: [com.arkivanov.decompose.router.children.ChildItemFactory, com.arkivanov.decompose.router.children.ChildItemFactory<C, T>] */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.arkivanov.decompose.router.children.ChildItemFactory, com.arkivanov.decompose.router.children.ChildItemFactory<C, T>] */
    private final void restoreExperimental(N n, List<SerializableContainer> list) {
        ?? destroyed;
        ChildItem.Created created;
        ChildItem.Created created2;
        ChildItem.Created created3;
        HashMap hashMap = new HashMap();
        int i = 0;
        int i2 = 0;
        for (T t : this.retainedInstance.getItems()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            hashMap.put(Integer.valueOf(i2), (ChildItem.Created) t);
            i2 = i3;
        }
        final List<ChildNavState<C>> children = n.getChildren();
        final List<ChildItem.Created<C, T>> items = this.retainedInstance.getItems();
        boolean areEqual = Intrinsics.areEqual(new GettingList(children.size(), new Function1<Integer, C>() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$restoreExperimental$$inlined$mapped$1
            public final C invoke(int i4) {
                return (C) ((ChildNavState) children.get(i4)).getConfiguration();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        }), new GettingList(items.size(), new Function1<Integer, C>() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$restoreExperimental$$inlined$mapped$2
            public final C invoke(int i4) {
                return (C) ((ChildItem.Created) items.get(i4)).getConfiguration();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        }));
        this.retainedInstance.getItems().clear();
        for (T t2 : CollectionsKt.zip(n.getChildren(), list)) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) t2;
            ChildNavState childNavState = (ChildNavState) pair.component1();
            SerializableContainer serializableContainer = (SerializableContainer) pair.component2();
            ArrayList<ChildItem<C, T>> arrayList = this.items;
            int i5 = WhenMappings.$EnumSwitchMapping$0[childNavState.getStatus().ordinal()];
            if (i5 != 1) {
                InstanceKeeperDispatcher instanceKeeperDispatcher = null;
                if (i5 == 2) {
                    ChildItemFactory<C, T> childItemFactory = this.childItemFactory;
                    Object configuration = childNavState.getConfiguration();
                    HashMap hashMap2 = areEqual ? hashMap : null;
                    if (hashMap2 != null && (created = (ChildItem.Created) hashMap2.remove(Integer.valueOf(i))) != null) {
                        instanceKeeperDispatcher = created.getInstanceKeeperDispatcher();
                    }
                    destroyed = childItemFactory.invoke(configuration, serializableContainer, instanceKeeperDispatcher);
                    ((List<ChildItem.Created<C, T>>) this.retainedInstance.getItems()).add(destroyed);
                    LifecycleRegistryExtKt.create(destroyed.getLifecycleRegistry());
                } else if (i5 == 3) {
                    ChildItemFactory<C, T> childItemFactory2 = this.childItemFactory;
                    Object configuration2 = childNavState.getConfiguration();
                    HashMap hashMap3 = areEqual ? hashMap : null;
                    if (hashMap3 != null && (created2 = (ChildItem.Created) hashMap3.remove(Integer.valueOf(i))) != null) {
                        instanceKeeperDispatcher = created2.getInstanceKeeperDispatcher();
                    }
                    destroyed = childItemFactory2.invoke(configuration2, serializableContainer, instanceKeeperDispatcher);
                    ((List<ChildItem.Created<C, T>>) this.retainedInstance.getItems()).add(destroyed);
                    destroyed.getBackHandler().start();
                    LifecycleRegistryExtKt.start(destroyed.getLifecycleRegistry());
                } else if (i5 != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    ChildItemFactory<C, T> childItemFactory3 = this.childItemFactory;
                    Object configuration3 = childNavState.getConfiguration();
                    HashMap hashMap4 = areEqual ? hashMap : null;
                    if (hashMap4 != null && (created3 = (ChildItem.Created) hashMap4.remove(Integer.valueOf(i))) != null) {
                        instanceKeeperDispatcher = created3.getInstanceKeeperDispatcher();
                    }
                    destroyed = childItemFactory3.invoke(configuration3, serializableContainer, instanceKeeperDispatcher);
                    ((List<ChildItem.Created<C, T>>) this.retainedInstance.getItems()).add(destroyed);
                    destroyed.getBackHandler().start();
                    LifecycleRegistryExtKt.resume(destroyed.getLifecycleRegistry());
                }
            } else {
                destroyed = new ChildItem.Destroyed(childNavState.getConfiguration(), serializableContainer);
            }
            arrayList.add((ChildItem) destroyed);
            i = i4;
        }
        Collection<ChildItem.Created> values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (ChildItem.Created created4 : values) {
            created4.getInstanceKeeperDispatcher().destroy();
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

    public final List<SerializableContainer> saveChildState() {
        SerializableContainer savedState;
        ArrayList<ChildItem<C, T>> arrayList = this.items;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ChildItem childItem = (ChildItem) it.next();
            if (childItem instanceof ChildItem.Created) {
                savedState = ((ChildItem.Created) childItem).getStateKeeperDispatcher().save();
            } else if (!(childItem instanceof ChildItem.Destroyed)) {
                throw new NoWhenBranchMatchedException();
            } else {
                savedState = ((ChildItem.Destroyed) childItem).getSavedState();
            }
            arrayList2.add(savedState);
        }
        return arrayList2;
    }

    public final void navigate(N navState) {
        Intrinsics.checkNotNullParameter(navState, "navState");
        m8015switch(navState.getChildren());
        this.navState = navState;
    }

    /* renamed from: switch  reason: not valid java name */
    private final void m8015switch(List<? extends ChildNavState<? extends C>> list) {
        if (DecomposeExperimentFlags.INSTANCE.getDuplicateConfigurationsEnabled()) {
            switchExperimental(list);
        } else {
            switchDefault(list);
        }
    }

    private final void switchDefault(List<? extends ChildNavState<? extends C>> list) {
        List<? extends ChildNavState<? extends C>> list2 = list;
        HashSet hashSet = new HashSet();
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            hashSet.add(((ChildNavState) it.next()).getConfiguration());
        }
        HashSet hashSet2 = hashSet;
        if (hashSet2.size() != list.size()) {
            StringBuilder sb = new StringBuilder("Configurations must be unique: ");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(((ChildNavState) it2.next()).getConfiguration());
            }
            throw new IllegalStateException(sb.append(arrayList).append('.').toString().toString());
        }
        ArrayList<ChildItem<C, T>> arrayList2 = this.items;
        Map<C, ? extends ChildItem<? extends C, ? extends T>> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (T t : arrayList2) {
            linkedHashMap.put(((ChildItem) t).getConfiguration(), t);
        }
        List<Pair<ChildItem<C, T>, ChildNavState.Status>> prepareNewItemsDefault = prepareNewItemsDefault(list, linkedHashMap);
        destroyOldItemsDefault(hashSet2, linkedHashMap.values());
        processNewItems(prepareNewItemsDefault);
    }

    private final List<Pair<ChildItem<C, T>, ChildNavState.Status>> prepareNewItemsDefault(List<? extends ChildNavState<? extends C>> list, Map<C, ? extends ChildItem<? extends C, ? extends T>> map) {
        Pair pair;
        Pair pair2;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ChildNavState childNavState = (ChildNavState) it.next();
            ArrayList arrayList2 = arrayList;
            ChildItem<? extends C, ? extends T> childItem = map.get(childNavState.getConfiguration());
            if (childItem instanceof ChildItem.Created) {
                pair = TuplesKt.to(childItem, childNavState.getStatus());
            } else if (childItem instanceof ChildItem.Destroyed) {
                int i = WhenMappings.$EnumSwitchMapping$0[childNavState.getStatus().ordinal()];
                if (i == 1) {
                    pair = TuplesKt.to(childItem, childNavState.getStatus());
                } else if (i != 2 && i != 3 && i != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    ChildItem.Created invoke$default = ChildItemFactory.DefaultImpls.invoke$default(this.childItemFactory, childNavState.getConfiguration(), ((ChildItem.Destroyed) childItem).getSavedState(), null, 4, null);
                    LifecycleRegistryExtKt.create(invoke$default.getLifecycleRegistry());
                    pair2 = new Pair(invoke$default, childNavState.getStatus());
                    pair = pair2;
                }
            } else if (childItem != null) {
                throw new NoWhenBranchMatchedException();
            } else {
                int i2 = WhenMappings.$EnumSwitchMapping$0[childNavState.getStatus().ordinal()];
                if (i2 == 1) {
                    pair = TuplesKt.to(new ChildItem.Destroyed(childNavState.getConfiguration(), null, 2, null), childNavState.getStatus());
                } else if (i2 != 2 && i2 != 3 && i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    ChildItem.Created invoke$default2 = ChildItemFactory.DefaultImpls.invoke$default(this.childItemFactory, childNavState.getConfiguration(), null, null, 6, null);
                    LifecycleRegistryExtKt.create(invoke$default2.getLifecycleRegistry());
                    pair2 = new Pair(invoke$default2, childNavState.getStatus());
                    pair = pair2;
                }
            }
            arrayList2.add(pair);
        }
        return arrayList;
    }

    private final void destroyOldItemsDefault(Set<? extends C> set, Collection<? extends ChildItem<? extends C, ? extends T>> collection) {
        for (ChildItem<? extends C, ? extends T> childItem : collection) {
            ChildItem.Created<?, ?> created = childItem instanceof ChildItem.Created ? (ChildItem.Created) childItem : null;
            if (created != null && !set.contains(((ChildItem.Created) childItem).getConfiguration())) {
                destroy(created);
            }
        }
    }

    private final void switchExperimental(List<? extends ChildNavState<? extends C>> list) {
        Map<Object, ? extends ChildNavState<? extends C>> keyed = UtilsKt.keyed(list, new PropertyReference1Impl() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$switchExperimental$newKeyedStates$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ChildNavState) obj).getConfiguration();
            }
        });
        Map<Object, ? extends ChildItem<? extends C, ? extends T>> keyed2 = UtilsKt.keyed(this.items, new PropertyReference1Impl() { // from class: com.arkivanov.decompose.router.children.ChildrenNavigator$switchExperimental$oldKeyedItems$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ChildItem) obj).getConfiguration();
            }
        });
        List<Pair<ChildItem<C, T>, ChildNavState.Status>> prepareNewItemsExperimental = prepareNewItemsExperimental(keyed, keyed2);
        destroyOldItemsExperimental(keyed.keySet(), keyed2);
        processNewItems(prepareNewItemsExperimental);
    }

    private final List<Pair<ChildItem<C, T>, ChildNavState.Status>> prepareNewItemsExperimental(Map<Object, ? extends ChildNavState<? extends C>> map, Map<Object, ? extends ChildItem<? extends C, ? extends T>> map2) {
        Pair pair;
        Pair pair2;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Object, ? extends ChildNavState<? extends C>> entry : map.entrySet()) {
            Object key = entry.getKey();
            ChildNavState<? extends C> value = entry.getValue();
            ArrayList arrayList2 = arrayList;
            ChildItem<? extends C, ? extends T> childItem = map2.get(key);
            if (childItem instanceof ChildItem.Created) {
                pair = TuplesKt.to(childItem, value.getStatus());
            } else if (childItem instanceof ChildItem.Destroyed) {
                int i = WhenMappings.$EnumSwitchMapping$0[value.getStatus().ordinal()];
                if (i == 1) {
                    pair = TuplesKt.to(childItem, value.getStatus());
                } else if (i != 2 && i != 3 && i != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    ChildItem.Created invoke$default = ChildItemFactory.DefaultImpls.invoke$default(this.childItemFactory, value.getConfiguration(), ((ChildItem.Destroyed) childItem).getSavedState(), null, 4, null);
                    LifecycleRegistryExtKt.create(invoke$default.getLifecycleRegistry());
                    pair2 = new Pair(invoke$default, value.getStatus());
                    pair = pair2;
                }
            } else if (childItem != null) {
                throw new NoWhenBranchMatchedException();
            } else {
                int i2 = WhenMappings.$EnumSwitchMapping$0[value.getStatus().ordinal()];
                if (i2 == 1) {
                    pair = TuplesKt.to(new ChildItem.Destroyed(value.getConfiguration(), null, 2, null), value.getStatus());
                } else if (i2 != 2 && i2 != 3 && i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    ChildItem.Created invoke$default2 = ChildItemFactory.DefaultImpls.invoke$default(this.childItemFactory, value.getConfiguration(), null, null, 6, null);
                    LifecycleRegistryExtKt.create(invoke$default2.getLifecycleRegistry());
                    pair2 = new Pair(invoke$default2, value.getStatus());
                    pair = pair2;
                }
            }
            arrayList2.add(pair);
        }
        return arrayList;
    }

    private final void destroyOldItemsExperimental(Set<? extends Object> set, Map<Object, ? extends ChildItem<? extends C, ? extends T>> map) {
        for (Map.Entry<Object, ? extends ChildItem<? extends C, ? extends T>> entry : map.entrySet()) {
            Object key = entry.getKey();
            ChildItem<? extends C, ? extends T> value = entry.getValue();
            ChildItem.Created<?, ?> created = value instanceof ChildItem.Created ? (ChildItem.Created) value : null;
            if (created != null && !set.contains(key)) {
                destroy(created);
            }
        }
    }

    private final void processNewItems(List<? extends Pair<? extends ChildItem<? extends C, ? extends T>, ? extends ChildNavState.Status>> list) {
        this.items.clear();
        this.retainedInstance.getItems().clear();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ChildItem<C, T> childItem = (ChildItem) pair.component1();
            ChildNavState.Status status = (ChildNavState.Status) pair.component2();
            ArrayList<ChildItem<C, T>> arrayList = this.items;
            if (childItem instanceof ChildItem.Created) {
                childItem = processNewItem((ChildItem.Created) childItem, status);
            } else if (!(childItem instanceof ChildItem.Destroyed)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(childItem);
        }
    }

    private final ChildItem<C, T> processNewItem(ChildItem.Created<? extends C, ? extends T> created, ChildNavState.Status status) {
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            SerializableContainer save = created.getStateKeeperDispatcher().save();
            destroy(created);
            return new ChildItem.Destroyed(created.getConfiguration(), save);
        } else if (i == 2) {
            this.retainedInstance.getItems().add(created);
            if (created.getLifecycleRegistry().getState() != Lifecycle.State.CREATED) {
                created.getBackHandler().stop();
                LifecycleRegistryExtKt.stop(created.getLifecycleRegistry());
            }
            return created;
        } else if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            this.retainedInstance.getItems().add(created);
            if (created.getLifecycleRegistry().getState() != Lifecycle.State.RESUMED) {
                created.getBackHandler().start();
                LifecycleRegistryExtKt.resume(created.getLifecycleRegistry());
            }
            return created;
        } else {
            this.retainedInstance.getItems().add(created);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChildrenNavigator.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u0002*\b\b\u0004\u0010\u0003*\u00020\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildrenNavigator$RetainedInstance;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "<init>", "()V", FirebaseAnalytics.Param.ITEMS, "", "Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "getItems", "()Ljava/util/List;", "onDestroy", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RetainedInstance<C, T> implements InstanceKeeper.Instance {
        private final List<ChildItem.Created<C, T>> items = new ArrayList();

        public final List<ChildItem.Created<C, T>> getItems() {
            return this.items;
        }

        @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper.Instance
        public void onDestroy() {
            Iterator<T> it = this.items.iterator();
            while (it.hasNext()) {
                ((ChildItem.Created) it.next()).getInstanceKeeperDispatcher().destroy();
            }
            this.items.clear();
        }
    }
}
