package com.arkivanov.decompose.router.slot;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SlotNavigatorExt.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042%\u0010\u0005\u001a!\u0012\u0015\u0012\u0013\u0018\u0001H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0006\u001a=\u0010\n\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\t\u001a\u0002H\u00022\u000e\b\u0006\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a9\u0010\u000e\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"navigate", "", "C", "", "Lcom/arkivanov/decompose/router/slot/SlotNavigator;", "transformer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "configuration", RemoteConfigComponent.ACTIVATE_FILE_NAME, "onComplete", "Lkotlin/Function0;", "(Lcom/arkivanov/decompose/router/slot/SlotNavigator;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "dismiss", "", "isSuccess", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlotNavigatorExtKt {
    public static final <C> void navigate(SlotNavigator<C> slotNavigator, Function1<? super C, ? extends C> transformer) {
        Intrinsics.checkNotNullParameter(slotNavigator, "<this>");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        slotNavigator.navigate(transformer, new Function2() { // from class: com.arkivanov.decompose.router.slot.SlotNavigatorExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit navigate$lambda$0;
                navigate$lambda$0 = SlotNavigatorExtKt.navigate$lambda$0(obj, obj2);
                return navigate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$0(Object obj, Object obj2) {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void activate$default(SlotNavigator slotNavigator, Object configuration, Function0 onComplete, int i, Object obj) {
        if ((i & 2) != 0) {
            onComplete = new Function0<Unit>() { // from class: com.arkivanov.decompose.router.slot.SlotNavigatorExtKt$activate$1
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
        Intrinsics.checkNotNullParameter(slotNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        slotNavigator.navigate(new SlotNavigatorExtKt$activate$2(configuration), new SlotNavigatorExtKt$activate$3(onComplete));
    }

    public static final <C> void activate(SlotNavigator<C> slotNavigator, C configuration, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(slotNavigator, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        slotNavigator.navigate(new SlotNavigatorExtKt$activate$2(configuration), new SlotNavigatorExtKt$activate$3(onComplete));
    }

    public static /* synthetic */ void dismiss$default(SlotNavigator slotNavigator, Function1 onComplete, int i, Object obj) {
        if ((i & 1) != 0) {
            onComplete = new Function1<Boolean, Unit>() { // from class: com.arkivanov.decompose.router.slot.SlotNavigatorExtKt$dismiss$1
                public final void invoke(boolean z) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(slotNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        slotNavigator.navigate(SlotNavigatorExtKt$dismiss$2.INSTANCE, new SlotNavigatorExtKt$dismiss$3(onComplete));
    }

    public static final void dismiss(SlotNavigator<?> slotNavigator, Function1<? super Boolean, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(slotNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        slotNavigator.navigate(SlotNavigatorExtKt$dismiss$2.INSTANCE, new SlotNavigatorExtKt$dismiss$3(onComplete));
    }
}
