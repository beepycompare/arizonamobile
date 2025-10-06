package ru.mrlargha.feature.arizona.cases;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.feature.arizona.cases.databinding.CasesScreenBinding;
/* compiled from: CasesScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.CasesScreen$onBackendMessage$1", f = "CasesScreen.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes6.dex */
final class CasesScreen$onBackendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $data;
    int label;
    final /* synthetic */ CasesScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CasesScreen$onBackendMessage$1(CasesScreen casesScreen, String str, Continuation<? super CasesScreen$onBackendMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = casesScreen;
        this.$data = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CasesScreen$onBackendMessage$1(this.this$0, this.$data, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CasesScreen$onBackendMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        CasesScreenBinding casesScreenBinding;
        CasesScreenBinding casesScreenBinding2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.infoState;
            this.label = 1;
            if (mutableStateFlow.emit(MapperKt.toModel(this.$data, CasesInfoModel.class), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        casesScreenBinding = this.this$0.casesBinding;
        LinearLayout backContainer = casesScreenBinding.backContainer;
        Intrinsics.checkNotNullExpressionValue(backContainer, "backContainer");
        backContainer.setVisibility(0);
        casesScreenBinding2 = this.this$0.casesBinding;
        LinearLayout btnClose = casesScreenBinding2.btnClose;
        Intrinsics.checkNotNullExpressionValue(btnClose, "btnClose");
        btnClose.setVisibility(0);
        return Unit.INSTANCE;
    }
}
