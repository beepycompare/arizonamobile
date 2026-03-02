package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.widget.TextView;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentAddPageBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentCreateAdModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentAddPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$4$1$1", f = "ArizonaRentAddPage.kt", i = {}, l = {187, DownloaderService.STATUS_PAUSED_BY_APP}, m = "invokeSuspend", n = {}, nl = {191, DownloaderService.STATUS_QUEUED_FOR_WIFI}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class ArizonaRentAddPage$setupListeners$1$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EditTextCheckResult $result;
    final /* synthetic */ MpArizonaRentAddPageBinding $this_with;
    int label;
    final /* synthetic */ ArizonaRentAddPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentAddPage$setupListeners$1$4$1$1(EditTextCheckResult editTextCheckResult, ArizonaRentAddPage arizonaRentAddPage, MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding, Continuation<? super ArizonaRentAddPage$setupListeners$1$4$1$1> continuation) {
        super(2, continuation);
        this.$result = editTextCheckResult;
        this.this$0 = arizonaRentAddPage;
        this.$this_with = mpArizonaRentAddPageBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentAddPage$setupListeners$1$4$1$1(this.$result, this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentAddPage$setupListeners$1$4$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005b, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$4$1$1.AnonymousClass1(r8.this$0, null), r8) == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0092, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$4$1$1.AnonymousClass2(r8.this$0, r8.$this_with, null), r8) == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$result == EditTextCheckResult.EMPTY_VALUE) {
                ArizonaRentAddPage arizonaRentAddPage = this.this$0;
                CustomCardView descContainer = this.$this_with.descContainer;
                Intrinsics.checkNotNullExpressionValue(descContainer, "descContainer");
                arizonaRentAddPage.isError(true, descContainer);
                TextView tvDescError = this.$this_with.tvDescError;
                Intrinsics.checkNotNullExpressionValue(tvDescError, "tvDescError");
                tvDescError.setVisibility(0);
                this.label = 1;
            } else {
                TextView tvDescError2 = this.$this_with.tvDescError;
                Intrinsics.checkNotNullExpressionValue(tvDescError2, "tvDescError");
                tvDescError2.setVisibility(8);
                ArizonaRentAddPage arizonaRentAddPage2 = this.this$0;
                CustomCardView descContainer2 = this.$this_with.descContainer;
                Intrinsics.checkNotNullExpressionValue(descContainer2, "descContainer");
                arizonaRentAddPage2.isError(false, descContainer2);
                this.label = 2;
            }
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArizonaRentAddPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$4$1$1$1", f = "ArizonaRentAddPage.kt", i = {}, l = {TsExtractor.TS_PACKET_SIZE}, m = "invokeSuspend", n = {}, nl = {PsExtractor.PRIVATE_STREAM_1}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$4$1$1$1  reason: invalid class name */
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
                if (mutableStateFlow.emit(ArizonaRentCreateAdModel.copy$default((ArizonaRentCreateAdModel) mutableStateFlow2.getValue(), null, null, null, null, null, null, 59, null), this) == coroutine_suspended) {
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
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$4$1$1$2", f = "ArizonaRentAddPage.kt", i = {}, l = {DownloaderService.STATUS_WAITING_TO_RETRY}, m = "invokeSuspend", n = {}, nl = {DownloaderService.STATUS_WAITING_FOR_NETWORK}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$4$1$1$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MpArizonaRentAddPageBinding $this_with;
        int label;
        final /* synthetic */ ArizonaRentAddPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ArizonaRentAddPage arizonaRentAddPage, MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = arizonaRentAddPage;
            this.$this_with = mpArizonaRentAddPageBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$this_with, continuation);
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
                if (mutableStateFlow.emit(ArizonaRentCreateAdModel.copy$default((ArizonaRentCreateAdModel) mutableStateFlow2.getValue(), null, null, this.$this_with.tvDesc.getText().toString(), null, null, null, 59, null), this) == coroutine_suspended) {
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
