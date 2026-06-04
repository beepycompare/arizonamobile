package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentCreateAdModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentAddPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$6$1", f = "ArizonaRentAddPage.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, nl = {223}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class ArizonaRentAddPage$setupListeners$1$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Editable $it;
    int label;
    final /* synthetic */ ArizonaRentAddPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentAddPage$setupListeners$1$6$1(ArizonaRentAddPage arizonaRentAddPage, Editable editable, Continuation<? super ArizonaRentAddPage$setupListeners$1$6$1> continuation) {
        super(2, continuation);
        this.this$0 = arizonaRentAddPage;
        this.$it = editable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentAddPage$setupListeners$1$6$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentAddPage$setupListeners$1$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArizonaRentAddPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$6$1$1", f = "ArizonaRentAddPage.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, nl = {222}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$6$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Editable $it;
        int label;
        final /* synthetic */ ArizonaRentAddPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ArizonaRentAddPage arizonaRentAddPage, Editable editable, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = arizonaRentAddPage;
            this.$it = editable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$it, continuation);
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
                if (mutableStateFlow.emit(ArizonaRentCreateAdModel.copy$default((ArizonaRentCreateAdModel) mutableStateFlow2.getValue(), null, null, null, StringsKt.toIntOrNull(String.valueOf(this.$it)), null, null, 55, null), this) == coroutine_suspended) {
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.this$0, this.$it, null), this) == coroutine_suspended) {
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
