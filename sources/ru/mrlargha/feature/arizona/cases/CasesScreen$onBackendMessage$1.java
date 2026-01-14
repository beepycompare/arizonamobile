package ru.mrlargha.feature.arizona.cases;

import android.widget.LinearLayout;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
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
import ru.mrlargha.feature.arizona.cases.databinding.ArizonaCasesScreenBinding;
/* compiled from: CasesScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.CasesScreen$onBackendMessage$1", f = "CasesScreen.kt", i = {0}, l = {95}, m = "invokeSuspend", n = {CommonUrlParts.MODEL}, s = {"L$0"}, v = 1)
/* loaded from: classes6.dex */
final class CasesScreen$onBackendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $data;
    Object L$0;
    int label;
    final /* synthetic */ CasesScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CasesScreen$onBackendMessage$1(String str, CasesScreen casesScreen, Continuation<? super CasesScreen$onBackendMessage$1> continuation) {
        super(2, continuation);
        this.$data = str;
        this.this$0 = casesScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CasesScreen$onBackendMessage$1(this.$data, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CasesScreen$onBackendMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        CasesInfoModel casesInfoModel;
        ArizonaCasesScreenBinding arizonaCasesScreenBinding;
        ArizonaCasesScreenBinding arizonaCasesScreenBinding2;
        ArizonaCasesScreenBinding arizonaCasesScreenBinding3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CasesInfoModel casesInfoModel2 = (CasesInfoModel) MapperKt.toModel(this.$data, CasesInfoModel.class);
            mutableStateFlow = this.this$0.infoState;
            this.L$0 = casesInfoModel2;
            this.label = 1;
            if (mutableStateFlow.emit(casesInfoModel2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            casesInfoModel = casesInfoModel2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            casesInfoModel = (CasesInfoModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        arizonaCasesScreenBinding = this.this$0.casesBinding;
        LinearLayout backContainer = arizonaCasesScreenBinding.backContainer;
        Intrinsics.checkNotNullExpressionValue(backContainer, "backContainer");
        backContainer.setVisibility(0);
        arizonaCasesScreenBinding2 = this.this$0.casesBinding;
        LinearLayout btnClose = arizonaCasesScreenBinding2.btnClose;
        Intrinsics.checkNotNullExpressionValue(btnClose, "btnClose");
        btnClose.setVisibility(0);
        this.this$0.startGoldBoxAnimation();
        Picasso picasso = Picasso.get();
        String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        RequestCreator load = picasso.load(resourceUrl$default + "projects/arizona-rp/systems/cases/" + casesInfoModel.getCaseId() + ".webp");
        arizonaCasesScreenBinding3 = this.this$0.casesBinding;
        load.into(arizonaCasesScreenBinding3.openPage.caseImg);
        return Unit.INSTANCE;
    }
}
