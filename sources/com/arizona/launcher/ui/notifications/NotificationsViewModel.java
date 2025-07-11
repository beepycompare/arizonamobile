package com.arizona.launcher.ui.notifications;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.arizona.launcher.data.repository.notifications.NotificationsRepository;
import com.arizona.launcher.data.rx.SchedulersFacade;
import com.arizona.launcher.model.notificatoins.ArizonaNotification;
import com.arizona.launcher.model.notificatoins.ArizonaNotificationKt;
import com.arizona.launcher.model.servers.NotificationHistoryData;
import com.miami.game.feature.notifications.INotificationViewModel;
import com.miami.game.feature.notifications.NotificationModel;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
/* compiled from: NotificationsViewModel.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\u0016\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0082@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010!J\b\u0010)\u001a\u00020\u001fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\r0\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/arizona/launcher/ui/notifications/NotificationsViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/miami/game/feature/notifications/INotificationViewModel;", "notificationsRepository", "Lcom/arizona/launcher/data/repository/notifications/NotificationsRepository;", "schedulers", "Lcom/arizona/launcher/data/rx/SchedulersFacade;", "<init>", "(Lcom/arizona/launcher/data/repository/notifications/NotificationsRepository;Lcom/arizona/launcher/data/rx/SchedulersFacade;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "_notificationsLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/arizona/launcher/model/notificatoins/ArizonaNotification;", "_notificationsCountData", "", "notificationsLiveData", "Landroidx/lifecycle/LiveData;", "getNotificationsLiveData", "()Landroidx/lifecycle/LiveData;", "notificationsLiveDataCompose", "Lcom/miami/game/feature/notifications/NotificationModel;", "getNotificationsLiveDataCompose", "notificationsUnViewed", "getNotificationsUnViewed", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "initial", "", "loadNotifications", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotificationHistory", "viewAllNotifications", "addNotificationToDB", "item", "Lcom/arizona/launcher/model/servers/NotificationHistoryData;", "(Lcom/arizona/launcher/model/servers/NotificationHistoryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearDB", "onCleared", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotificationsViewModel extends ViewModel implements INotificationViewModel {
    @Deprecated
    public static final String TAG = "NotificationsViewModel";
    private final MutableLiveData<Integer> _notificationsCountData;
    private final MutableLiveData<List<ArizonaNotification>> _notificationsLiveData;
    private final CompositeDisposable compositeDisposable;
    private final LiveData<List<ArizonaNotification>> notificationsLiveData;
    private final LiveData<List<NotificationModel>> notificationsLiveDataCompose;
    private final NotificationsRepository notificationsRepository;
    private final LiveData<Integer> notificationsUnViewed;
    private final SchedulersFacade schedulers;
    private final CoroutineScope scope;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Override // com.miami.game.feature.notifications.INotificationViewModel
    public void getAllNotificationHistory() {
    }

    @Inject
    public NotificationsViewModel(NotificationsRepository notificationsRepository, SchedulersFacade schedulers) {
        Intrinsics.checkNotNullParameter(notificationsRepository, "notificationsRepository");
        Intrinsics.checkNotNullParameter(schedulers, "schedulers");
        this.notificationsRepository = notificationsRepository;
        this.schedulers = schedulers;
        this.compositeDisposable = new CompositeDisposable();
        MutableLiveData<List<ArizonaNotification>> mutableLiveData = new MutableLiveData<>(CollectionsKt.emptyList());
        this._notificationsLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>(-1);
        this._notificationsCountData = mutableLiveData2;
        this.notificationsLiveData = mutableLiveData;
        this.notificationsLiveDataCompose = Transformations.map(mutableLiveData, new Function1() { // from class: com.arizona.launcher.ui.notifications.NotificationsViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List notificationsLiveDataCompose$lambda$1;
                notificationsLiveDataCompose$lambda$1 = NotificationsViewModel.notificationsLiveDataCompose$lambda$1((List) obj);
                return notificationsLiveDataCompose$lambda$1;
            }
        });
        this.notificationsUnViewed = mutableLiveData2;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob((Job) null)));
        initial();
    }

    public final LiveData<List<ArizonaNotification>> getNotificationsLiveData() {
        return this.notificationsLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List notificationsLiveDataCompose$lambda$1(List list) {
        Intrinsics.checkNotNull(list);
        List<ArizonaNotification> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ArizonaNotification arizonaNotification : list2) {
            arrayList.add(ArizonaNotificationKt.toUi(arizonaNotification));
        }
        return arrayList;
    }

    @Override // com.miami.game.feature.notifications.INotificationViewModel
    public LiveData<List<NotificationModel>> getNotificationsLiveDataCompose() {
        return this.notificationsLiveDataCompose;
    }

    @Override // com.miami.game.feature.notifications.INotificationViewModel
    public LiveData<Integer> getNotificationsUnViewed() {
        return this.notificationsUnViewed;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initial() {
        BuildersKt.launch$default(this.scope, Dispatchers.getIO(), null, new NotificationsViewModel$initial$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
        if (r1 == r3) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadNotifications(Continuation<? super Unit> continuation) {
        NotificationsViewModel$loadNotifications$1 notificationsViewModel$loadNotifications$1;
        Object coroutine_suspended;
        int i;
        Object allNotificationFromDB;
        List list;
        ArrayList arrayList;
        List list2;
        Object obj;
        List list3;
        List list4;
        Iterator it;
        Iterable iterable;
        List<ArizonaNotification> list5;
        int i2;
        if (continuation instanceof NotificationsViewModel$loadNotifications$1) {
            notificationsViewModel$loadNotifications$1 = (NotificationsViewModel$loadNotifications$1) continuation;
            if ((notificationsViewModel$loadNotifications$1.label & Integer.MIN_VALUE) != 0) {
                notificationsViewModel$loadNotifications$1.label -= Integer.MIN_VALUE;
                Object obj2 = notificationsViewModel$loadNotifications$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = notificationsViewModel$loadNotifications$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    NotificationsRepository notificationsRepository = this.notificationsRepository;
                    notificationsViewModel$loadNotifications$1.label = 1;
                    obj2 = notificationsRepository.getAllNotifications(notificationsViewModel$loadNotifications$1);
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj2);
                        list = (List) notificationsViewModel$loadNotifications$1.L$0;
                        List list6 = (List) obj2;
                        List<ArizonaNotification> list7 = list;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                        for (ArizonaNotification arizonaNotification : list7) {
                            Iterator it2 = list6.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it2.next();
                                if (Intrinsics.areEqual(((NotificationHistoryData) obj).getTitle(), arizonaNotification.getTitle())) {
                                    break;
                                }
                            }
                            NotificationHistoryData notificationHistoryData = (NotificationHistoryData) obj;
                            if (notificationHistoryData != null ? notificationHistoryData.isViewed() : false) {
                                arizonaNotification = ArizonaNotification.copy$default(arizonaNotification, null, null, null, null, true, 15, null);
                            }
                            arrayList2.add(arizonaNotification);
                        }
                        arrayList = arrayList2;
                        notificationsViewModel$loadNotifications$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        notificationsViewModel$loadNotifications$1.L$1 = SpillingKt.nullOutSpilledVariable(list6);
                        notificationsViewModel$loadNotifications$1.L$2 = arrayList;
                        notificationsViewModel$loadNotifications$1.label = 3;
                        if (clearDB(notificationsViewModel$loadNotifications$1) != coroutine_suspended) {
                            list2 = list6;
                            Log.w(TAG, arrayList.toString());
                            List<ArizonaNotification> list8 = arrayList;
                            list3 = list2;
                            list4 = list;
                            it = list8.iterator();
                            iterable = list8;
                            list5 = arrayList;
                            i2 = 0;
                            while (it.hasNext()) {
                            }
                            this._notificationsLiveData.postValue(list5);
                            MutableLiveData<Integer> mutableLiveData = this._notificationsCountData;
                            ArrayList arrayList3 = new ArrayList();
                            while (r3.hasNext()) {
                            }
                            mutableLiveData.postValue(Boxing.boxInt(arrayList3.size()));
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    } else if (i == 3) {
                        arrayList = (List) notificationsViewModel$loadNotifications$1.L$2;
                        list2 = (List) notificationsViewModel$loadNotifications$1.L$1;
                        list = (List) notificationsViewModel$loadNotifications$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Log.w(TAG, arrayList.toString());
                        List<ArizonaNotification> list82 = arrayList;
                        list3 = list2;
                        list4 = list;
                        it = list82.iterator();
                        iterable = list82;
                        list5 = arrayList;
                        i2 = 0;
                        while (it.hasNext()) {
                        }
                        this._notificationsLiveData.postValue(list5);
                        MutableLiveData<Integer> mutableLiveData2 = this._notificationsCountData;
                        ArrayList arrayList32 = new ArrayList();
                        while (r3.hasNext()) {
                        }
                        mutableLiveData2.postValue(Boxing.boxInt(arrayList32.size()));
                        return Unit.INSTANCE;
                    } else if (i == 4) {
                        int i3 = notificationsViewModel$loadNotifications$1.I$1;
                        i2 = notificationsViewModel$loadNotifications$1.I$0;
                        ArizonaNotification arizonaNotification2 = (ArizonaNotification) notificationsViewModel$loadNotifications$1.L$6;
                        Object obj3 = notificationsViewModel$loadNotifications$1.L$5;
                        it = (Iterator) notificationsViewModel$loadNotifications$1.L$4;
                        iterable = (Iterable) notificationsViewModel$loadNotifications$1.L$3;
                        list5 = (List) notificationsViewModel$loadNotifications$1.L$2;
                        list3 = (List) notificationsViewModel$loadNotifications$1.L$1;
                        list4 = (List) notificationsViewModel$loadNotifications$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        while (it.hasNext()) {
                            Object next = it.next();
                            ArizonaNotification arizonaNotification3 = (ArizonaNotification) next;
                            NotificationHistoryData db = ArizonaNotificationKt.toDb(arizonaNotification3);
                            notificationsViewModel$loadNotifications$1.L$0 = SpillingKt.nullOutSpilledVariable(list4);
                            notificationsViewModel$loadNotifications$1.L$1 = SpillingKt.nullOutSpilledVariable(list3);
                            notificationsViewModel$loadNotifications$1.L$2 = list5;
                            notificationsViewModel$loadNotifications$1.L$3 = SpillingKt.nullOutSpilledVariable(iterable);
                            notificationsViewModel$loadNotifications$1.L$4 = it;
                            notificationsViewModel$loadNotifications$1.L$5 = SpillingKt.nullOutSpilledVariable(next);
                            notificationsViewModel$loadNotifications$1.L$6 = SpillingKt.nullOutSpilledVariable(arizonaNotification3);
                            notificationsViewModel$loadNotifications$1.I$0 = i2;
                            notificationsViewModel$loadNotifications$1.I$1 = 0;
                            notificationsViewModel$loadNotifications$1.label = 4;
                            if (addNotificationToDB(db, notificationsViewModel$loadNotifications$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        this._notificationsLiveData.postValue(list5);
                        MutableLiveData<Integer> mutableLiveData22 = this._notificationsCountData;
                        ArrayList arrayList322 = new ArrayList();
                        for (Object obj4 : list5) {
                            if (!((ArizonaNotification) obj4).isViewed()) {
                                arrayList322.add(obj4);
                            }
                        }
                        mutableLiveData22.postValue(Boxing.boxInt(arrayList322.size()));
                        return Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                }
                List list9 = (List) obj2;
                NotificationsRepository notificationsRepository2 = this.notificationsRepository;
                notificationsViewModel$loadNotifications$1.L$0 = list9;
                notificationsViewModel$loadNotifications$1.label = 2;
                allNotificationFromDB = notificationsRepository2.getAllNotificationFromDB(notificationsViewModel$loadNotifications$1);
                if (allNotificationFromDB != coroutine_suspended) {
                    list = list9;
                    obj2 = allNotificationFromDB;
                    List list62 = (List) obj2;
                    List<ArizonaNotification> list72 = list;
                    ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list72, 10));
                    while (r4.hasNext()) {
                    }
                    arrayList = arrayList22;
                    notificationsViewModel$loadNotifications$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    notificationsViewModel$loadNotifications$1.L$1 = SpillingKt.nullOutSpilledVariable(list62);
                    notificationsViewModel$loadNotifications$1.L$2 = arrayList;
                    notificationsViewModel$loadNotifications$1.label = 3;
                    if (clearDB(notificationsViewModel$loadNotifications$1) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
        }
        notificationsViewModel$loadNotifications$1 = new NotificationsViewModel$loadNotifications$1(this, continuation);
        Object obj22 = notificationsViewModel$loadNotifications$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = notificationsViewModel$loadNotifications$1.label;
        if (i != 0) {
        }
        List list92 = (List) obj22;
        NotificationsRepository notificationsRepository22 = this.notificationsRepository;
        notificationsViewModel$loadNotifications$1.L$0 = list92;
        notificationsViewModel$loadNotifications$1.label = 2;
        allNotificationFromDB = notificationsRepository22.getAllNotificationFromDB(notificationsViewModel$loadNotifications$1);
        if (allNotificationFromDB != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    @Override // com.miami.game.feature.notifications.INotificationViewModel
    public void viewAllNotifications() {
        BuildersKt.launch$default(this.scope, null, null, new NotificationsViewModel$viewAllNotifications$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object addNotificationToDB(NotificationHistoryData notificationHistoryData, Continuation<? super Unit> continuation) {
        Object addNotificationToDB = this.notificationsRepository.addNotificationToDB(notificationHistoryData, continuation);
        return addNotificationToDB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addNotificationToDB : Unit.INSTANCE;
    }

    public final Object clearDB(Continuation<? super Unit> continuation) {
        Object clearDataFromDB = this.notificationsRepository.clearDataFromDB(continuation);
        return clearDataFromDB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clearDataFromDB : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    /* compiled from: NotificationsViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/ui/notifications/NotificationsViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
