package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.bodycam;

import java.util.Arrays;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import ru.mrlargha.commonui.databinding.HudBodycamBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HudBodycam.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.bodycam.HudBodycam$startTimer$1", f = "HudBodycam.kt", i = {0, 0}, l = {58}, m = "invokeSuspend", n = {"$this$launch", "seconds"}, nl = {59}, s = {"L$0", "J$0"}, v = 2)
/* loaded from: classes6.dex */
public final class HudBodycam$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $currentTime;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HudBodycam this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HudBodycam$startTimer$1(long j, HudBodycam hudBodycam, Continuation<? super HudBodycam$startTimer$1> continuation) {
        super(2, continuation);
        this.$currentTime = j;
        this.this$0 = hudBodycam;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HudBodycam$startTimer$1 hudBodycam$startTimer$1 = new HudBodycam$startTimer$1(this.$currentTime, this.this$0, continuation);
        hudBodycam$startTimer$1.L$0 = obj;
        return hudBodycam$startTimer$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HudBodycam$startTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0039 -> B:14:0x003c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        HudBodycamBinding hudBodycamBinding;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j = this.$currentTime;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            j += 1000;
            long hours = TimeUnit.MILLISECONDS.toHours(j);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Boxing.boxLong(hours), Boxing.boxLong(TimeUnit.MILLISECONDS.toMinutes(j) % 60), Boxing.boxLong(TimeUnit.MILLISECONDS.toSeconds(j) % 60)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            hudBodycamBinding = this.this$0.binding;
            hudBodycamBinding.tvTimer.setText(format);
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                this.L$0 = coroutineScope;
                this.J$0 = j;
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j += 1000;
                long hours2 = TimeUnit.MILLISECONDS.toHours(j);
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Boxing.boxLong(hours2), Boxing.boxLong(TimeUnit.MILLISECONDS.toMinutes(j) % 60), Boxing.boxLong(TimeUnit.MILLISECONDS.toSeconds(j) % 60)}, 3));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                hudBodycamBinding = this.this$0.binding;
                hudBodycamBinding.tvTimer.setText(format2);
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
