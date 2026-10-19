package com.miami.game.feature.settings.ui.compose;

import android.content.Context;
import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModsSettings.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.settings.ui.compose.ModsSettingsKt$ModsSettings$2$1", f = "ModsSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class ModsSettingsKt$ModsSettings$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $debugModeAvailable;
    final /* synthetic */ Function1<ModsInstructionsActions, Unit> $onShowModsInstructions;
    final /* synthetic */ ManagedActivityResultLauncher<Uri, Uri> $picker;
    final /* synthetic */ MutableState<Boolean> $pickerCancelled$delegate;
    final /* synthetic */ MutableState<Uri> $pickerInitialUri$delegate;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ModsSettingsKt$ModsSettings$2$1(MutableState<Boolean> mutableState, MutableState<Uri> mutableState2, Function1<? super ModsInstructionsActions, Unit> function1, boolean z, ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher, Context context, CoroutineScope coroutineScope, MutableState<Boolean> mutableState3, Continuation<? super ModsSettingsKt$ModsSettings$2$1> continuation) {
        super(2, continuation);
        this.$pickerCancelled$delegate = mutableState;
        this.$pickerInitialUri$delegate = mutableState2;
        this.$onShowModsInstructions = function1;
        this.$debugModeAvailable = z;
        this.$picker = managedActivityResultLauncher;
        this.$context = context;
        this.$scope = coroutineScope;
        this.$busy$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ModsSettingsKt$ModsSettings$2$1(this.$pickerCancelled$delegate, this.$pickerInitialUri$delegate, this.$onShowModsInstructions, this.$debugModeAvailable, this.$picker, this.$context, this.$scope, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ModsSettingsKt$ModsSettings$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean ModsSettings$lambda$15;
        Uri ModsSettings$lambda$12;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ModsSettings$lambda$15 = ModsSettingsKt.ModsSettings$lambda$15(this.$pickerCancelled$delegate);
            if (ModsSettings$lambda$15) {
                ModsSettingsKt.ModsSettings$lambda$16(this.$pickerCancelled$delegate, false);
                Function1<ModsInstructionsActions, Unit> function1 = this.$onShowModsInstructions;
                boolean z = this.$debugModeAvailable;
                ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher = this.$picker;
                MutableState<Uri> mutableState = this.$pickerInitialUri$delegate;
                Context context = this.$context;
                CoroutineScope coroutineScope = this.$scope;
                MutableState<Boolean> mutableState2 = this.$busy$delegate;
                ModsSettings$lambda$12 = ModsSettingsKt.ModsSettings$lambda$12(mutableState);
                ModsSettingsKt.ModsSettings$showInstructions(function1, z, managedActivityResultLauncher, mutableState, context, coroutineScope, mutableState2, ModsSettings$lambda$12);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
