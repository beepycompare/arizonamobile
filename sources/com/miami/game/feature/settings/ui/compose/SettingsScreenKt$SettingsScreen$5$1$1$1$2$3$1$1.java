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
public final /* synthetic */ class SettingsScreenKt$SettingsScreen$5$1$1$1$2$3$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ Function1<Function1<? super Boolean, Unit>, Unit> $onViceCityEnable;
    final /* synthetic */ Function1<Function1<? super Long, Unit>, Unit> $onViceCityInspectBeforeDisable;
    final /* synthetic */ MutableState<Long> $viceCityDialogSize;
    final /* synthetic */ MutableState<Boolean> $viceCityEnabled;
    final /* synthetic */ MutableState<Boolean> $viceCityOperationInProgress;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsScreenKt$SettingsScreen$5$1$1$1$2$3$1$1(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Function1<? super Function1<? super Boolean, Unit>, Unit> function1, Function1<? super Function1<? super Long, Unit>, Unit> function12, MutableState<Long> mutableState3) {
        super(0, Intrinsics.Kotlin.class, "handleViceCitySwitchClick", "SettingsScreen$handleViceCitySwitchClick(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/MutableState;)V", 0);
        this.$viceCityOperationInProgress = mutableState;
        this.$viceCityEnabled = mutableState2;
        this.$onViceCityEnable = function1;
        this.$onViceCityInspectBeforeDisable = function12;
        this.$viceCityDialogSize = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SettingsScreenKt.SettingsScreen$handleViceCitySwitchClick(this.$viceCityOperationInProgress, this.$viceCityEnabled, this.$onViceCityEnable, this.$onViceCityInspectBeforeDisable, this.$viceCityDialogSize);
    }
}
