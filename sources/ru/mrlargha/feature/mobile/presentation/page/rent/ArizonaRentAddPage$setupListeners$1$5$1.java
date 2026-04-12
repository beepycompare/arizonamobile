package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.text.Editable;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyParts;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentAddPageBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentCreateAdModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentAddPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$5$1", f = "ArizonaRentAddPage.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, nl = {215}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class ArizonaRentAddPage$setupListeners$1$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Editable $it;
    final /* synthetic */ MpArizonaRentAddPageBinding $this_with;
    int label;
    final /* synthetic */ ArizonaRentAddPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentAddPage$setupListeners$1$5$1(MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding, Editable editable, ArizonaRentAddPage arizonaRentAddPage, Continuation<? super ArizonaRentAddPage$setupListeners$1$5$1> continuation) {
        super(2, continuation);
        this.$this_with = mpArizonaRentAddPageBinding;
        this.$it = editable;
        this.this$0 = arizonaRentAddPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentAddPage$setupListeners$1$5$1(this.$this_with, this.$it, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentAddPage$setupListeners$1$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArizonaRentAddPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$5$1$1", f = "ArizonaRentAddPage.kt", i = {0, 0}, l = {213}, m = "invokeSuspend", n = {"costKk", "sum"}, nl = {214}, s = {"L$0", "J$0"}, v = 2)
    /* renamed from: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$5$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Editable $it;
        final /* synthetic */ MpArizonaRentAddPageBinding $this_with;
        long J$0;
        Object L$0;
        int label;
        final /* synthetic */ ArizonaRentAddPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding, Editable editable, ArizonaRentAddPage arizonaRentAddPage, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_with = mpArizonaRentAddPageBinding;
            this.$it = editable;
            this.this$0 = arizonaRentAddPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_with, this.$it, this.this$0, continuation);
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
                Integer intOrNull = StringsKt.toIntOrNull(String.valueOf(this.$this_with.etCostKk.getText()));
                int intValue = intOrNull != null ? intOrNull.intValue() : 0;
                Integer intOrNull2 = StringsKt.toIntOrNull(String.valueOf(this.$it));
                long j = MoneyElementKt.toLong(new MoneyParts(0, intValue, intOrNull2 != null ? intOrNull2.intValue() : 0));
                mutableStateFlow = this.this$0.adState;
                mutableStateFlow2 = this.this$0.adState;
                this.L$0 = SpillingKt.nullOutSpilledVariable(intOrNull);
                this.J$0 = j;
                this.label = 1;
                if (mutableStateFlow.emit(ArizonaRentCreateAdModel.copy$default((ArizonaRentCreateAdModel) mutableStateFlow2.getValue(), null, Boxing.boxLong(j), null, null, null, null, 61, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Integer num = (Integer) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$this_with, this.$it, this.this$0, null), this) == coroutine_suspended) {
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
