package com.miami.game.core.firebase.notification.data;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.miami.game.core.local.repository.common.LocalRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;
/* compiled from: MessagingRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\n0\fH\u0002J\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/firebase/notification/data/MessagingRepository;", "", "localRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "<init>", "(Lcom/miami/game/core/local/repository/common/LocalRepository;)V", "Ljavax/inject/Inject;", "tokenKey", "", "getCurrentToken", "", "callback", "Lkotlin/Function1;", "synchroniseToken", "saveToken", "token", "getSavedToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessagingRepository {
    private final LocalRepository localRepository;
    private final String tokenKey;

    @Inject
    public MessagingRepository(LocalRepository localRepository) {
        Intrinsics.checkNotNullParameter(localRepository, "localRepository");
        this.localRepository = localRepository;
        this.tokenKey = "FIREBASE_MESSAGING_TOKEN";
        Timber.Forest.d("messaging repo init", new Object[0]);
        synchroniseToken();
    }

    private final void getCurrentToken(final Function1<? super String, Unit> function1) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.miami.game.core.firebase.notification.data.MessagingRepository$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MessagingRepository.getCurrentToken$lambda$0(Function1.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void getCurrentToken$lambda$0(Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            function1.invoke(null);
        } else {
            function1.invoke((String) task.getResult());
        }
    }

    public final void synchroniseToken() {
        getCurrentToken(new Function1() { // from class: com.miami.game.core.firebase.notification.data.MessagingRepository$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessagingRepository.synchroniseToken$lambda$0(MessagingRepository.this, (String) obj);
            }
        });
        Unit unit = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit synchroniseToken$lambda$0(MessagingRepository messagingRepository, String str) {
        if (str != null) {
            messagingRepository.saveToken(str);
            Timber.Forest.d("token = " + str, new Object[0]);
        }
        return Unit.INSTANCE;
    }

    public final void saveToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MessagingRepository$saveToken$1(this, token, null), 3, null);
    }

    public final Object getSavedToken(Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MessagingRepository$getSavedToken$$inlined$getSuspend$1(this.localRepository, this.tokenKey, null), continuation);
    }
}
