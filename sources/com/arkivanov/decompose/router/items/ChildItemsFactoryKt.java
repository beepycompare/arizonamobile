package com.arkivanov.decompose.router.items;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.GenericComponentContext;
import com.arkivanov.decompose.router.children.ChildController;
import com.arkivanov.decompose.router.children.NavStateSaver;
import com.arkivanov.decompose.router.children.NavStateSaverKt;
import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.items.ItemsNavigation;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
/* compiled from: ChildItemsFactory.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a¬\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005\"\b\b\u0001\u0010\u0002*\u00020\u0006\"\b\b\u0002\u0010\u0003*\u00020\u0006*\u0002H\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102'\u0010\u0011\u001a#\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0012H\u0007¢\u0006\u0002\u0010\u0016\u001a²\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005\"\b\b\u0001\u0010\u0002*\u00020\u0006\"\b\b\u0002\u0010\u0003*\u00020\u0006*\u0002H\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t0\b2\u0014\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000e\u0018\u00010\u00182\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102'\u0010\u0011\u001a#\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0012H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"childItems", "Lcom/arkivanov/decompose/router/items/LazyChildItems;", "C", ExifInterface.GPS_DIRECTION_TRUE, "Ctx", "Lcom/arkivanov/decompose/GenericComponentContext;", "", "source", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "Lcom/arkivanov/decompose/router/items/ItemsNavigation$Event;", "serializer", "Lkotlinx/serialization/KSerializer;", "initialItems", "Lkotlin/Function0;", "Lcom/arkivanov/decompose/router/items/Items;", "key", "", "childFactory", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "configuration", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/router/items/LazyChildItems;", "stateSaver", "Lcom/arkivanov/decompose/router/children/NavStateSaver;", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lcom/arkivanov/decompose/router/children/NavStateSaver;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/router/items/LazyChildItems;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildItemsFactoryKt {
    public static /* synthetic */ LazyChildItems childItems$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, KSerializer kSerializer, Function0 function0, String str, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "DefaultChildItems";
        }
        return childItems(genericComponentContext, navigationSource, kSerializer, function0, str, function2);
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T> LazyChildItems<C, T> childItems(Ctx ctx, NavigationSource<ItemsNavigation.Event<C>> source, KSerializer<C> kSerializer, Function0<Items<C>> initialItems, String key, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialItems, "initialItems");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        return childItems(ctx, source, kSerializer != null ? NavStateSaverKt.NavStateSaver(Items.Companion.serializer(kSerializer)) : null, initialItems, key, childFactory);
    }

    public static /* synthetic */ LazyChildItems childItems$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, NavStateSaver navStateSaver, Function0 function0, String str, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "DefaultChildItems";
        }
        return childItems(genericComponentContext, navigationSource, navStateSaver, function0, str, function2);
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T> LazyChildItems<C, T> childItems(Ctx ctx, NavigationSource<ItemsNavigation.Event<C>> source, NavStateSaver<Items<C>> navStateSaver, Function0<Items<C>> initialItems, String key, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialItems, "initialItems");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        ItemsController itemsController = new ItemsController(new ChildController(ctx, key, childFactory));
        final Cancellation init = itemsController.init(source, initialItems, key, ctx.getStateKeeper(), navStateSaver);
        Lifecycle lifecycle = ctx.getLifecycle();
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            init.cancel();
        } else {
            lifecycle.subscribe(new Lifecycle.Callbacks() { // from class: com.arkivanov.decompose.router.items.ChildItemsFactoryKt$childItems$$inlined$doOnDestroy$1
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
                    Cancellation.this.cancel();
                }
            });
        }
        return new DefaultLazyChildItems(itemsController);
    }
}
