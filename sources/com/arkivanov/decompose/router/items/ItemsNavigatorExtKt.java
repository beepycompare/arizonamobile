package com.arkivanov.decompose.router.items;

import com.arkivanov.decompose.router.items.Items;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ItemsNavigatorExt.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00070\u0006H\u0007\u001a\u0088\u0001\u0010\b\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042 \b\u0004\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n0\u00062D\b\u0004\u0010\u000b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\fH\u0087\bø\u0001\u0000\u001aB\u0010\b\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042 \b\u0004\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n0\u0006H\u0087\bø\u0001\u0000\u001a\u0094\u0001\u0010\u0011\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042,\b\u0004\u0010\u0012\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00140\u00130\u00062D\b\u0004\u0010\u000b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\fH\u0087\bø\u0001\u0000\u001aN\u0010\u0011\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042,\b\u0004\u0010\u0012\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00140\u00130\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"navigate", "", "C", "", "Lcom/arkivanov/decompose/router/items/ItemsNavigator;", "transformer", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/router/items/Items;", "setItems", "items", "", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "newItems", "oldItems", "setActiveItems", "activeItems", "", "Lcom/arkivanov/decompose/router/items/Items$ActiveLifecycleState;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ItemsNavigatorExtKt {
    public static final <C> void navigate(ItemsNavigator<C> itemsNavigator, Function1<? super Items<C>, Items<C>> transformer) {
        Intrinsics.checkNotNullParameter(itemsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        itemsNavigator.navigate(transformer, new Function2() { // from class: com.arkivanov.decompose.router.items.ItemsNavigatorExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit navigate$lambda$0;
                navigate$lambda$0 = ItemsNavigatorExtKt.navigate$lambda$0((Items) obj, (Items) obj2);
                return navigate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$0(Items items, Items items2) {
        Intrinsics.checkNotNullParameter(items, "<unused var>");
        Intrinsics.checkNotNullParameter(items2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <C> void setItems(ItemsNavigator<C> itemsNavigator, Function1<? super List<? extends C>, ? extends List<? extends C>> items, final Function2<? super Items<C>, ? super Items<C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(itemsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        itemsNavigator.navigate(new ItemsNavigatorExtKt$setItems$1(items), new Function2<Items<C>, Items<C>, Unit>() { // from class: com.arkivanov.decompose.router.items.ItemsNavigatorExtKt$setItems$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                invoke((Items) ((Items) obj), (Items) ((Items) obj2));
                return Unit.INSTANCE;
            }

            public final void invoke(Items<C> newItems, Items<C> oldItems) {
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                Intrinsics.checkNotNullParameter(oldItems, "oldItems");
                onComplete.invoke(newItems, oldItems);
            }
        });
    }

    public static final <C> void setActiveItems(ItemsNavigator<C> itemsNavigator, Function1<? super Map<C, ? extends Items.ActiveLifecycleState>, ? extends Map<C, ? extends Items.ActiveLifecycleState>> activeItems, final Function2<? super Items<C>, ? super Items<C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(itemsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(activeItems, "activeItems");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        itemsNavigator.navigate(new ItemsNavigatorExtKt$setActiveItems$1(activeItems), new Function2<Items<C>, Items<C>, Unit>() { // from class: com.arkivanov.decompose.router.items.ItemsNavigatorExtKt$setActiveItems$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                invoke((Items) ((Items) obj), (Items) ((Items) obj2));
                return Unit.INSTANCE;
            }

            public final void invoke(Items<C> newItems, Items<C> oldItems) {
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                Intrinsics.checkNotNullParameter(oldItems, "oldItems");
                onComplete.invoke(newItems, oldItems);
            }
        });
    }

    public static final <C> void setItems(ItemsNavigator<C> itemsNavigator, Function1<? super List<? extends C>, ? extends List<? extends C>> items) {
        Intrinsics.checkNotNullParameter(itemsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        itemsNavigator.navigate(new ItemsNavigatorExtKt$setItems$1(items), new Function2<Items<C>, Items<C>, Unit>() { // from class: com.arkivanov.decompose.router.items.ItemsNavigatorExtKt$setItems$$inlined$setItems$1
            public final void invoke(Items<C> newItems, Items<C> oldItems) {
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                Intrinsics.checkNotNullParameter(oldItems, "oldItems");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                invoke((Items) ((Items) obj), (Items) ((Items) obj2));
                return Unit.INSTANCE;
            }
        });
    }

    public static final <C> void setActiveItems(ItemsNavigator<C> itemsNavigator, Function1<? super Map<C, ? extends Items.ActiveLifecycleState>, ? extends Map<C, ? extends Items.ActiveLifecycleState>> activeItems) {
        Intrinsics.checkNotNullParameter(itemsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(activeItems, "activeItems");
        itemsNavigator.navigate(new ItemsNavigatorExtKt$setActiveItems$1(activeItems), new ItemsNavigatorExtKt$setActiveItems$$inlined$setActiveItems$1());
    }
}
