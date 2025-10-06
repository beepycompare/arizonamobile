package ru.mrlargha.feature.arizona.cases.pages;

import android.widget.LinearLayout;
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
import ru.mrlargha.feature.arizona.cases.databinding.CasesOpenPageBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CasesOpenPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.pages.CasesOpenPage$setupCollectors$1$1", f = "CasesOpenPage.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes6.dex */
public final class CasesOpenPage$setupCollectors$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CasesOpenPageBinding $this_with;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CasesOpenPage$setupCollectors$1$1(CasesOpenPageBinding casesOpenPageBinding, Continuation<? super CasesOpenPage$setupCollectors$1$1> continuation) {
        super(2, continuation);
        this.$this_with = casesOpenPageBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CasesOpenPage$setupCollectors$1$1(this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CasesOpenPage$setupCollectors$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = CasesOpenPage.isOpenState;
            final CasesOpenPageBinding casesOpenPageBinding = this.$this_with;
            this.label = 1;
            if (mutableStateFlow.collect(new FlowCollector() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesOpenPage$setupCollectors$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    if (z) {
                        LinearLayout openContainer = CasesOpenPageBinding.this.openContainer;
                        Intrinsics.checkNotNullExpressionValue(openContainer, "openContainer");
                        openContainer.setVisibility(8);
                        LinearLayout getContainer = CasesOpenPageBinding.this.getContainer;
                        Intrinsics.checkNotNullExpressionValue(getContainer, "getContainer");
                        getContainer.setVisibility(0);
                    } else {
                        LinearLayout openContainer2 = CasesOpenPageBinding.this.openContainer;
                        Intrinsics.checkNotNullExpressionValue(openContainer2, "openContainer");
                        openContainer2.setVisibility(0);
                        LinearLayout getContainer2 = CasesOpenPageBinding.this.getContainer;
                        Intrinsics.checkNotNullExpressionValue(getContainer2, "getContainer");
                        getContainer2.setVisibility(8);
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
