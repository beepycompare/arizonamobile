package com.arkivanov.decompose.extensions.compose.pages;

import androidx.compose.foundation.pager.PagerState;
import androidx.media3.extractor.ts.TsExtractor;
import com.arkivanov.decompose.extensions.compose.pages.PagesScrollAnimation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: ChildPages.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$4$1", f = "ChildPages.kt", i = {}, l = {69, 70, TsExtractor.TS_SYNC_BYTE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class ChildPagesKt$ChildPages$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagesScrollAnimation $scrollAnimation;
    final /* synthetic */ int $selectedIndex;
    final /* synthetic */ PagerState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChildPagesKt$ChildPages$4$1(PagerState pagerState, int i, PagesScrollAnimation pagesScrollAnimation, Continuation<? super ChildPagesKt$ChildPages$4$1> continuation) {
        super(2, continuation);
        this.$state = pagerState;
        this.$selectedIndex = i;
        this.$scrollAnimation = pagesScrollAnimation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChildPagesKt$ChildPages$4$1(this.$state, this.$selectedIndex, this.$scrollAnimation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChildPagesKt$ChildPages$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (androidx.compose.foundation.pager.PagerState.scrollToPage$default(r12.$state, r6, 0.0f, r12, 2, null) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (androidx.compose.foundation.pager.PagerState.animateScrollToPage$default(r12.$state, r6, 0.0f, null, r12, 6, null) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
        if (androidx.compose.foundation.pager.PagerState.animateScrollToPage$default(r12.$state, r6, 0.0f, ((com.arkivanov.decompose.extensions.compose.pages.PagesScrollAnimation.Custom) r13).getSpec(), r12, 2, null) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0072, code lost:
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
            int currentPage = this.$state.getCurrentPage();
            int i2 = this.$selectedIndex;
            if (currentPage != i2) {
                PagesScrollAnimation pagesScrollAnimation = this.$scrollAnimation;
                if (pagesScrollAnimation instanceof PagesScrollAnimation.Disabled) {
                    this.label = 1;
                } else if (pagesScrollAnimation instanceof PagesScrollAnimation.Default) {
                    this.label = 2;
                } else if (!(pagesScrollAnimation instanceof PagesScrollAnimation.Custom)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    this.label = 3;
                }
            }
        } else if (i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
