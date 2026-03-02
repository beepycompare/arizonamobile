package ru.mrlargha.feature.arizona.cases.pages;

import android.util.Log;
import android.widget.LinearLayout;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.feature.arizona.cases.CasesInfoModel;
import ru.mrlargha.feature.arizona.cases.databinding.ArizonaCasesMainPageBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CasesMainPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$setupCollectors$1$1", f = "CasesMainPage.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, nl = {150}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class CasesMainPage$setupCollectors$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArizonaCasesMainPageBinding $this_with;
    int label;
    final /* synthetic */ CasesMainPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CasesMainPage$setupCollectors$1$1(CasesMainPage casesMainPage, ArizonaCasesMainPageBinding arizonaCasesMainPageBinding, Continuation<? super CasesMainPage$setupCollectors$1$1> continuation) {
        super(2, continuation);
        this.this$0 = casesMainPage;
        this.$this_with = arizonaCasesMainPageBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CasesMainPage$setupCollectors$1$1(this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CasesMainPage$setupCollectors$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CasesMainPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$setupCollectors$1$1$1", f = "CasesMainPage.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, nl = {149}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$setupCollectors$1$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArizonaCasesMainPageBinding $this_with;
        int label;
        final /* synthetic */ CasesMainPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CasesMainPage casesMainPage, ArizonaCasesMainPageBinding arizonaCasesMainPageBinding, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = casesMainPage;
            this.$this_with = arizonaCasesMainPageBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$this_with, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CasesMainPage.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/arizona/cases/CasesInfoModel;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$setupCollectors$1$1$1$1", f = "CasesMainPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        /* renamed from: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$setupCollectors$1$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C00851 extends SuspendLambda implements Function2<CasesInfoModel, Continuation<? super Unit>, Object> {
            final /* synthetic */ ArizonaCasesMainPageBinding $this_with;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CasesMainPage this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00851(ArizonaCasesMainPageBinding arizonaCasesMainPageBinding, CasesMainPage casesMainPage, Continuation<? super C00851> continuation) {
                super(2, continuation);
                this.$this_with = arizonaCasesMainPageBinding;
                this.this$0 = casesMainPage;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00851 c00851 = new C00851(this.$this_with, this.this$0, continuation);
                c00851.L$0 = obj;
                return c00851;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CasesInfoModel casesInfoModel, Continuation<? super Unit> continuation) {
                return ((C00851) create(casesInfoModel, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CasesInfoModel casesInfoModel = (CasesInfoModel) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Log.d("Cases", "main setupCollectors: " + casesInfoModel);
                if (casesInfoModel != null) {
                    ArizonaCasesMainPageBinding arizonaCasesMainPageBinding = this.$this_with;
                    CasesMainPage casesMainPage = this.this$0;
                    arizonaCasesMainPageBinding.tvAvailableUntil.setText(casesInfoModel.getAvailableUntil());
                    LinearLayout availableUntilConateiner = arizonaCasesMainPageBinding.availableUntilConateiner;
                    Intrinsics.checkNotNullExpressionValue(availableUntilConateiner, "availableUntilConateiner");
                    LinearLayout linearLayout = availableUntilConateiner;
                    CharSequence text = arizonaCasesMainPageBinding.tvAvailableUntil.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                    linearLayout.setVisibility(text.length() == 0 ? 8 : 0);
                    casesMainPage.checkIsHavaCase(casesInfoModel);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0.modelState;
                this.label = 1;
                if (FlowKt.collectLatest(mutableStateFlow, new C00851(this.$this_with, this.this$0, null), this) == coroutine_suspended) {
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
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, this.$this_with, null), this) == coroutine_suspended) {
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
