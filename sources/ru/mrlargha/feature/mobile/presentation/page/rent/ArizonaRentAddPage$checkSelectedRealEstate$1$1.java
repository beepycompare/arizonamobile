package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.app.Activity;
import android.graphics.Color;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentAddPageBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentCreateAdModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentRealEstateModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentAddPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$checkSelectedRealEstate$1$1", f = "ArizonaRentAddPage.kt", i = {}, l = {347, 368}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes6.dex */
public final class ArizonaRentAddPage$checkSelectedRealEstate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MpArizonaRentAddPageBinding $this_with;
    int label;
    final /* synthetic */ ArizonaRentAddPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentAddPage$checkSelectedRealEstate$1$1(ArizonaRentAddPage arizonaRentAddPage, MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding, Continuation<? super ArizonaRentAddPage$checkSelectedRealEstate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = arizonaRentAddPage;
        this.$this_with = mpArizonaRentAddPageBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentAddPage$checkSelectedRealEstate$1$1(this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentAddPage$checkSelectedRealEstate$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$checkSelectedRealEstate$1$1.AnonymousClass1(r9.this$0, null), r9) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ef, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$checkSelectedRealEstate$1$1.AnonymousClass2(r9.this$0, null), r9) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        boolean z2;
        Activity context;
        Activity context2;
        boolean z3;
        Activity context3;
        Activity context4;
        Activity context5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            z = this.this$0.isFully;
            if (z) {
                this.label = 1;
            } else {
                this.label = 2;
            }
            return coroutine_suspended;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            this.this$0.inputFormat = ArizonaRentAddPage.Companion.getDATA_INPUT_LIMIT_FULLY();
            this.this$0.inputFormatCost = ArizonaRentAddPage.Companion.getDATA_INPUT_LIMIT_COST_FULLY();
            this.this$0.updateLimitData();
            z2 = this.this$0.isFirstOpen;
            if (!z2) {
                this.this$0.checkEditTexts();
            }
            this.$this_with.btnFully.setBackground(-1);
            this.$this_with.btnRoom.setBackground(Color.parseColor("#E5000000"));
            this.$this_with.tvFully.setTextColor(Color.parseColor("#E5000000"));
            this.$this_with.tvRoom.setTextColor(Color.parseColor("#B2FFFFFF"));
            TextView tvAvailableOutOf = this.$this_with.tvAvailableOutOf;
            Intrinsics.checkNotNullExpressionValue(tvAvailableOutOf, "tvAvailableOutOf");
            tvAvailableOutOf.setVisibility(4);
            TextView textView = this.$this_with.tvRentalTime;
            context = this.this$0.getContext();
            textView.setText(context.getString(R.string.rental_time_days));
            TextView textView2 = this.$this_with.tvCost;
            context2 = this.this$0.getContext();
            textView2.setText(context2.getString(R.string.cost_days));
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            this.this$0.inputFormat = ArizonaRentAddPage.Companion.getDATA_INPUT_LIMIT_ROOM();
            this.this$0.inputFormatCost = ArizonaRentAddPage.Companion.getDATA_INPUT_LIMIT_COST_ROOM();
            this.this$0.updateLimitData();
            z3 = this.this$0.isFirstOpen;
            if (!z3) {
                this.this$0.checkEditTexts();
            }
            this.$this_with.btnRoom.setBackground(-1);
            this.$this_with.btnFully.setBackground(Color.parseColor("#E5000000"));
            this.$this_with.tvRoom.setTextColor(Color.parseColor("#E5000000"));
            this.$this_with.tvFully.setTextColor(Color.parseColor("#B2FFFFFF"));
            TextView tvAvailableOutOf2 = this.$this_with.tvAvailableOutOf;
            Intrinsics.checkNotNullExpressionValue(tvAvailableOutOf2, "tvAvailableOutOf");
            tvAvailableOutOf2.setVisibility(0);
            Object selectedItem = this.$this_with.spinnerRealEstate.getSelectedItem();
            Intrinsics.checkNotNull(selectedItem, "null cannot be cast to non-null type ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentRealEstateModel");
            ArizonaRentRealEstateModel arizonaRentRealEstateModel = (ArizonaRentRealEstateModel) selectedItem;
            TextView textView3 = this.$this_with.tvAvailableOutOf;
            context3 = this.this$0.getContext();
            textView3.setText(context3.getString(R.string.available_out_of, new Object[]{Boxing.boxInt(arizonaRentRealEstateModel.getAvailableRoomCount()), Boxing.boxInt(arizonaRentRealEstateModel.getRoomCount())}));
            TextView textView4 = this.$this_with.tvRentalTime;
            context4 = this.this$0.getContext();
            textView4.setText(context4.getString(R.string.rental_time_hours));
            TextView textView5 = this.$this_with.tvCost;
            context5 = this.this$0.getContext();
            textView5.setText(context5.getString(R.string.cost_hours));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArizonaRentAddPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$checkSelectedRealEstate$1$1$1", f = "ArizonaRentAddPage.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$checkSelectedRealEstate$1$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ArizonaRentAddPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ArizonaRentAddPage arizonaRentAddPage, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = arizonaRentAddPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            MutableStateFlow mutableStateFlow2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0.adState;
                mutableStateFlow2 = this.this$0.adState;
                this.label = 1;
                if (mutableStateFlow.emit(ArizonaRentCreateAdModel.copy$default((ArizonaRentCreateAdModel) mutableStateFlow2.getValue(), null, null, null, null, null, Boxing.boxInt(0), 31, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArizonaRentAddPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$checkSelectedRealEstate$1$1$2", f = "ArizonaRentAddPage.kt", i = {}, l = {369}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$checkSelectedRealEstate$1$1$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ArizonaRentAddPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ArizonaRentAddPage arizonaRentAddPage, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = arizonaRentAddPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            MutableStateFlow mutableStateFlow2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0.adState;
                mutableStateFlow2 = this.this$0.adState;
                this.label = 1;
                if (mutableStateFlow.emit(ArizonaRentCreateAdModel.copy$default((ArizonaRentCreateAdModel) mutableStateFlow2.getValue(), null, null, null, null, null, Boxing.boxInt(1), 31, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
