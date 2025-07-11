package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt;

import android.widget.TextView;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.Arrays;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.ws.WebSocketProtocol;
import ru.mrlargha.commonui.databinding.HudCaptBinding;
/* compiled from: HudCapt.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt$startTimer$1", f = "HudCapt.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {WebSocketProtocol.PAYLOAD_SHORT, TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "invokeSuspend", n = {"pastTime", "secondsLeft", "minutes", "seconds", "pastTime", "secondsLeft", "minutes", "seconds"}, s = {"I$0", "J$0", "J$1", "J$2", "I$0", "J$0", "J$1", "J$2"})
/* loaded from: classes5.dex */
final class HudCapt$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HudCaptBinding $binding;
    final /* synthetic */ long $time;
    int I$0;
    long J$0;
    long J$1;
    long J$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HudCapt$startTimer$1(long j, HudCaptBinding hudCaptBinding, Continuation<? super HudCapt$startTimer$1> continuation) {
        super(2, continuation);
        this.$time = j;
        this.$binding = hudCaptBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HudCapt$startTimer$1(this.$time, this.$binding, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HudCapt$startTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r19) != r1) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007e -> B:20:0x0081). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            j4 = i;
            j5 = this.$time;
            if (j4 >= j5) {
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                i = this.I$0;
                ResultKt.throwOnFailure(obj);
                i += 1000;
                j4 = i;
                j5 = this.$time;
                if (j4 >= j5) {
                    j = (j5 - j4) / 1000;
                    long j6 = 60;
                    long j7 = j / j6;
                    long j8 = j % j6;
                    this.I$0 = i;
                    this.J$0 = j;
                    this.J$1 = j7;
                    this.J$2 = j8;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$binding, j7, j8, null), this) != coroutine_suspended) {
                        j3 = j8;
                        j2 = j7;
                        this.I$0 = i;
                        this.J$0 = j;
                        this.J$1 = j2;
                        this.J$2 = j3;
                        this.label = 2;
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j3 = this.J$2;
            j2 = this.J$1;
            j = this.J$0;
            i = this.I$0;
            ResultKt.throwOnFailure(obj);
            this.I$0 = i;
            this.J$0 = j;
            this.J$1 = j2;
            this.J$2 = j3;
            this.label = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HudCapt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt$startTimer$1$1", f = "HudCapt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt$startTimer$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HudCaptBinding $binding;
        final /* synthetic */ long $minutes;
        final /* synthetic */ long $seconds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HudCaptBinding hudCaptBinding, long j, long j2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$binding = hudCaptBinding;
            this.$minutes = j;
            this.$seconds = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$binding, this.$minutes, this.$seconds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TextView textView = this.$binding.tvTimer;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Boxing.boxLong(this.$minutes), Boxing.boxLong(this.$seconds)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            return Unit.INSTANCE;
        }
    }
}
