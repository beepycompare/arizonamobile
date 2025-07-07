package com.arkivanov.decompose.router.stack;

import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.stack.StackNavigation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StackNavigation.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0004:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/stack/StackNavigation;", "C", "", "Lcom/arkivanov/decompose/router/stack/StackNavigator;", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "Lcom/arkivanov/decompose/router/stack/StackNavigation$Event;", "Event", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface StackNavigation<C> extends StackNavigator<C>, NavigationSource<Event<C>> {

    /* compiled from: StackNavigation.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0002B|\u0012-\u0010\u0003\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004\u0012D\b\u0002\u0010\t\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u000e\u0010\u000fR8\u0010\u0003\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011RM\u0010\t\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/arkivanov/decompose/router/stack/StackNavigation$Event;", "C", "", "transformer", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "stack", "onComplete", "Lkotlin/Function2;", "newStack", "oldStack", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getTransformer", "()Lkotlin/jvm/functions/Function1;", "getOnComplete", "()Lkotlin/jvm/functions/Function2;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Event<C> {
        private final Function2<List<? extends C>, List<? extends C>, Unit> onComplete;
        private final Function1<List<? extends C>, List<C>> transformer;

        /* JADX WARN: Multi-variable type inference failed */
        public Event(Function1<? super List<? extends C>, ? extends List<? extends C>> transformer, Function2<? super List<? extends C>, ? super List<? extends C>, Unit> onComplete) {
            Intrinsics.checkNotNullParameter(transformer, "transformer");
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            this.transformer = transformer;
            this.onComplete = onComplete;
        }

        public final Function1<List<? extends C>, List<C>> getTransformer() {
            return this.transformer;
        }

        public /* synthetic */ Event(Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function1, (i & 2) != 0 ? new Function2() { // from class: com.arkivanov.decompose.router.stack.StackNavigation$Event$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit _init_$lambda$0;
                    _init_$lambda$0 = StackNavigation.Event._init_$lambda$0((List) obj, (List) obj2);
                    return _init_$lambda$0;
                }
            } : function2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _init_$lambda$0(List list, List list2) {
            Intrinsics.checkNotNullParameter(list, "<unused var>");
            Intrinsics.checkNotNullParameter(list2, "<unused var>");
            return Unit.INSTANCE;
        }

        public final Function2<List<? extends C>, List<? extends C>, Unit> getOnComplete() {
            return this.onComplete;
        }
    }
}
