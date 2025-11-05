package com.arkivanov.decompose.router.items;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.router.items.Items;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultLazyChildItems.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u000e\u001a\u00020\u000f2\u001e\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0016\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015Jm\u0010\u0016\u001a\u00020\u00122\u001e\u0010\u0017\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00112B\u0010\u0019\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00120\u001aH\u0096\u0001R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/arkivanov/decompose/router/items/DefaultLazyChildItems;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/router/items/LazyChildItems;", "Lcom/arkivanov/decompose/router/items/ItemsNavigator;", "controller", "Lcom/arkivanov/decompose/router/items/ItemsController;", "<init>", "(Lcom/arkivanov/decompose/router/items/ItemsController;)V", "value", "Lcom/arkivanov/decompose/router/items/ChildItems;", "getValue", "()Lcom/arkivanov/decompose/router/items/ChildItems;", "subscribe", "Lcom/arkivanov/decompose/Cancellation;", "observer", "Lkotlin/Function1;", "", "get", "configuration", "(Ljava/lang/Object;)Ljava/lang/Object;", "navigate", "transformer", "Lcom/arkivanov/decompose/router/items/Items;", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "newItems", "oldItems", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultLazyChildItems<C, T> extends LazyChildItems<C, T> implements ItemsNavigator<C> {
    private final ItemsController<C, T> controller;

    @Override // com.arkivanov.decompose.router.items.LazyChildItems, com.arkivanov.decompose.router.items.ItemsNavigator
    public void navigate(Function1<? super Items<C>, Items<C>> transformer, Function2<? super Items<C>, ? super Items<C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.controller.navigate(transformer, onComplete);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultLazyChildItems(ItemsController<C, ? extends T> controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.controller = controller;
    }

    @Override // com.arkivanov.decompose.value.Value
    public ChildItems<C, T> getValue() {
        return this.controller.getState().getValue();
    }

    @Override // com.arkivanov.decompose.value.Value
    public Cancellation subscribe(Function1<? super ChildItems<C, ? extends T>, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.controller.getState().subscribe(observer);
    }

    @Override // com.arkivanov.decompose.router.items.LazyChildItems
    public T get(final C configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Pair<T, Items.ActiveLifecycleState> pair = getValue().getActiveItems().get(configuration);
        if (pair == null) {
            navigate(new Function1<Items<C>, Items<C>>() { // from class: com.arkivanov.decompose.router.items.DefaultLazyChildItems$get$$inlined$setActiveItems$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((Items) ((Items) obj));
                }

                public final Items<C> invoke(Items<C> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Items.copy$default(it, null, MapsKt.plus(it.getActiveItems(), TuplesKt.to(configuration, Items.ActiveLifecycleState.CREATED)), 1, null);
                }
            }, new ItemsNavigatorExtKt$setActiveItems$$inlined$setActiveItems$1());
            pair = getValue().getActiveItems().get(configuration);
        }
        if (pair == null) {
            throw new IllegalStateException(("Component was not created for " + configuration + ". Make sure you are not calling get(...) when navigation is already in progress (e.g. recursively). Also make sure you are not removing/destroying the component during its instantiation.").toString());
        }
        return pair.getFirst();
    }
}
