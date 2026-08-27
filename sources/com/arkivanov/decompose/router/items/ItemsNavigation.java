package com.arkivanov.decompose.router.items;

import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.items.ItemsNavigation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ItemsNavigation.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0004:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/items/ItemsNavigation;", "C", "", "Lcom/arkivanov/decompose/router/items/ItemsNavigator;", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "Lcom/arkivanov/decompose/router/items/ItemsNavigation$Event;", "Event", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ItemsNavigation<C> extends ItemsNavigator<C>, NavigationSource<Event<C>> {

    /* compiled from: ItemsNavigation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0002Bm\u0012\u001e\u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004\u0012D\b\u0002\u0010\u0006\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eR)\u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010RM\u0010\u0006\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/arkivanov/decompose/router/items/ItemsNavigation$Event;", "C", "", "transformer", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/router/items/Items;", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "newItems", "oldItems", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getTransformer", "()Lkotlin/jvm/functions/Function1;", "getOnComplete", "()Lkotlin/jvm/functions/Function2;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Event<C> {
        private final Function2<Items<C>, Items<C>, Unit> onComplete;
        private final Function1<Items<C>, Items<C>> transformer;

        /* JADX WARN: Multi-variable type inference failed */
        public Event(Function1<? super Items<C>, Items<C>> transformer, Function2<? super Items<C>, ? super Items<C>, Unit> onComplete) {
            Intrinsics.checkNotNullParameter(transformer, "transformer");
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            this.transformer = transformer;
            this.onComplete = onComplete;
        }

        public final Function1<Items<C>, Items<C>> getTransformer() {
            return this.transformer;
        }

        public /* synthetic */ Event(Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function1, (i & 2) != 0 ? new Function2() { // from class: com.arkivanov.decompose.router.items.ItemsNavigation$Event$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemsNavigation.Event._init_$lambda$0((Items) obj, (Items) obj2);
                }
            } : function2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit _init_$lambda$0(Items items, Items items2) {
            Intrinsics.checkNotNullParameter(items, "<unused var>");
            Intrinsics.checkNotNullParameter(items2, "<unused var>");
            return Unit.INSTANCE;
        }

        public final Function2<Items<C>, Items<C>, Unit> getOnComplete() {
            return this.onComplete;
        }
    }
}
