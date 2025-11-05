package ru.mrlargha.feature.mobile.presentation.page.rent;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentAddPageBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentCreateAdModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentRealEstateModel;
/* compiled from: ArizonaRentAddPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$8$onItemSelected$1", f = "ArizonaRentAddPage.kt", i = {0, 1}, l = {241, 258}, m = "invokeSuspend", n = {"item", "item"}, s = {"L$0", "L$0"}, v = 1)
/* loaded from: classes6.dex */
final class ArizonaRentAddPage$setupListeners$1$8$onItemSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MpArizonaRentAddPageBinding $this_with;
    Object L$0;
    int label;
    final /* synthetic */ ArizonaRentAddPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentAddPage$setupListeners$1$8$onItemSelected$1(MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding, ArizonaRentAddPage arizonaRentAddPage, Continuation<? super ArizonaRentAddPage$setupListeners$1$8$onItemSelected$1> continuation) {
        super(2, continuation);
        this.$this_with = mpArizonaRentAddPageBinding;
        this.this$0 = arizonaRentAddPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentAddPage$setupListeners$1$8$onItemSelected$1(this.$this_with, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentAddPage$setupListeners$1$8$onItemSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ec, code lost:
        if (r1.emit(ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentCreateAdModel.copy$default((ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentCreateAdModel) r3.getValue(), null, null, null, null, null, null, 30, null), r13) == r0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        ArizonaRentRealEstateModel arizonaRentRealEstateModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object selectedItem = this.$this_with.spinnerRealEstate.getSelectedItem();
            Intrinsics.checkNotNull(selectedItem, "null cannot be cast to non-null type ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentRealEstateModel");
            ArizonaRentRealEstateModel arizonaRentRealEstateModel2 = (ArizonaRentRealEstateModel) selectedItem;
            this.this$0.currentRealEstate = arizonaRentRealEstateModel2;
            if (!arizonaRentRealEstateModel2.isPublish()) {
                mutableStateFlow3 = this.this$0.adState;
                mutableStateFlow4 = this.this$0.adState;
                this.L$0 = arizonaRentRealEstateModel2;
                this.label = 1;
                if (mutableStateFlow3.emit(ArizonaRentCreateAdModel.copy$default((ArizonaRentCreateAdModel) mutableStateFlow4.getValue(), Boxing.boxInt(arizonaRentRealEstateModel2.getHouseId()), null, null, null, null, null, 62, null), this) != coroutine_suspended) {
                    arizonaRentRealEstateModel = arizonaRentRealEstateModel2;
                    this.this$0.setDefaultButtons();
                    if (!arizonaRentRealEstateModel.isApartment()) {
                    }
                    this.this$0.checkSelectedRealEstate();
                }
            } else {
                mutableStateFlow = this.this$0.adState;
                mutableStateFlow2 = this.this$0.adState;
                this.L$0 = SpillingKt.nullOutSpilledVariable(arizonaRentRealEstateModel2);
                this.label = 2;
            }
            return coroutine_suspended;
        } else if (i == 1) {
            arizonaRentRealEstateModel = (ArizonaRentRealEstateModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.this$0.setDefaultButtons();
            if (!arizonaRentRealEstateModel.isApartment()) {
                this.this$0.isFully = false;
                this.$this_with.btnFully.setEnabled(false);
                this.$this_with.btnFully.setAlpha(0.6f);
            } else if (arizonaRentRealEstateModel.getAvailableRoomCount() <= 0) {
                this.this$0.isFully = true;
                this.$this_with.btnRoom.setEnabled(false);
                this.$this_with.btnRoom.setAlpha(0.6f);
            }
            this.this$0.checkSelectedRealEstate();
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ArizonaRentRealEstateModel arizonaRentRealEstateModel3 = (ArizonaRentRealEstateModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
