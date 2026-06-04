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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: NotificationsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ui.notifications.NotificationsViewModel$viewAllNotifications$1", f = "NotificationsViewModel.kt", i = {1, 1, 2, 2, 2, 2, 2}, l = {110, 112, 115}, m = "invokeSuspend", n = {"fromDb", "listToSave", "fromDb", "listToSave", "$this$forEach$iv", "element$iv", "it"}, nl = {111, 113, 116}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$5", "L$6"}, v = 2)
/* loaded from: classes3.dex */
final class NotificationsViewModel$viewAllNotifications$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
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

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c2, code lost:
        if (r2 == r1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0174 A[LOOP:1: B:41:0x016e->B:43:0x0174, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        NotificationsRepository notificationsRepository;
        Object allNotificationFromDB;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        List list;
        Iterable iterable;
        Iterable iterable2;
        Iterable iterable3;
        Iterator it;
        List list2;
        NotificationsViewModel notificationsViewModel;
        MutableLiveData mutableLiveData4;
        Object addNotificationToDB;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            z = this.this$0.useMockNotifications;
            NotificationsViewModel notificationsViewModel2 = this.this$0;
            if (z) {
                mutableLiveData = notificationsViewModel2._notificationsLiveData;
                List list3 = (List) mutableLiveData.getValue();
                if (list3 == null) {
                    list3 = CollectionsKt.emptyList();
                }
                List<ArizonaNotification> list4 = list3;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                for (ArizonaNotification arizonaNotification : list4) {
                    arrayList.add(ArizonaNotification.copy$default(arizonaNotification, null, null, null, null, true, 15, null));
                }
                mutableLiveData2 = this.this$0._notificationsLiveData;
                mutableLiveData2.postValue(arrayList);
                mutableLiveData3 = this.this$0._notificationsCountData;
                mutableLiveData3.postValue(Boxing.boxInt(0));
                return Unit.INSTANCE;
            }
            notificationsRepository = notificationsViewModel2.notificationsRepository;
            this.label = 1;
            allNotificationFromDB = notificationsRepository.getAllNotificationFromDB(this);
        } else if (i != 1) {
            if (i == 2) {
                iterable = (List) this.L$1;
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                Log.w(NotificationsViewModel.TAG, list.toString());
                iterable2 = iterable;
                NotificationsViewModel notificationsViewModel3 = this.this$0;
                iterable3 = iterable;
                it = iterable2.iterator();
                list2 = list;
                notificationsViewModel = notificationsViewModel3;
                while (it.hasNext()) {
                }
                Iterable<NotificationHistoryData> iterable4 = iterable3;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable4, 10));
                while (r2.hasNext()) {
                }
                mutableLiveData4 = this.this$0._notificationsCountData;
                ArrayList arrayList3 = new ArrayList();
                while (r1.hasNext()) {
                }
                mutableLiveData4.postValue(Boxing.boxInt(arrayList3.size()));
                return Unit.INSTANCE;
            } else if (i == 3) {
                NotificationHistoryData notificationHistoryData = (NotificationHistoryData) this.L$6;
                it = (Iterator) this.L$4;
                notificationsViewModel = (NotificationsViewModel) this.L$3;
                iterable2 = (Iterable) this.L$2;
                iterable3 = (List) this.L$1;
                list2 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                while (it.hasNext()) {
                    Object next = it.next();
                    NotificationHistoryData notificationHistoryData2 = (NotificationHistoryData) next;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$1 = iterable3;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(iterable2);
                    this.L$3 = notificationsViewModel;
                    this.L$4 = it;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(notificationHistoryData2);
                    this.label = 3;
                    addNotificationToDB = notificationsViewModel.addNotificationToDB(notificationHistoryData2, this);
                    if (addNotificationToDB == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Iterable<NotificationHistoryData> iterable42 = iterable3;
                ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable42, 10));
                for (NotificationHistoryData notificationHistoryData3 : iterable42) {
                    arrayList22.add(ArizonaNotificationKt.toUi(notificationHistoryData3));
                }
                mutableLiveData4 = this.this$0._notificationsCountData;
                ArrayList arrayList32 = new ArrayList();
                for (Object obj2 : arrayList22) {
                    if (!((ArizonaNotification) obj2).isViewed()) {
                        arrayList32.add(obj2);
                    }
                }
                mutableLiveData4.postValue(Boxing.boxInt(arrayList32.size()));
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
        for (NotificationHistoryData notificationHistoryData4 : list6) {
            arrayList4.add(NotificationHistoryData.copy$default(notificationHistoryData4, 0, null, null, null, null, true, 31, null));
        }
        ArrayList arrayList5 = arrayList4;
        this.L$0 = list5;
        this.L$1 = arrayList5;
        this.label = 2;
        if (this.this$0.clearDB(this) != coroutine_suspended) {
            list = list5;
            iterable = arrayList5;
            Log.w(NotificationsViewModel.TAG, list.toString());
            iterable2 = iterable;
            NotificationsViewModel notificationsViewModel32 = this.this$0;
            iterable3 = iterable;
            it = iterable2.iterator();
            list2 = list;
            notificationsViewModel = notificationsViewModel32;
            while (it.hasNext()) {
            }
            Iterable<NotificationHistoryData> iterable422 = iterable3;
            ArrayList arrayList222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable422, 10));
            while (r2.hasNext()) {
            }
            mutableLiveData4 = this.this$0._notificationsCountData;
            ArrayList arrayList322 = new ArrayList();
            while (r1.hasNext()) {
            }
            mutableLiveData4.postValue(Boxing.boxInt(arrayList322.size()));
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
