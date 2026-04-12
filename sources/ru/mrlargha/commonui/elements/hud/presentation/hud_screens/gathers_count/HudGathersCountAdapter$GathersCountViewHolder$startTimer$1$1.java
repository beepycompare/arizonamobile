package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.extractor.ts.TsExtractor;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudGathersCountItemBinding;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count.HudGathersCountAdapter;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HudGathersCountAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count.HudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1", f = "HudGathersCountAdapter.kt", i = {0, 0}, l = {70}, m = "invokeSuspend", n = {"$this$launch", "seconds"}, nl = {TsExtractor.TS_SYNC_BYTE}, s = {"L$0", "I$0"}, v = 2)
/* loaded from: classes6.dex */
public final class HudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HudGathersCountItemBinding $this_with;
    final /* synthetic */ int $time;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HudGathersCountAdapter.GathersCountViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1(int i, HudGathersCountItemBinding hudGathersCountItemBinding, HudGathersCountAdapter.GathersCountViewHolder gathersCountViewHolder, Continuation<? super HudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1> continuation) {
        super(2, continuation);
        this.$time = i;
        this.$this_with = hudGathersCountItemBinding;
        this.this$0 = gathersCountViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1 hudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1 = new HudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1(this.$time, this.$this_with, this.this$0, continuation);
        hudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1.L$0 = obj;
        return hudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:15:0x003d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            i = this.$time;
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
            }
            return Unit.INSTANCE;
        } else if (i2 == 1) {
            i = this.I$0;
            ResultKt.throwOnFailure(obj);
            TextView tvTimer = this.$this_with.tvTimer;
            Intrinsics.checkNotNullExpressionValue(tvTimer, "tvTimer");
            UtilsKt.setTextTimeFormat(tvTimer, i);
            if (i == 0) {
                this.$this_with.ivBg.setImageResource(R.drawable.hud_gather_count_active_item_bg);
                LinearLayout activeContainer = this.$this_with.activeContainer;
                Intrinsics.checkNotNullExpressionValue(activeContainer, "activeContainer");
                activeContainer.setVisibility(8);
                ImageView ivInactiveIc = this.$this_with.ivInactiveIc;
                Intrinsics.checkNotNullExpressionValue(ivInactiveIc, "ivInactiveIc");
                ivInactiveIc.setVisibility(0);
                this.this$0.stopTimer();
            }
            i--;
            if (!CoroutineScopeKt.isActive(coroutineScope) && i >= 0) {
                this.L$0 = coroutineScope;
                this.I$0 = i;
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TextView tvTimer2 = this.$this_with.tvTimer;
                Intrinsics.checkNotNullExpressionValue(tvTimer2, "tvTimer");
                UtilsKt.setTextTimeFormat(tvTimer2, i);
                if (i == 0) {
                }
                i--;
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
