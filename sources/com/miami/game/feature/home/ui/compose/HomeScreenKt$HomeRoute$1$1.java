package com.miami.game.feature.home.ui.compose;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.runtime.State;
import com.miami.game.feature.home.ui.HomeComponent;
import com.miami.game.feature.home.ui.model.HomeUiAction;
import com.miami.game.feature.home.ui.model.HomeUiState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeScreen.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "uiAction", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.compose.HomeScreenKt$HomeRoute$1$1", f = "HomeScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class HomeScreenKt$HomeRoute$1$1 extends SuspendLambda implements Function3<CoroutineScope, HomeUiAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomeComponent $component;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<String, Unit> $navigateToDownloadDialog;
    final /* synthetic */ Function0<Unit> $navigateToDownloadScreen;
    final /* synthetic */ Function2<Function0<Unit>, String, Unit> $navigateToErrorDialog;
    final /* synthetic */ Function0<Unit> $navigateToNotification;
    final /* synthetic */ Function0<Unit> $navigateToSelectServers;
    final /* synthetic */ Function0<Unit> $navigateToSettings;
    final /* synthetic */ Function0<Unit> $navigateTooRepairGameSuccess;
    final /* synthetic */ State<HomeUiState> $uiState$delegate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeScreenKt$HomeRoute$1$1(Function0<Unit> function0, Function0<Unit> function02, Function1<? super String, Unit> function1, Function2<? super Function0<Unit>, ? super String, Unit> function2, HomeComponent homeComponent, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05, Context context, State<HomeUiState> state, Continuation<? super HomeScreenKt$HomeRoute$1$1> continuation) {
        super(3, continuation);
        this.$navigateToSettings = function0;
        this.$navigateToSelectServers = function02;
        this.$navigateToDownloadDialog = function1;
        this.$navigateToErrorDialog = function2;
        this.$component = homeComponent;
        this.$navigateToDownloadScreen = function03;
        this.$navigateTooRepairGameSuccess = function04;
        this.$navigateToNotification = function05;
        this.$context = context;
        this.$uiState$delegate = state;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, HomeUiAction homeUiAction, Continuation<? super Unit> continuation) {
        HomeScreenKt$HomeRoute$1$1 homeScreenKt$HomeRoute$1$1 = new HomeScreenKt$HomeRoute$1$1(this.$navigateToSettings, this.$navigateToSelectServers, this.$navigateToDownloadDialog, this.$navigateToErrorDialog, this.$component, this.$navigateToDownloadScreen, this.$navigateTooRepairGameSuccess, this.$navigateToNotification, this.$context, this.$uiState$delegate, continuation);
        homeScreenKt$HomeRoute$1$1.L$0 = homeUiAction;
        return homeScreenKt$HomeRoute$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HomeUiState HomeRoute$lambda$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        HomeUiAction homeUiAction = (HomeUiAction) this.L$0;
        if (Intrinsics.areEqual(homeUiAction, HomeUiAction.NavigateToSettings.INSTANCE)) {
            this.$navigateToSettings.invoke();
        } else if (Intrinsics.areEqual(homeUiAction, HomeUiAction.NavigateToSelectServers.INSTANCE)) {
            this.$navigateToSelectServers.invoke();
        } else if (homeUiAction instanceof HomeUiAction.NavigateToDownloadDialog) {
            Function1<String, Unit> function1 = this.$navigateToDownloadDialog;
            HomeRoute$lambda$0 = HomeScreenKt.HomeRoute$lambda$0(this.$uiState$delegate);
            function1.invoke(HomeRoute$lambda$0.getUpdateSize());
        } else if (Intrinsics.areEqual(homeUiAction, HomeUiAction.NavigateToErrorDialog.INSTANCE)) {
            this.$navigateToErrorDialog.invoke(this.$component.getOnRetry(), this.$component.getErrorMessage());
        } else if (Intrinsics.areEqual(homeUiAction, HomeUiAction.NavigateToDownloadScreen.INSTANCE)) {
            this.$navigateToDownloadScreen.invoke();
        } else if (Intrinsics.areEqual(homeUiAction, HomeUiAction.NavigateToRepairGameSuccess.INSTANCE)) {
            this.$navigateTooRepairGameSuccess.invoke();
        } else if (Intrinsics.areEqual(homeUiAction, HomeUiAction.NavigateToNotification.INSTANCE)) {
            this.$navigateToNotification.invoke();
        } else if (!Intrinsics.areEqual(homeUiAction, HomeUiAction.NotifyHwIsNotAllowed.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Toast.makeText(this.$context, "Магазин не доступен для приложения с AppGallery", 1).show();
        }
        return Unit.INSTANCE;
    }
}
