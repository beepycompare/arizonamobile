package ru.mrlargha.feature.arizona.cases.pages;

import android.widget.LinearLayout;
import androidx.compose.material3.MenuKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.feature.arizona.cases.CasesInfoModel;
import ru.mrlargha.feature.arizona.cases.databinding.CasesMainPageBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CasesMainPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$setupCollectors$1$1", f = "CasesMainPage.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes6.dex */
public final class CasesMainPage$setupCollectors$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CasesMainPageBinding $this_with;
    int label;
    final /* synthetic */ CasesMainPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CasesMainPage$setupCollectors$1$1(CasesMainPage casesMainPage, CasesMainPageBinding casesMainPageBinding, Continuation<? super CasesMainPage$setupCollectors$1$1> continuation) {
        super(2, continuation);
        this.this$0 = casesMainPage;
        this.$this_with = casesMainPageBinding;
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
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$setupCollectors$1$1$1", f = "CasesMainPage.kt", i = {}, l = {MenuKt.InTransitionDuration}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$setupCollectors$1$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CasesMainPageBinding $this_with;
        int label;
        final /* synthetic */ CasesMainPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CasesMainPage casesMainPage, CasesMainPageBinding casesMainPageBinding, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = casesMainPage;
            this.$this_with = casesMainPageBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$this_with, continuation);
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
                mutableStateFlow = this.this$0.modelState;
                final CasesMainPageBinding casesMainPageBinding = this.$this_with;
                final CasesMainPage casesMainPage = this.this$0;
                this.label = 1;
                if (mutableStateFlow.collect(new FlowCollector() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage.setupCollectors.1.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((CasesInfoModel) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(CasesInfoModel casesInfoModel, Continuation<? super Unit> continuation) {
                        if (casesInfoModel != null) {
                            CasesMainPageBinding casesMainPageBinding2 = CasesMainPageBinding.this;
                            CasesMainPage casesMainPage2 = casesMainPage;
                            casesMainPageBinding2.tvAvailableUntil.setText(casesInfoModel.getAvailableUntil());
                            LinearLayout availableUntilConateiner = casesMainPageBinding2.availableUntilConateiner;
                            Intrinsics.checkNotNullExpressionValue(availableUntilConateiner, "availableUntilConateiner");
                            LinearLayout linearLayout = availableUntilConateiner;
                            CharSequence text = casesMainPageBinding2.tvAvailableUntil.getText();
                            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                            linearLayout.setVisibility(text.length() == 0 ? 8 : 0);
                            casesMainPageBinding2.tvCountLeft.setText(casesInfoModel.m11348getCountLeft());
                            casesMainPage2.checkIsHavaCase(casesInfoModel);
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
