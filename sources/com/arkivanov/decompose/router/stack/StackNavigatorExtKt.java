package com.arkivanov.decompose.router.stack;

import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StackNavigatorExt.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u001aI\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042-\u0010\u0005\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00070\u0006\u001a=\u0010\u000b\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\f\u001a\u0002H\u00022\u000e\b\u0006\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aR\u0010\u0010\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\f\u001a\u0002H\u00022#\b\u0006\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a=\u0010\u0014\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\f\u001a\u0002H\u00022\u000e\b\u0006\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aE\u0010\u0015\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042#\b\u0006\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a6\u0010\u0016\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0014\b\u0004\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00110\u0006H\u0086\bø\u0001\u0000\u001a[\u0010\u0016\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0014\b\u0004\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00110\u00062#\b\u0004\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001aM\u0010\u0018\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2#\b\u0006\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a9\u0010\u001b\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00042#\b\u0006\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a=\u0010\u001c\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\f\u001a\u0002H\u00022\u000e\b\u0006\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aI\u0010\u001d\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u001f\"\u0002H\u00022\u000e\b\u0006\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010 \u001a=\u0010!\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\f\u001a\u0002H\u00022\u000e\b\u0006\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"navigate", "", "C", "", "Lcom/arkivanov/decompose/router/stack/StackNavigator;", "transformer", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "stack", Constants.PUSH, "configuration", "onComplete", "Lkotlin/Function0;", "(Lcom/arkivanov/decompose/router/stack/StackNavigator;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "pushNew", "", "isSuccess", "(Lcom/arkivanov/decompose/router/stack/StackNavigator;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "pushToFront", "pop", "popWhile", "predicate", "popTo", FirebaseAnalytics.Param.INDEX, "", "popToFirst", "replaceCurrent", "replaceAll", "configurations", "", "(Lcom/arkivanov/decompose/router/stack/StackNavigator;[Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "bringToFront", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StackNavigatorExtKt {
    public static final <C> void navigate(StackNavigator<C> stackNavigator, Function1<? super List<? extends C>, ? extends List<? extends C>> transformer) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        stackNavigator.navigate(transformer, new Function2() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit navigate$lambda$0;
                navigate$lambda$0 = StackNavigatorExtKt.navigate$lambda$0((List) obj, (List) obj2);
                return navigate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$0(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        Intrinsics.checkNotNullParameter(list2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void push$default(StackNavigator stackNavigator, Object configuration, Function0 onComplete, int i, Object obj) {
        if ((i & 2) != 0) {
            onComplete = new Function0<Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$push$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$push$2(configuration), new StackNavigatorExtKt$push$3(onComplete));
    }

    public static final <C> void push(StackNavigator<C> stackNavigator, C configuration, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$push$2(configuration), new StackNavigatorExtKt$push$3(onComplete));
    }

    public static /* synthetic */ void pushNew$default(StackNavigator stackNavigator, Object configuration, Function1 onComplete, int i, Object obj) {
        if ((i & 2) != 0) {
            onComplete = new Function1<Boolean, Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$pushNew$1
                public final void invoke(boolean z) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$pushNew$2(configuration), new StackNavigatorExtKt$pushNew$3(onComplete));
    }

    public static final <C> void pushNew(StackNavigator<C> stackNavigator, C configuration, Function1<? super Boolean, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$pushNew$2(configuration), new StackNavigatorExtKt$pushNew$3(onComplete));
    }

    public static /* synthetic */ void pushToFront$default(StackNavigator stackNavigator, Object configuration, Function0 onComplete, int i, Object obj) {
        if ((i & 2) != 0) {
            onComplete = new Function0<Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$pushToFront$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$pushToFront$2(configuration), new StackNavigatorExtKt$pushToFront$3(onComplete));
    }

    public static final <C> void pushToFront(StackNavigator<C> stackNavigator, C configuration, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$pushToFront$2(configuration), new StackNavigatorExtKt$pushToFront$3(onComplete));
    }

    public static /* synthetic */ void pop$default(StackNavigator stackNavigator, Function1 onComplete, int i, Object obj) {
        if ((i & 1) != 0) {
            onComplete = new Function1<Boolean, Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$pop$1
                public final void invoke(boolean z) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(StackNavigatorExtKt$pop$2.INSTANCE, new StackNavigatorExtKt$pop$3(onComplete));
    }

    public static final <C> void pop(StackNavigator<C> stackNavigator, Function1<? super Boolean, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(StackNavigatorExtKt$pop$2.INSTANCE, new StackNavigatorExtKt$pop$3(onComplete));
    }

    public static final <C> void popWhile(StackNavigator<C> stackNavigator, Function1<? super C, Boolean> predicate, final Function1<? super Boolean, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$popWhile$2(predicate), new Function2<List<? extends C>, List<? extends C>, Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$popWhile$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                invoke((List) ((List) obj), (List) ((List) obj2));
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends C> newStack, List<? extends C> oldStack) {
                Intrinsics.checkNotNullParameter(newStack, "newStack");
                Intrinsics.checkNotNullParameter(oldStack, "oldStack");
                onComplete.invoke(Boolean.valueOf(newStack.size() < oldStack.size()));
            }
        });
    }

    public static /* synthetic */ void popTo$default(StackNavigator stackNavigator, int i, Function1 onComplete, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            onComplete = new Function1<Boolean, Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$popTo$1
                public final void invoke(boolean z) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (i < 0) {
            throw new IllegalArgumentException(("Index must not negative, but was " + i).toString());
        }
        stackNavigator.navigate(new StackNavigatorExtKt$popTo$3(i), new StackNavigatorExtKt$popTo$4(onComplete));
    }

    public static final <C> void popTo(StackNavigator<C> stackNavigator, int i, Function1<? super Boolean, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (i < 0) {
            throw new IllegalArgumentException(("Index must not negative, but was " + i).toString());
        }
        stackNavigator.navigate(new StackNavigatorExtKt$popTo$3(i), new StackNavigatorExtKt$popTo$4(onComplete));
    }

    public static /* synthetic */ void popToFirst$default(StackNavigator stackNavigator, Function1 onComplete, int i, Object obj) {
        if ((i & 1) != 0) {
            onComplete = new Function1<Boolean, Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$popToFirst$1
                public final void invoke(boolean z) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$popTo$3(0), new StackNavigatorExtKt$popTo$4(onComplete));
    }

    public static /* synthetic */ void replaceCurrent$default(StackNavigator stackNavigator, Object configuration, Function0 onComplete, int i, Object obj) {
        if ((i & 2) != 0) {
            onComplete = new Function0<Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$replaceCurrent$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$replaceCurrent$2(configuration), new StackNavigatorExtKt$replaceCurrent$3(onComplete));
    }

    public static final <C> void replaceCurrent(StackNavigator<C> stackNavigator, C configuration, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$replaceCurrent$2(configuration), new StackNavigatorExtKt$replaceCurrent$3(onComplete));
    }

    public static /* synthetic */ void replaceAll$default(StackNavigator stackNavigator, Object[] configurations, Function0 onComplete, int i, Object obj) {
        if ((i & 2) != 0) {
            onComplete = new Function0<Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$replaceAll$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$replaceAll$2(configurations), new StackNavigatorExtKt$replaceAll$3(onComplete));
    }

    public static final <C> void replaceAll(StackNavigator<C> stackNavigator, C[] configurations, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$replaceAll$2(configurations), new StackNavigatorExtKt$replaceAll$3(onComplete));
    }

    public static /* synthetic */ void bringToFront$default(StackNavigator stackNavigator, Object configuration, Function0 onComplete, int i, Object obj) {
        if ((i & 2) != 0) {
            onComplete = new Function0<Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$bringToFront$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$bringToFront$2(configuration), new StackNavigatorExtKt$bringToFront$3(onComplete));
    }

    public static final <C> void bringToFront(StackNavigator<C> stackNavigator, C configuration, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$bringToFront$2(configuration), new StackNavigatorExtKt$bringToFront$3(onComplete));
    }

    public static final <C> void popWhile(StackNavigator<C> stackNavigator, Function1<? super C, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        stackNavigator.navigate(new StackNavigatorExtKt$popWhile$2(predicate), new Function2<List<? extends C>, List<? extends C>, Unit>() { // from class: com.arkivanov.decompose.router.stack.StackNavigatorExtKt$popWhile$$inlined$popWhile$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                invoke((List) ((List) obj), (List) ((List) obj2));
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends C> newStack, List<? extends C> oldStack) {
                Intrinsics.checkNotNullParameter(newStack, "newStack");
                Intrinsics.checkNotNullParameter(oldStack, "oldStack");
                newStack.size();
                oldStack.size();
            }
        });
    }

    public static final void popToFirst(StackNavigator<?> stackNavigator, Function1<? super Boolean, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(stackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        stackNavigator.navigate(new StackNavigatorExtKt$popTo$3(0), new StackNavigatorExtKt$popTo$4(onComplete));
    }
}
