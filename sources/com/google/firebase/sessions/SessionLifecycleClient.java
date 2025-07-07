package com.google.firebase.sessions;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
/* compiled from: SessionLifecycleClient.kt */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\b\u0000\u0018\u0000 $2\u00020\u0001:\u0002#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0010J \u0010\u0017\u001a\u0004\u0018\u00010\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J\u0016\u0010 \u001a\u00020!2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0003J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006%"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleClient;", "", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "queuedMessages", "Ljava/util/concurrent/LinkedBlockingDeque;", "Landroid/os/Message;", NotificationCompat.CATEGORY_SERVICE, "Landroid/os/Messenger;", "serviceBound", "", "serviceConnection", "com/google/firebase/sessions/SessionLifecycleClient$serviceConnection$1", "Lcom/google/firebase/sessions/SessionLifecycleClient$serviceConnection$1;", "backgrounded", "", "bindToService", "sessionLifecycleServiceBinder", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "drainQueue", "", "foregrounded", "getLatestByCode", "messages", "", "msgCode", "", "queueMessage", NotificationCompat.CATEGORY_MESSAGE, "sendLifecycleEvent", "messageCode", "sendLifecycleEvents", "Lkotlinx/coroutines/Job;", "sendMessageToServer", "ClientUpdateHandler", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SessionLifecycleClient {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_QUEUED_MESSAGES = 20;
    public static final String TAG = "SessionLifecycleClient";
    private final CoroutineContext backgroundDispatcher;
    private final LinkedBlockingDeque<Message> queuedMessages;
    private Messenger service;
    private boolean serviceBound;
    private final SessionLifecycleClient$serviceConnection$1 serviceConnection;

    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.firebase.sessions.SessionLifecycleClient$serviceConnection$1] */
    public SessionLifecycleClient(CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.backgroundDispatcher = backgroundDispatcher;
        this.queuedMessages = new LinkedBlockingDeque<>(20);
        this.serviceConnection = new ServiceConnection() { // from class: com.google.firebase.sessions.SessionLifecycleClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LinkedBlockingDeque linkedBlockingDeque;
                List drainQueue;
                StringBuilder sb = new StringBuilder("Connected to SessionLifecycleService. Queue size ");
                linkedBlockingDeque = SessionLifecycleClient.this.queuedMessages;
                Log.d(SessionLifecycleClient.TAG, sb.append(linkedBlockingDeque.size()).toString());
                SessionLifecycleClient.this.service = new Messenger(iBinder);
                SessionLifecycleClient.this.serviceBound = true;
                SessionLifecycleClient sessionLifecycleClient = SessionLifecycleClient.this;
                drainQueue = sessionLifecycleClient.drainQueue();
                sessionLifecycleClient.sendLifecycleEvents(drainQueue);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d(SessionLifecycleClient.TAG, "Disconnected from SessionLifecycleService");
                SessionLifecycleClient.this.service = null;
                SessionLifecycleClient.this.serviceBound = false;
            }
        };
    }

    /* compiled from: SessionLifecycleClient.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleClient$ClientUpdateHandler;", "Landroid/os/Handler;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "handleSessionUpdate", "sessionId", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ClientUpdateHandler extends Handler {
        private final CoroutineContext backgroundDispatcher;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClientUpdateHandler(CoroutineContext backgroundDispatcher) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
            this.backgroundDispatcher = backgroundDispatcher;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg.what == 3) {
                Bundle data = msg.getData();
                handleSessionUpdate((data == null || (r3 = data.getString(SessionLifecycleService.SESSION_UPDATE_EXTRA)) == null) ? "" : "");
                return;
            }
            Log.w(SessionLifecycleClient.TAG, "Received unexpected event from the SessionLifecycleService: " + msg);
            super.handleMessage(msg);
        }

        private final void handleSessionUpdate(String str) {
            Log.d(SessionLifecycleClient.TAG, "Session update received.");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(str, null), 3, null);
        }
    }

    public final void bindToService(SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        Intrinsics.checkNotNullParameter(sessionLifecycleServiceBinder, "sessionLifecycleServiceBinder");
        sessionLifecycleServiceBinder.bindToService(new Messenger(new ClientUpdateHandler(this.backgroundDispatcher)), this.serviceConnection);
    }

    public final void foregrounded() {
        sendLifecycleEvent(1);
    }

    public final void backgrounded() {
        sendLifecycleEvent(2);
    }

    private final void sendLifecycleEvent(int i) {
        List<Message> drainQueue = drainQueue();
        Message obtain = Message.obtain(null, i, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain(null, messageCode, 0, 0)");
        drainQueue.add(obtain);
        sendLifecycleEvents(drainQueue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job sendLifecycleEvents(List<Message> list) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new SessionLifecycleClient$sendLifecycleEvents$1(this, list, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendMessageToServer(Message message) {
        if (this.service != null) {
            try {
                Log.d(TAG, "Sending lifecycle " + message.what + " to service");
                Messenger messenger = this.service;
                if (messenger != null) {
                    messenger.send(message);
                    return;
                }
                return;
            } catch (RemoteException e) {
                Log.w(TAG, "Unable to deliver message: " + message.what, e);
                queueMessage(message);
                return;
            }
        }
        queueMessage(message);
    }

    private final void queueMessage(Message message) {
        if (this.queuedMessages.offer(message)) {
            Log.d(TAG, "Queued message " + message.what + ". Queue size " + this.queuedMessages.size());
        } else {
            Log.d(TAG, "Failed to enqueue message " + message.what + ". Dropping.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Message> drainQueue() {
        ArrayList arrayList = new ArrayList();
        this.queuedMessages.drainTo(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Message getLatestByCode(List<Message> list, int i) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((Message) obj2).what == i) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long when = ((Message) next).getWhen();
                do {
                    Object next2 = it.next();
                    long when2 = ((Message) next2).getWhen();
                    if (when < when2) {
                        next = next2;
                        when = when2;
                    }
                } while (it.hasNext());
                obj = next;
            } else {
                obj = next;
            }
        } else {
            obj = null;
        }
        return (Message) obj;
    }

    /* compiled from: SessionLifecycleClient.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleClient$Companion;", "", "()V", "MAX_QUEUED_MESSAGES", "", "TAG", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
