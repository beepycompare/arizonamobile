package androidx.compose.foundation.text.contextmenu.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.View;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidTextContextMenuToolbarProvider.android.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2", f = "AndroidTextContextMenuToolbarProvider.android.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
final class AndroidTextContextMenuToolbarProvider$showTextContextMenu$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ TextContextMenuDataProvider $dataProvider;
    int label;
    final /* synthetic */ AndroidTextContextMenuToolbarProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidTextContextMenuToolbarProvider$showTextContextMenu$2(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, TextContextMenuDataProvider textContextMenuDataProvider, Continuation<? super AndroidTextContextMenuToolbarProvider$showTextContextMenu$2> continuation) {
        super(1, continuation);
        this.this$0 = androidTextContextMenuToolbarProvider;
        this.$dataProvider = textContextMenuDataProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AndroidTextContextMenuToolbarProvider$showTextContextMenu$2(this.this$0, this.$dataProvider, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AndroidTextContextMenuToolbarProvider$showTextContextMenu$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SnapshotStateObserver snapshotStateObserver;
        Looper myLooper;
        View view;
        Handler handler;
        ActionMode actionMode;
        Runnable runnable;
        View view2;
        Runnable runnable2;
        View view3;
        final TextActionModeCallback createActionModeCallback;
        View view4;
        View view5;
        Runnable runnable3;
        View view6;
        ActionMode actionMode2;
        Runnable runnable4;
        View view7;
        Runnable runnable5;
        View view8;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl textContextMenuSessionImpl = new AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl();
                createActionModeCallback = this.this$0.createActionModeCallback(textContextMenuSessionImpl, this.$dataProvider);
                Looper myLooper2 = Looper.myLooper();
                view4 = this.this$0.view;
                Handler handler2 = view4.getHandler();
                Looper looper = handler2 != null ? handler2.getLooper() : null;
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = this.this$0;
                if (myLooper2 != looper) {
                    runnable3 = androidTextContextMenuToolbarProvider.startActionModeRunnable;
                    if (runnable3 == null) {
                        final AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider2 = this.this$0;
                        Runnable runnable6 = new Runnable() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                AndroidTextContextMenuToolbarProvider$showTextContextMenu$2.invokeSuspend$lambda$0(AndroidTextContextMenuToolbarProvider.this, createActionModeCallback, textContextMenuSessionImpl);
                            }
                        };
                        this.this$0.startActionModeRunnable = runnable6;
                        runnable3 = runnable6;
                    }
                    view6 = this.this$0.view;
                    Boxing.boxBoolean(view6.post(runnable3));
                } else {
                    TextToolbarHelper textToolbarHelper = TextToolbarHelper.INSTANCE;
                    view5 = this.this$0.view;
                    ActionMode startActionMode = textToolbarHelper.startActionMode(view5, createActionModeCallback);
                    if (startActionMode == null) {
                        return Unit.INSTANCE;
                    }
                    androidTextContextMenuToolbarProvider.actionMode = startActionMode;
                }
                this.label = 1;
                if (textContextMenuSessionImpl.awaitClose(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            Looper looper2 = handler != null ? handler.getLooper() : null;
            AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider3 = this.this$0;
            if (myLooper != looper2) {
                runnable5 = androidTextContextMenuToolbarProvider3.finishActionModeRunnable;
                if (runnable5 == null) {
                    final AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider4 = this.this$0;
                    Runnable runnable7 = new Runnable() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AndroidTextContextMenuToolbarProvider$showTextContextMenu$2.invokeSuspend$lambda$2(AndroidTextContextMenuToolbarProvider.this);
                        }
                    };
                    this.this$0.finishActionModeRunnable = runnable7;
                    runnable5 = runnable7;
                }
                view8 = this.this$0.view;
                Boxing.boxBoolean(view8.post(runnable5));
            } else {
                actionMode2 = androidTextContextMenuToolbarProvider3.actionMode;
                if (actionMode2 != null) {
                    actionMode2.finish();
                }
            }
            runnable4 = this.this$0.startActionModeRunnable;
            if (runnable4 != null) {
                view7 = this.this$0.view;
                Boxing.boxBoolean(view7.removeCallbacks(runnable4));
            }
            this.this$0.actionMode = null;
            return Unit.INSTANCE;
        } finally {
            snapshotStateObserver = this.this$0.snapshotStateObserver;
            snapshotStateObserver.clear();
            myLooper = Looper.myLooper();
            view = this.this$0.view;
            handler = view.getHandler();
            Looper looper3 = handler != null ? handler.getLooper() : null;
            AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider5 = this.this$0;
            if (myLooper != looper3) {
                runnable2 = androidTextContextMenuToolbarProvider5.finishActionModeRunnable;
                if (runnable2 == null) {
                    final AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider6 = this.this$0;
                    Runnable runnable8 = new Runnable() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AndroidTextContextMenuToolbarProvider$showTextContextMenu$2.invokeSuspend$lambda$2(AndroidTextContextMenuToolbarProvider.this);
                        }
                    };
                    this.this$0.finishActionModeRunnable = runnable8;
                    runnable2 = runnable8;
                }
                view3 = this.this$0.view;
                Boxing.boxBoolean(view3.post(runnable2));
            } else {
                actionMode = androidTextContextMenuToolbarProvider5.actionMode;
                if (actionMode != null) {
                    actionMode.finish();
                }
            }
            runnable = this.this$0.startActionModeRunnable;
            if (runnable != null) {
                view2 = this.this$0.view;
                Boxing.boxBoolean(view2.removeCallbacks(runnable));
            }
            this.this$0.actionMode = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void invokeSuspend$lambda$0(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, TextActionModeCallback textActionModeCallback, AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl textContextMenuSessionImpl) {
        View view;
        ActionMode actionMode;
        TextToolbarHelper textToolbarHelper = TextToolbarHelper.INSTANCE;
        view = androidTextContextMenuToolbarProvider.view;
        ActionMode startActionMode = textToolbarHelper.startActionMode(view, textActionModeCallback);
        actionMode = androidTextContextMenuToolbarProvider.actionMode;
        Intrinsics.areEqual(actionMode, startActionMode);
        if (startActionMode == null) {
            textContextMenuSessionImpl.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void invokeSuspend$lambda$2(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider) {
        ActionMode actionMode;
        actionMode = androidTextContextMenuToolbarProvider.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
    }
}
