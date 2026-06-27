package com.arizona.launcher;

import android.util.Log;
import com.arizona.launcher.data.database.ArizonaDatabase;
import com.arizona.launcher.data.database.NotificationHistoryDAO;
import com.arizona.launcher.model.servers.NotificationHistoryData;
import com.miami.game.core.firebase.notification.PushNotificationPayload;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessagingService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.MessagingService$saveNotificationData$1", f = "MessagingService.kt", i = {0, 0}, l = {144}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240"}, nl = {BuiltInsProtoBuf.PROPERTY_GETTER_ANNOTATION_FIELD_NUMBER}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
public final class MessagingService$saveNotificationData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArizonaDatabase $appDatabase;
    final /* synthetic */ PushNotificationPayload $payload;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MessagingService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessagingService$saveNotificationData$1(ArizonaDatabase arizonaDatabase, PushNotificationPayload pushNotificationPayload, MessagingService messagingService, Continuation<? super MessagingService$saveNotificationData$1> continuation) {
        super(2, continuation);
        this.$appDatabase = arizonaDatabase;
        this.$payload = pushNotificationPayload;
        this.this$0 = messagingService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MessagingService$saveNotificationData$1 messagingService$saveNotificationData$1 = new MessagingService$saveNotificationData$1(this.$appDatabase, this.$payload, this.this$0, continuation);
        messagingService$saveNotificationData$1.L$0 = obj;
        return messagingService$saveNotificationData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MessagingService$saveNotificationData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9896constructorimpl;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ArizonaDatabase arizonaDatabase = this.$appDatabase;
                PushNotificationPayload pushNotificationPayload = this.$payload;
                MessagingService messagingService = this.this$0;
                Result.Companion companion = Result.Companion;
                NotificationHistoryDAO notificationHistoryDAO = arizonaDatabase.notificationHistoryDAO();
                String title = pushNotificationPayload.getTitle();
                String body = pushNotificationPayload.getBody();
                String imageUrl = pushNotificationPayload.getImageUrl();
                if (imageUrl == null) {
                    imageUrl = messagingService.defaultNotificationImageUrl();
                }
                NotificationHistoryData notificationHistoryData = new NotificationHistoryData(0, null, title, body, imageUrl, false, 33, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.label = 1;
                if (notificationHistoryDAO.addNotification(notificationHistoryData, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            m9896constructorimpl = Result.m9896constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9896constructorimpl = Result.m9896constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9899exceptionOrNullimpl = Result.m9899exceptionOrNullimpl(m9896constructorimpl);
        if (m9899exceptionOrNullimpl != null) {
            Log.w(MessagingService.TAG, "Failed to write notification history", m9899exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }
}
