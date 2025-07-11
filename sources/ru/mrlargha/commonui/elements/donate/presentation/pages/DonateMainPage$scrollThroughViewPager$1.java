package ru.mrlargha.commonui.elements.donate.presentation.pages;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.Renderer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
/* compiled from: DonateMainPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateMainPage$scrollThroughViewPager$1", f = "DonateMainPage.kt", i = {0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class DonateMainPage$scrollThroughViewPager$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewPager2 $viewPager;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateMainPage$scrollThroughViewPager$1(ViewPager2 viewPager2, Continuation<? super DonateMainPage$scrollThroughViewPager$1> continuation) {
        super(2, continuation);
        this.$viewPager = viewPager2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DonateMainPage$scrollThroughViewPager$1 donateMainPage$scrollThroughViewPager$1 = new DonateMainPage$scrollThroughViewPager$1(this.$viewPager, continuation);
        donateMainPage$scrollThroughViewPager$1.L$0 = obj;
        return donateMainPage$scrollThroughViewPager$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateMainPage$scrollThroughViewPager$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0031 -> B:14:0x0034). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            RecyclerView.Adapter adapter = this.$viewPager.getAdapter();
            if (adapter == null) {
                return Unit.INSTANCE;
            }
            int itemCount = adapter.getItemCount();
            if (itemCount < 2) {
                return Unit.INSTANCE;
            }
            this.$viewPager.setCurrentItem(this.$viewPager.getCurrentItem() + 1 >= itemCount ? 0 : this.$viewPager.getCurrentItem() + 1, true);
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                RecyclerView.Adapter adapter2 = this.$viewPager.getAdapter();
                if (adapter2 == null) {
                }
            } else {
                return Unit.INSTANCE;
            }
        }
    }
}
