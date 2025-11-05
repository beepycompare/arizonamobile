package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.graphics.Color;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentAddPageBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentCreateAdModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentAddPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupControllers$1$1", f = "ArizonaRentAddPage.kt", i = {}, l = {401}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes6.dex */
public final class ArizonaRentAddPage$setupControllers$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MpArizonaRentAddPageBinding $this_with;
    int label;
    final /* synthetic */ ArizonaRentAddPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentAddPage$setupControllers$1$1(ArizonaRentAddPage arizonaRentAddPage, MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding, Continuation<? super ArizonaRentAddPage$setupControllers$1$1> continuation) {
        super(2, continuation);
        this.this$0 = arizonaRentAddPage;
        this.$this_with = mpArizonaRentAddPageBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentAddPage$setupControllers$1$1(this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentAddPage$setupControllers$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.adState;
            final MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding = this.$this_with;
            this.label = 1;
            if (mutableStateFlow.collect(new FlowCollector() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupControllers$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((ArizonaRentCreateAdModel) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(ArizonaRentCreateAdModel arizonaRentCreateAdModel, Continuation<? super Unit> continuation) {
                    if (arizonaRentCreateAdModel.checkAllIsReady()) {
                        MpArizonaRentAddPageBinding.this.tvCreateAd.setTextColor(Color.parseColor("#E5000000"));
                        CustomCardView btnCreateAd = MpArizonaRentAddPageBinding.this.btnCreateAd;
                        Intrinsics.checkNotNullExpressionValue(btnCreateAd, "btnCreateAd");
                        CustomCardView.setBackground$default(btnCreateAd, Color.parseColor("#2857F4"), Color.parseColor("#6CD0FA"), null, null, 12, null);
                        MpArizonaRentAddPageBinding.this.btnCreateAd.setBorder(0);
                        MpArizonaRentAddPageBinding.this.btnCreateAd.setClickable(true);
                        MpArizonaRentAddPageBinding.this.btnCreateAd.setEnabled(true);
                    } else {
                        MpArizonaRentAddPageBinding.this.tvCreateAd.setTextColor(Color.parseColor("#80FFFFFF"));
                        MpArizonaRentAddPageBinding.this.btnCreateAd.setBorder(Color.parseColor("#1AFFFFFF"));
                        MpArizonaRentAddPageBinding.this.btnCreateAd.setBackground(Color.parseColor("#111111"));
                        MpArizonaRentAddPageBinding.this.btnCreateAd.setClickable(false);
                        MpArizonaRentAddPageBinding.this.btnCreateAd.setEnabled(false);
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
