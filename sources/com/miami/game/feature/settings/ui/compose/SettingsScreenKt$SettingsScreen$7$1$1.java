package com.miami.game.feature.settings.ui.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsScreenKt$SettingsScreen$7$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ Function1<Function1<? super Boolean, Unit>, Unit> $onViceCityDelete;
    final /* synthetic */ MutableState<Long> $viceCityDialogSize;
    final /* synthetic */ MutableState<Boolean> $viceCityEnabled;
    final /* synthetic */ MutableState<Boolean> $viceCityOperationInProgress;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsScreenKt$SettingsScreen$7$1$1(MutableState<Boolean> mutableState, Function1<? super Function1<? super Boolean, Unit>, Unit> function1, MutableState<Boolean> mutableState2, MutableState<Long> mutableState3) {
        super(0, Intrinsics.Kotlin.class, "handleViceCityDelete", "SettingsScreen$handleViceCityDelete(Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", 0);
        this.$viceCityOperationInProgress = mutableState;
        this.$onViceCityDelete = function1;
        this.$viceCityEnabled = mutableState2;
        this.$viceCityDialogSize = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SettingsScreenKt.SettingsScreen$handleViceCityDelete(this.$viceCityOperationInProgress, this.$onViceCityDelete, this.$viceCityEnabled, this.$viceCityDialogSize);
    }
}
