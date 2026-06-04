package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters;

import android.content.Context;
import android.widget.TextView;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.utils.TimeConverterKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryItemBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobileRentAccessoryMainAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1", f = "MobileRentAccessoryMainAdapter.kt", i = {0, 0, 0}, l = {132}, m = "invokeSuspend", n = {"$this$launch", "leftTime", "days"}, nl = {TsExtractor.TS_STREAM_TYPE_SPLICE_INFO}, s = {"L$0", "J$0", "J$1"}, v = 2)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MobileRentAccessoryItemBinding $this_with;
    final /* synthetic */ long $timeRemainingMillis;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MobileRentAccessoryMainAdapter.MainViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1(long j, MobileRentAccessoryItemBinding mobileRentAccessoryItemBinding, MobileRentAccessoryMainAdapter.MainViewHolder mainViewHolder, Continuation<? super MobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1> continuation) {
        super(2, continuation);
        this.$timeRemainingMillis = j;
        this.$this_with = mobileRentAccessoryItemBinding;
        this.this$0 = mainViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1 mobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1 = new MobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1(this.$timeRemainingMillis, this.$this_with, this.this$0, continuation);
        mobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1.L$0 = obj;
        return mobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0072 -> B:20:0x0075). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        Context context;
        Job job;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j = this.$timeRemainingMillis;
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            j -= 1000;
            if (j <= 0) {
                CustomCardView timeContainer = this.$this_with.timeContainer;
                Intrinsics.checkNotNullExpressionValue(timeContainer, "timeContainer");
                timeContainer.setVisibility(8);
                job = this.this$0.rentTimerJob;
                if (job != null) {
                    Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.this$0.rentTimerJob = null;
            }
            if (!CoroutineScopeKt.isActive(coroutineScope) && j > 0) {
                long days = TimeUnit.MILLISECONDS.toDays(j);
                int i2 = (days > 0L ? 1 : (days == 0L ? 0 : -1));
                MobileRentAccessoryItemBinding mobileRentAccessoryItemBinding = this.$this_with;
                if (i2 > 0) {
                    TextView textView = mobileRentAccessoryItemBinding.tvTime;
                    context = this.this$0.context;
                    textView.setText(context.getString(R.string.mobile_days_count, Boxing.boxLong(days)));
                } else {
                    mobileRentAccessoryItemBinding.tvTime.setText(TimeConverterKt.formatMillisToTime(j));
                }
                this.L$0 = coroutineScope;
                this.J$0 = j;
                this.J$1 = days;
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j -= 1000;
                if (j <= 0) {
                }
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
