package ru.mrlargha.feature.mobile.presentation.page.rent;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.elements.donate.presentation.UiState;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentPageBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentFilterContainerModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$selectToolbarAll$1$1$1", f = "ArizonaRentPage.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, nl = {218}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class ArizonaRentPage$selectToolbarAll$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UiState<ArizonaRentFilterContainerModel> $data;
    final /* synthetic */ List<ArizonaRentAdModel> $list;
    final /* synthetic */ MpArizonaRentPageBinding $this_with;
    int label;
    final /* synthetic */ ArizonaRentPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentPage$selectToolbarAll$1$1$1(ArizonaRentPage arizonaRentPage, UiState<ArizonaRentFilterContainerModel> uiState, List<ArizonaRentAdModel> list, MpArizonaRentPageBinding mpArizonaRentPageBinding, Continuation<? super ArizonaRentPage$selectToolbarAll$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = arizonaRentPage;
        this.$data = uiState;
        this.$list = list;
        this.$this_with = mpArizonaRentPageBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentPage$selectToolbarAll$1$1$1(this.this$0, this.$data, this.$list, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentPage$selectToolbarAll$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.adState;
            ArizonaRentFilterContainerModel arizonaRentFilterContainerModel = (ArizonaRentFilterContainerModel) ((UiState.Successful) this.$data).getData();
            ArizonaRentFilterContainerModel copy$default = arizonaRentFilterContainerModel != null ? ArizonaRentFilterContainerModel.copy$default(arizonaRentFilterContainerModel, null, this.$list, 1, null) : null;
            this.label = 1;
            if (mutableStateFlow.emit(new UiState.Successful(copy$default), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.$this_with.rvAd.scrollToPosition(0);
        return Unit.INSTANCE;
    }
}
