package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.elements.donate.presentation.UiState;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentPageBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentFilterContainerModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$setUpCollectors$1$1", f = "ArizonaRentPage.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class ArizonaRentPage$setUpCollectors$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MpArizonaRentPageBinding $this_with;
    int label;
    final /* synthetic */ ArizonaRentPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentPage$setUpCollectors$1$1(ArizonaRentPage arizonaRentPage, MpArizonaRentPageBinding mpArizonaRentPageBinding, Continuation<? super ArizonaRentPage$setUpCollectors$1$1> continuation) {
        super(2, continuation);
        this.this$0 = arizonaRentPage;
        this.$this_with = mpArizonaRentPageBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentPage$setUpCollectors$1$1(this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentPage$setUpCollectors$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.adState;
            final ArizonaRentPage arizonaRentPage = this.this$0;
            final MpArizonaRentPageBinding mpArizonaRentPageBinding = this.$this_with;
            this.label = 1;
            if (mutableStateFlow.collect(new FlowCollector() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$setUpCollectors$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((UiState) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(UiState<ArizonaRentFilterContainerModel> uiState, Continuation<? super Unit> continuation) {
                    List<ArizonaRentAdModel> data;
                    if (uiState instanceof UiState.Error) {
                        ArizonaRentPage.this.notAd();
                    } else if (uiState instanceof UiState.Loading) {
                        ProgressBar progressBar = mpArizonaRentPageBinding.progressBar;
                        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                        progressBar.setVisibility(0);
                        LinearLayout adContainer = mpArizonaRentPageBinding.adContainer;
                        Intrinsics.checkNotNullExpressionValue(adContainer, "adContainer");
                        adContainer.setVisibility(8);
                        FrameLayout nothingNotContainer = mpArizonaRentPageBinding.nothingNotContainer;
                        Intrinsics.checkNotNullExpressionValue(nothingNotContainer, "nothingNotContainer");
                        nothingNotContainer.setVisibility(8);
                    } else if (!(uiState instanceof UiState.Successful)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        UiState.Successful successful = (UiState.Successful) uiState;
                        ArizonaRentFilterContainerModel arizonaRentFilterContainerModel = (ArizonaRentFilterContainerModel) successful.getData();
                        Log.d("arizona_rent", "filter: " + (arizonaRentFilterContainerModel != null ? arizonaRentFilterContainerModel.getFilter() : null));
                        ProgressBar progressBar2 = mpArizonaRentPageBinding.progressBar;
                        Intrinsics.checkNotNullExpressionValue(progressBar2, "progressBar");
                        progressBar2.setVisibility(8);
                        LinearLayout adContainer2 = mpArizonaRentPageBinding.adContainer;
                        Intrinsics.checkNotNullExpressionValue(adContainer2, "adContainer");
                        adContainer2.setVisibility(0);
                        FrameLayout nothingNotContainer2 = mpArizonaRentPageBinding.nothingNotContainer;
                        Intrinsics.checkNotNullExpressionValue(nothingNotContainer2, "nothingNotContainer");
                        nothingNotContainer2.setVisibility(8);
                        ArizonaRentFilterContainerModel arizonaRentFilterContainerModel2 = (ArizonaRentFilterContainerModel) successful.getData();
                        if (arizonaRentFilterContainerModel2 == null || (data = arizonaRentFilterContainerModel2.getData()) == null || !data.isEmpty()) {
                            ArizonaRentPage.this.setFilterData((ArizonaRentFilterContainerModel) successful.getData());
                        } else {
                            ArizonaRentPage.this.notAd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
