package com.arizona.launcher.ui.notifications;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.arizona.launcher.data.repository.notifications.NotificationsRepository;
import com.arizona.launcher.model.notificatoins.ArizonaNotification;
import com.arizona.launcher.model.notificatoins.ArizonaNotificationKt;
import com.arizona.launcher.model.servers.NotificationHistoryData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: NotificationsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ui.notifications.NotificationsViewModel$viewAllNotifications$1", f = "NotificationsViewModel.kt", i = {1, 1, 2}, l = {96, 98, 101}, m = "invokeSuspend", n = {"fromDb", "listToSave", "listToSave"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes3.dex */
final class NotificationsViewModel$viewAllNotifications$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ NotificationsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationsViewModel$viewAllNotifications$1(NotificationsViewModel notificationsViewModel, Continuation<? super NotificationsViewModel$viewAllNotifications$1> continuation) {
        super(2, continuation);
        this.this$0 = notificationsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationsViewModel$viewAllNotifications$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationsViewModel$viewAllNotifications$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
        if (r2 == r1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ea A[LOOP:1: B:30:0x00e4->B:32:0x00ea, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0113  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NotificationsRepository notificationsRepository;
        Object allNotificationFromDB;
        List list;
        List list2;
        List list3;
        Iterator it;
        NotificationsViewModel notificationsViewModel;
        MutableLiveData mutableLiveData;
        Object addNotificationToDB;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            notificationsRepository = this.this$0.notificationsRepository;
            this.label = 1;
            allNotificationFromDB = notificationsRepository.getAllNotificationFromDB(this);
        } else if (i != 1) {
            if (i == 2) {
                list2 = (List) this.L$1;
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                Log.w(NotificationsViewModel.TAG, list.toString());
                NotificationsViewModel notificationsViewModel2 = this.this$0;
                list3 = list2;
                it = list2.iterator();
                notificationsViewModel = notificationsViewModel2;
                while (it.hasNext()) {
                }
                List<NotificationHistoryData> list4 = list3;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                while (r2.hasNext()) {
                }
                mutableLiveData = this.this$0._notificationsCountData;
                ArrayList arrayList2 = new ArrayList();
                while (r1.hasNext()) {
                }
                mutableLiveData.postValue(Boxing.boxInt(arrayList2.size()));
                return Unit.INSTANCE;
            } else if (i == 3) {
                it = (Iterator) this.L$2;
                notificationsViewModel = (NotificationsViewModel) this.L$1;
                list3 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                while (it.hasNext()) {
                    this.L$0 = list3;
                    this.L$1 = notificationsViewModel;
                    this.L$2 = it;
                    this.label = 3;
                    addNotificationToDB = notificationsViewModel.addNotificationToDB((NotificationHistoryData) it.next(), this);
                    if (addNotificationToDB == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                List<NotificationHistoryData> list42 = list3;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list42, 10));
                for (NotificationHistoryData notificationHistoryData : list42) {
                    arrayList3.add(ArizonaNotificationKt.toUi(notificationHistoryData));
                }
                mutableLiveData = this.this$0._notificationsCountData;
                ArrayList arrayList22 = new ArrayList();
                for (Object obj2 : arrayList3) {
                    if (!((ArizonaNotification) obj2).isViewed()) {
                        arrayList22.add(obj2);
                    }
                }
                mutableLiveData.postValue(Boxing.boxInt(arrayList22.size()));
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            allNotificationFromDB = obj;
        }
        List list5 = (List) allNotificationFromDB;
        List<NotificationHistoryData> list6 = list5;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
        for (NotificationHistoryData notificationHistoryData2 : list6) {
            arrayList4.add(NotificationHistoryData.copy$default(notificationHistoryData2, 0, null, null, null, null, true, 31, null));
        }
        ArrayList arrayList5 = arrayList4;
        this.L$0 = list5;
        this.L$1 = arrayList5;
        this.label = 2;
        if (this.this$0.clearDB(this) != coroutine_suspended) {
            list = list5;
            list2 = arrayList5;
            Log.w(NotificationsViewModel.TAG, list.toString());
            NotificationsViewModel notificationsViewModel22 = this.this$0;
            list3 = list2;
            it = list2.iterator();
            notificationsViewModel = notificationsViewModel22;
            while (it.hasNext()) {
            }
            List<NotificationHistoryData> list422 = list3;
            ArrayList arrayList32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list422, 10));
            while (r2.hasNext()) {
            }
            mutableLiveData = this.this$0._notificationsCountData;
            ArrayList arrayList222 = new ArrayList();
            while (r1.hasNext()) {
            }
            mutableLiveData.postValue(Boxing.boxInt(arrayList222.size()));
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
