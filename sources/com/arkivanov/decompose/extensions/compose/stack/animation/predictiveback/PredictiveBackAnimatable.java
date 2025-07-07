package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.ui.Modifier;
import androidx.core.app.NotificationCompat;
import com.arkivanov.essenty.backhandler.BackEvent;
import com.facebook.widget.FacebookDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* compiled from: PredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "", "exitModifier", "Landroidx/compose/ui/Modifier;", "getExitModifier", "()Landroidx/compose/ui/Modifier;", "enterModifier", "getEnterModifier", "animate", "", NotificationCompat.CATEGORY_EVENT, "Lcom/arkivanov/essenty/backhandler/BackEvent;", "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PredictiveBackAnimatable {
    Object animate(BackEvent backEvent, Continuation<? super Unit> continuation);

    Object cancel(Continuation<? super Unit> continuation);

    Object finish(Continuation<? super Unit> continuation);

    Modifier getEnterModifier();

    Modifier getExitModifier();
}
