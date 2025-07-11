package com.arizona.launcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.arizona.launcher.UpdateService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$checkUpdate$stringRequest$1$1", f = "UpdateService.kt", i = {1}, l = {349, 350}, m = "invokeSuspend", n = {"gameDataInfo"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class UpdateService$checkUpdate$stringRequest$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$checkUpdate$stringRequest$1$1(UpdateService updateService, Continuation<? super UpdateService$checkUpdate$stringRequest$1$1> continuation) {
        super(2, continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateService$checkUpdate$stringRequest$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdateService$checkUpdate$stringRequest$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r7 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0058, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.arizona.launcher.UpdateService$checkUpdate$stringRequest$1$1.AnonymousClass1(r6.this$0, r7, null), r6) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        JSONArray jSONArray;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UpdateService updateService = this.this$0;
            jSONArray = updateService.mDataInfo;
            this.label = 1;
            obj = updateService.checkGameDataUpdate(jSONArray, this);
        } else if (i != 1) {
            if (i == 2) {
                Pair pair = (Pair) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Pair pair2 = (Pair) obj;
        this.L$0 = SpillingKt.nullOutSpilledVariable(pair2);
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.UpdateService$checkUpdate$stringRequest$1$1$1", f = "UpdateService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.arizona.launcher.UpdateService$checkUpdate$stringRequest$1$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Pair<List<String>, Long> $gameDataInfo;
        int label;
        final /* synthetic */ UpdateService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(UpdateService updateService, Pair<? extends List<String>, Long> pair, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = updateService;
            this.$gameDataInfo = pair;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$gameDataInfo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean isGameDataUpdateExists;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.mUpdateFilesNeedSize = this.$gameDataInfo.getSecond().longValue();
            this.this$0.mUpdateFiles = this.$gameDataInfo.getFirst();
            this.this$0.resetGameStatus();
            this.this$0.setUpdateStatus(UpdateService.UpdateStatus.Undefined);
            Message obtain = Message.obtain(this.this$0.mInHandler, 0);
            obtain.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, true);
            Bundle data = obtain.getData();
            isGameDataUpdateExists = this.this$0.isGameDataUpdateExists();
            data.putBoolean("isGameDataUpdateExists", isGameDataUpdateExists);
            obtain.getData().putLong("total_size", this.this$0.mUpdateFilesNeedSize);
            obtain.getData().putSerializable(UpdateService.ERRNO_MSG, this.this$0.mLastOperationStatus);
            obtain.replyTo = this.this$0.mMessenger;
            Messenger messenger = this.this$0.mActivityMessenger;
            if (messenger != null) {
                messenger.send(obtain);
            }
            Log.i("UPDATE_SERVICE", "Send message check update " + obtain);
            this.this$0.stopForegroundService();
            return Unit.INSTANCE;
        }
    }
}
