package ru.mrlargha.feature.mobile.presentation.page.rent;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.elements.donate.presentation.UiState;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentFilterContainerModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentFilterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$openFilter$1$1$1", f = "ArizonaRentPage.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, nl = {279}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class ArizonaRentPage$openFilter$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArizonaRentFilterModel $filter;
    final /* synthetic */ UiState<ArizonaRentFilterContainerModel> $state;
    int label;
    final /* synthetic */ ArizonaRentPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentPage$openFilter$1$1$1(UiState<ArizonaRentFilterContainerModel> uiState, ArizonaRentFilterModel arizonaRentFilterModel, ArizonaRentPage arizonaRentPage, Continuation<? super ArizonaRentPage$openFilter$1$1$1> continuation) {
        super(2, continuation);
        this.$state = uiState;
        this.$filter = arizonaRentFilterModel;
        this.this$0 = arizonaRentPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentPage$openFilter$1$1$1(this.$state, this.$filter, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentPage$openFilter$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArizonaRentPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$openFilter$1$1$1$1", f = "ArizonaRentPage.kt", i = {0, 0, 0}, l = {276}, m = "invokeSuspend", n = {"it", CommonUrlParts.MODEL, "$i$a$-let-ArizonaRentPage$openFilter$1$1$1$1$1"}, nl = {277}, s = {"L$0", "L$1", "I$0"}, v = 2)
    /* renamed from: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$openFilter$1$1$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArizonaRentFilterModel $filter;
        final /* synthetic */ UiState<ArizonaRentFilterContainerModel> $state;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ArizonaRentPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UiState<ArizonaRentFilterContainerModel> uiState, ArizonaRentFilterModel arizonaRentFilterModel, ArizonaRentPage arizonaRentPage, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = uiState;
            this.$filter = arizonaRentFilterModel;
            this.this$0 = arizonaRentPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.$filter, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ArizonaRentFilterContainerModel arizonaRentFilterContainerModel = (ArizonaRentFilterContainerModel) ((UiState.Successful) this.$state).getData();
                if (arizonaRentFilterContainerModel != null) {
                    ArizonaRentFilterModel arizonaRentFilterModel = this.$filter;
                    ArizonaRentPage arizonaRentPage = this.this$0;
                    ArizonaRentFilterContainerModel arizonaRentFilterContainerModel2 = new ArizonaRentFilterContainerModel(arizonaRentFilterModel, arizonaRentFilterContainerModel.getData());
                    mutableStateFlow = arizonaRentPage.adState;
                    UiState.Successful successful = new UiState.Successful(arizonaRentFilterContainerModel2);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(arizonaRentFilterContainerModel);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(arizonaRentFilterContainerModel2);
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutableStateFlow.emit(successful, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ArizonaRentFilterContainerModel arizonaRentFilterContainerModel3 = (ArizonaRentFilterContainerModel) this.L$1;
                ArizonaRentFilterContainerModel arizonaRentFilterContainerModel4 = (ArizonaRentFilterContainerModel) this.L$0;
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
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$state, this.$filter, this.this$0, null), this) == coroutine_suspended) {
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
