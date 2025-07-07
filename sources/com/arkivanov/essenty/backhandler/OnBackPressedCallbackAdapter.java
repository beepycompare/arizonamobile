package com.arkivanov.essenty.backhandler;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import com.arkivanov.essenty.backhandler.BackEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidBackHandler.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\f\u0010\r\u001a\u00020\u000e*\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/arkivanov/essenty/backhandler/OnBackPressedCallbackAdapter;", "Landroidx/activity/OnBackPressedCallback;", "dispatcher", "Lcom/arkivanov/essenty/backhandler/BackDispatcher;", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackDispatcher;)V", "handleOnBackPressed", "", "handleOnBackStarted", "backEvent", "Landroidx/activity/BackEventCompat;", "handleOnBackProgressed", "handleOnBackCancelled", "toEssentyBackEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "back-handler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OnBackPressedCallbackAdapter extends OnBackPressedCallback {
    private final BackDispatcher dispatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnBackPressedCallbackAdapter(BackDispatcher dispatcher) {
        super(dispatcher.isEnabled());
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        dispatcher.addEnabledChangedListener(new Function1() { // from class: com.arkivanov.essenty.backhandler.OnBackPressedCallbackAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = OnBackPressedCallbackAdapter._init_$lambda$0(OnBackPressedCallbackAdapter.this, ((Boolean) obj).booleanValue());
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(OnBackPressedCallbackAdapter onBackPressedCallbackAdapter, boolean z) {
        onBackPressedCallbackAdapter.setEnabled(z);
        return Unit.INSTANCE;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        this.dispatcher.back();
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackStarted(BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        this.dispatcher.startPredictiveBack(toEssentyBackEvent(backEvent));
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackProgressed(BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        this.dispatcher.progressPredictiveBack(toEssentyBackEvent(backEvent));
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackCancelled() {
        this.dispatcher.cancelPredictiveBack();
    }

    private final BackEvent toEssentyBackEvent(BackEventCompat backEventCompat) {
        BackEvent.SwipeEdge swipeEdge;
        float progress = backEventCompat.getProgress();
        int swipeEdge2 = backEventCompat.getSwipeEdge();
        if (swipeEdge2 == 0) {
            swipeEdge = BackEvent.SwipeEdge.LEFT;
        } else if (swipeEdge2 == 1) {
            swipeEdge = BackEvent.SwipeEdge.RIGHT;
        } else {
            swipeEdge = BackEvent.SwipeEdge.UNKNOWN;
        }
        return new BackEvent(progress, swipeEdge, backEventCompat.getTouchX(), backEventCompat.getTouchY());
    }
}
