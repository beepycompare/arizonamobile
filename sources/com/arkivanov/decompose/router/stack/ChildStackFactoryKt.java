package com.arkivanov.decompose.router.stack;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.GenericComponentContext;
import com.arkivanov.decompose.router.children.ChildrenFactoryKt;
import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.stack.StackNavigation;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.SerializableContainerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
/* compiled from: ChildStackFactory.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aº\u0001\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\b\b\u0001\u0010\u0003*\u00020\u0007\"\b\b\u0002\u0010\u0004*\u00020\u0007*\u0002H\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132'\u0010\u0014\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\u0015¢\u0006\u0002\u0010\u0019\u001a®\u0001\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\b\b\u0001\u0010\u0003*\u00020\u0007\"\b\b\u0002\u0010\u0004*\u00020\u0007*\u0002H\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\f2\u0006\u0010\u001a\u001a\u0002H\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132'\u0010\u0014\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\u0015¢\u0006\u0002\u0010\u001b\u001aâ\u0001\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\b\b\u0001\u0010\u0003*\u00020\u0007\"\b\b\u0002\u0010\u0004*\u00020\u0007*\u0002H\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n0\t2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u000f0\u000e2\u001a\u0010\u001c\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u000f0\u001d2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132'\u0010\u0014\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\u0015¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"childStack", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "C", ExifInterface.GPS_DIRECTION_TRUE, "Ctx", "Lcom/arkivanov/decompose/GenericComponentContext;", "", "source", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "Lcom/arkivanov/decompose/router/stack/StackNavigation$Event;", "serializer", "Lkotlinx/serialization/KSerializer;", "initialStack", "Lkotlin/Function0;", "", "key", "", "handleBackButton", "", "childFactory", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "configuration", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "initialConfiguration", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlinx/serialization/KSerializer;Ljava/lang/Object;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "saveStack", "Lkotlin/Function1;", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "restoreStack", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildStackFactoryKt {
    public static /* synthetic */ Value childStack$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, KSerializer kSerializer, Function0 function0, String str, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "DefaultChildStack";
        }
        String str2 = str;
        if ((i & 16) != 0) {
            z = false;
        }
        return childStack(genericComponentContext, navigationSource, kSerializer, function0, str2, z, (Function2<? super C, ? super GenericComponentContext, ? extends T>) function2);
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T> Value<ChildStack<C, T>> childStack(Ctx ctx, NavigationSource<StackNavigation.Event<C>> source, final KSerializer<C> kSerializer, Function0<? extends List<? extends C>> initialStack, String key, boolean z, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialStack, "initialStack");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        return childStack(ctx, source, initialStack, new Function1() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SerializableContainer childStack$lambda$0;
                childStack$lambda$0 = ChildStackFactoryKt.childStack$lambda$0(KSerializer.this, (List) obj);
                return childStack$lambda$0;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List childStack$lambda$1;
                childStack$lambda$1 = ChildStackFactoryKt.childStack$lambda$1(KSerializer.this, (SerializableContainer) obj);
                return childStack$lambda$1;
            }
        }, key, z, childFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer childStack$lambda$0(KSerializer kSerializer, List stack) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        if (kSerializer != null) {
            return SerializableContainerKt.SerializableContainer(stack, BuiltinSerializersKt.ListSerializer(kSerializer));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List childStack$lambda$1(KSerializer kSerializer, SerializableContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (kSerializer != null) {
            return (List) SerializableContainerKt.consumeRequired(container, BuiltinSerializersKt.ListSerializer(kSerializer));
        }
        return null;
    }

    public static /* synthetic */ Value childStack$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, KSerializer kSerializer, Object obj, String str, boolean z, Function2 function2, int i, Object obj2) {
        if ((i & 8) != 0) {
            str = "DefaultChildStack";
        }
        String str2 = str;
        if ((i & 16) != 0) {
            z = false;
        }
        return childStack(genericComponentContext, navigationSource, kSerializer, obj, str2, z, function2);
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T> Value<ChildStack<C, T>> childStack(Ctx ctx, NavigationSource<StackNavigation.Event<C>> source, KSerializer<C> kSerializer, final C initialConfiguration, String key, boolean z, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialConfiguration, "initialConfiguration");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        return childStack((GenericComponentContext) ctx, (NavigationSource) source, (KSerializer) kSerializer, new Function0() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List listOf;
                listOf = CollectionsKt.listOf(initialConfiguration);
                return listOf;
            }
        }, key, z, (Function2) childFactory);
    }

    public static /* synthetic */ Value childStack$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, Function0 function0, Function1 function1, Function1 function12, String str, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 16) != 0) {
            str = "DefaultChildStack";
        }
        String str2 = str;
        if ((i & 32) != 0) {
            z = false;
        }
        return childStack(genericComponentContext, navigationSource, function0, function1, function12, str2, z, function2);
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T> Value<ChildStack<C, T>> childStack(Ctx ctx, NavigationSource<StackNavigation.Event<C>> source, final Function0<? extends List<? extends C>> initialStack, final Function1<? super List<? extends C>, SerializableContainer> saveStack, final Function1<? super SerializableContainer, ? extends List<? extends C>> restoreStack, String key, final boolean z, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Value<ChildStack<C, T>> children;
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialStack, "initialStack");
        Intrinsics.checkNotNullParameter(saveStack, "saveStack");
        Intrinsics.checkNotNullParameter(restoreStack, "restoreStack");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        children = ChildrenFactoryKt.children(ctx, source, key, new Function0() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StackNavState childStack$lambda$3;
                childStack$lambda$3 = ChildStackFactoryKt.childStack$lambda$3(Function0.this);
                return childStack$lambda$3;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SerializableContainer childStack$lambda$4;
                childStack$lambda$4 = ChildStackFactoryKt.childStack$lambda$4(Function1.this, (StackNavState) obj);
                return childStack$lambda$4;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                StackNavState childStack$lambda$5;
                childStack$lambda$5 = ChildStackFactoryKt.childStack$lambda$5(Function1.this, initialStack, (SerializableContainer) obj);
                return childStack$lambda$5;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                StackNavState childStack$lambda$6;
                childStack$lambda$6 = ChildStackFactoryKt.childStack$lambda$6((StackNavState) obj, (StackNavigation.Event) obj2);
                return childStack$lambda$6;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                ChildStack childStack$lambda$7;
                childStack$lambda$7 = ChildStackFactoryKt.childStack$lambda$7((StackNavState) obj, (List) obj2);
                return childStack$lambda$7;
            }
        }, (r26 & 128) != 0 ? new Function2() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit children$lambda$4;
                children$lambda$4 = ChildrenFactoryKt.children$lambda$4((NavState) obj, (NavState) obj2);
                return children$lambda$4;
            }
        } : null, (r26 & 256) != 0 ? new Function3() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit children$lambda$5;
                children$lambda$5 = ChildrenFactoryKt.children$lambda$5(obj, (NavState) obj2, (NavState) obj3);
                return children$lambda$5;
            }
        } : new Function3() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit childStack$lambda$8;
                childStack$lambda$8 = ChildStackFactoryKt.childStack$lambda$8((StackNavigation.Event) obj, (StackNavState) obj2, (StackNavState) obj3);
                return childStack$lambda$8;
            }
        }, (r26 & 512) != 0 ? new Function1() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$children$8
            /* JADX WARN: Incorrect types in method signature: (TN;)Ljava/lang/Void; */
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(NavState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        } : new Function1() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Function0 childStack$lambda$10;
                childStack$lambda$10 = ChildStackFactoryKt.childStack$lambda$10(z, (StackNavState) obj);
                return childStack$lambda$10;
            }
        }, childFactory);
        return children;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackNavState childStack$lambda$3(Function0 function0) {
        return new StackNavState((List) function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer childStack$lambda$4(Function1 function1, StackNavState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (SerializableContainer) function1.invoke(it.getConfigurations());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackNavState childStack$lambda$5(Function1 function1, Function0 function0, SerializableContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        List list = (List) function1.invoke(container);
        if (list == null) {
            list = (List) function0.invoke();
        }
        return new StackNavState(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackNavState childStack$lambda$6(StackNavState state, StackNavigation.Event event) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(event, "event");
        return new StackNavState((List) event.getTransformer().invoke(state.getConfigurations()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChildStack childStack$lambda$7(StackNavState stackNavState, List children) {
        Intrinsics.checkNotNullParameter(stackNavState, "<unused var>");
        Intrinsics.checkNotNullParameter(children, "children");
        return new ChildStack((Child.Created) CollectionsKt.last((List<? extends Object>) children), CollectionsKt.dropLast(children, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childStack$lambda$8(StackNavigation.Event event, StackNavState newState, StackNavState oldState) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        event.getOnComplete().invoke(newState.getConfigurations(), oldState.getConfigurations());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 childStack$lambda$10(boolean z, final StackNavState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!z || state.getConfigurations().size() <= 1) {
            return null;
        }
        return new Function0() { // from class: com.arkivanov.decompose.router.stack.ChildStackFactoryKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StackNavState childStack$lambda$10$lambda$9;
                childStack$lambda$10$lambda$9 = ChildStackFactoryKt.childStack$lambda$10$lambda$9(StackNavState.this);
                return childStack$lambda$10$lambda$9;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackNavState childStack$lambda$10$lambda$9(StackNavState stackNavState) {
        return new StackNavState(CollectionsKt.dropLast(stackNavState.getConfigurations(), 1));
    }
}
