package com.arizona.launcher;

import android.net.Uri;
import com.arizona.launcher.data.database.ArizonaDatabase;
import com.arizona.launcher.data.database.NotificationHistoryDAO;
import com.arizona.launcher.model.servers.NotificationHistoryData;
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
/* compiled from: MessagingService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.MessagingService$saveNotificationData$1", f = "MessagingService.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class MessagingService$saveNotificationData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArizonaDatabase $appDatabase;
    final /* synthetic */ Uri $imageUrl;
    final /* synthetic */ String $text;
    final /* synthetic */ String $title;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessagingService$saveNotificationData$1(ArizonaDatabase arizonaDatabase, String str, String str2, Uri uri, Continuation<? super MessagingService$saveNotificationData$1> continuation) {
        super(2, continuation);
        this.$appDatabase = arizonaDatabase;
        this.$title = str;
        this.$text = str2;
        this.$imageUrl = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessagingService$saveNotificationData$1(this.$appDatabase, this.$title, this.$text, this.$imageUrl, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MessagingService$saveNotificationData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NotificationHistoryDAO notificationHistoryDAO = this.$appDatabase.notificationHistoryDAO();
            String str = this.$title;
            String str2 = this.$text;
            String uri = this.$imageUrl.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            this.label = 1;
            if (notificationHistoryDAO.addNotification(new NotificationHistoryData(0, null, str, str2, uri, false, 33, null), this) == coroutine_suspended) {
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
