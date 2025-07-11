package com.miami.game.core.app.root.nav.main;

import com.arkivanov.decompose.router.stack.StackNavigation;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.app.root.nav.main.DialogMainState;
import com.miami.game.core.app.root.nav.main.MainComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/core/app/root/nav/main/MainState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.app.root.nav.main.MainComponent$observeExternal$1", f = "MainComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class MainComponent$observeExternal$1 extends SuspendLambda implements Function2<MainState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainComponent$observeExternal$1(MainComponent mainComponent, Continuation<? super MainComponent$observeExternal$1> continuation) {
        super(2, continuation);
        this.this$0 = mainComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainComponent$observeExternal$1 mainComponent$observeExternal$1 = new MainComponent$observeExternal$1(this.this$0, continuation);
        mainComponent$observeExternal$1.L$0 = obj;
        return mainComponent$observeExternal$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MainState mainState, Continuation<? super Unit> continuation) {
        return ((MainComponent$observeExternal$1) create(mainState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StackNavigation stackNavigation;
        StackNavigation stackNavigation2;
        MainState mainState = (MainState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Timber.Forest.d("mainStateStore " + mainState, new Object[0]);
        if (mainState.getDialog() instanceof DialogMainState.Empty) {
            stackNavigation2 = this.this$0.navDialog;
            final MainComponent.DialogConfig[] dialogConfigArr = {MainComponent.DialogConfig.EMPTY.INSTANCE};
            stackNavigation2.navigate(new Function1<List<? extends MainComponent.DialogConfig>, List<? extends MainComponent.DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$observeExternal$1$invokeSuspend$$inlined$replaceAll$default$1
                @Override // kotlin.jvm.functions.Function1
                public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ArraysKt.toList(dialogConfigArr);
                }
            }, new Function2<List<? extends MainComponent.DialogConfig>, List<? extends MainComponent.DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$observeExternal$1$invokeSuspend$$inlined$replaceAll$default$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                    Intrinsics.checkNotNullParameter(list, "<unused var>");
                    Intrinsics.checkNotNullParameter(list2, "<unused var>");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                    invoke2(list, list2);
                    return Unit.INSTANCE;
                }
            });
        } else {
            if (mainState.getDialog() instanceof DialogMainState.Error) {
                stackNavigation = this.this$0.navDialog;
                final MainComponent.DialogConfig[] dialogConfigArr2 = {MainComponent.DialogConfig.ActivityError.INSTANCE};
                stackNavigation.navigate(new Function1<List<? extends MainComponent.DialogConfig>, List<? extends MainComponent.DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$observeExternal$1$invokeSuspend$$inlined$replaceAll$default$3
                    @Override // kotlin.jvm.functions.Function1
                    public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return ArraysKt.toList(dialogConfigArr2);
                    }
                }, new Function2<List<? extends MainComponent.DialogConfig>, List<? extends MainComponent.DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$observeExternal$1$invokeSuspend$$inlined$replaceAll$default$4
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                        Intrinsics.checkNotNullParameter(list, "<unused var>");
                        Intrinsics.checkNotNullParameter(list2, "<unused var>");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                        invoke2(list, list2);
                        return Unit.INSTANCE;
                    }
                });
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
