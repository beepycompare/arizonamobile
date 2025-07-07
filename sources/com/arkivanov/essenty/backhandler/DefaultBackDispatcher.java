package com.arkivanov.essenty.backhandler;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultBackDispatcher.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J+\u0010\u0015\u001a\u00020\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000e0\rH\u0016J+\u0010\u0019\u001a\u00020\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\r0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/arkivanov/essenty/backhandler/DefaultBackDispatcher;", "Lcom/arkivanov/essenty/backhandler/BackDispatcher;", "<init>", "()V", "set", "", "Lcom/arkivanov/essenty/backhandler/BackCallback;", "progressData", "Lcom/arkivanov/essenty/backhandler/DefaultBackDispatcher$ProgressData;", "isEnabled", "", "()Z", "enabledChangedListeners", "Lkotlin/Function1;", "", "hasEnabledCallback", "onCallbackEnabledChanged", "isRegistered", "callback", "register", "unregister", "addEnabledChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/ParameterName;", "name", "removeEnabledChangedListener", "back", "startPredictiveBack", "backEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "progressPredictiveBack", "cancelPredictiveBack", "ProgressData", "back-handler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultBackDispatcher implements BackDispatcher {
    private boolean hasEnabledCallback;
    private ProgressData progressData;
    private Set<? extends BackCallback> set = SetsKt.emptySet();
    private Set<? extends Function1<? super Boolean, Unit>> enabledChangedListeners = SetsKt.emptySet();
    private final Function1<Boolean, Unit> onCallbackEnabledChanged = new Function1() { // from class: com.arkivanov.essenty.backhandler.DefaultBackDispatcher$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit onCallbackEnabledChanged$lambda$0;
            onCallbackEnabledChanged$lambda$0 = DefaultBackDispatcher.onCallbackEnabledChanged$lambda$0(DefaultBackDispatcher.this, ((Boolean) obj).booleanValue());
            return onCallbackEnabledChanged$lambda$0;
        }
    };

    @Override // com.arkivanov.essenty.backhandler.BackDispatcher
    public boolean isEnabled() {
        Set<? extends BackCallback> set = this.set;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (BackCallback backCallback : set) {
            if (backCallback.isEnabled()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCallbackEnabledChanged$lambda$0(DefaultBackDispatcher defaultBackDispatcher, boolean z) {
        defaultBackDispatcher.onCallbackEnabledChanged();
        return Unit.INSTANCE;
    }

    private final void onCallbackEnabledChanged() {
        boolean isEnabled = isEnabled();
        if (this.hasEnabledCallback != isEnabled) {
            this.hasEnabledCallback = isEnabled;
            Iterator<T> it = this.enabledChangedListeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(Boolean.valueOf(isEnabled));
            }
        }
    }

    @Override // com.arkivanov.essenty.backhandler.BackHandler
    public boolean isRegistered(BackCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.set.contains(callback);
    }

    @Override // com.arkivanov.essenty.backhandler.BackHandler
    public void register(BackCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.set.contains(callback)) {
            throw new IllegalStateException("Callback is already registered".toString());
        }
        this.set = SetsKt.plus(this.set, callback);
        callback.addEnabledChangedListener(this.onCallbackEnabledChanged);
        onCallbackEnabledChanged();
    }

    @Override // com.arkivanov.essenty.backhandler.BackHandler
    public void unregister(BackCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.set.contains(callback)) {
            throw new IllegalStateException("Callback is not registered".toString());
        }
        this.set = SetsKt.minus(this.set, callback);
        callback.removeEnabledChangedListener(this.onCallbackEnabledChanged);
        ProgressData progressData = this.progressData;
        if (Intrinsics.areEqual(callback, progressData != null ? progressData.getCallback() : null)) {
            ProgressData progressData2 = this.progressData;
            if (progressData2 != null) {
                progressData2.setCallback(null);
            }
            callback.onBackCancelled();
        }
        onCallbackEnabledChanged();
    }

    @Override // com.arkivanov.essenty.backhandler.BackDispatcher
    public void addEnabledChangedListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.enabledChangedListeners = SetsKt.plus(this.enabledChangedListeners, listener);
    }

    @Override // com.arkivanov.essenty.backhandler.BackDispatcher
    public void removeEnabledChangedListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.enabledChangedListeners = SetsKt.minus(this.enabledChangedListeners, listener);
    }

    @Override // com.arkivanov.essenty.backhandler.BackDispatcher
    public boolean back() {
        BackCallback findMostImportant;
        ProgressData progressData = this.progressData;
        if (progressData == null || (findMostImportant = progressData.getCallback()) == null) {
            findMostImportant = UtilsKt.findMostImportant(this.set);
        }
        this.progressData = null;
        if (findMostImportant != null) {
            findMostImportant.onBack();
        }
        return findMostImportant != null;
    }

    @Override // com.arkivanov.essenty.backhandler.BackDispatcher
    public boolean startPredictiveBack(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        BackCallback findMostImportant = UtilsKt.findMostImportant(this.set);
        if (findMostImportant == null) {
            return false;
        }
        this.progressData = new ProgressData(backEvent, findMostImportant);
        findMostImportant.onBackStarted(backEvent);
        return true;
    }

    @Override // com.arkivanov.essenty.backhandler.BackDispatcher
    public void progressPredictiveBack(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        ProgressData progressData = this.progressData;
        if (progressData == null) {
            return;
        }
        if (progressData.getCallback() == null) {
            progressData.setCallback(UtilsKt.findMostImportant(this.set));
            BackCallback callback = progressData.getCallback();
            if (callback != null) {
                callback.onBackStarted(progressData.getStartEvent());
            }
        }
        BackCallback callback2 = progressData.getCallback();
        if (callback2 != null) {
            callback2.onBackProgressed(backEvent);
        }
    }

    @Override // com.arkivanov.essenty.backhandler.BackDispatcher
    public void cancelPredictiveBack() {
        BackCallback callback;
        ProgressData progressData = this.progressData;
        if (progressData != null && (callback = progressData.getCallback()) != null) {
            callback.onBackCancelled();
        }
        this.progressData = null;
    }

    /* compiled from: DefaultBackDispatcher.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/arkivanov/essenty/backhandler/DefaultBackDispatcher$ProgressData;", "", "startEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "callback", "Lcom/arkivanov/essenty/backhandler/BackCallback;", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lcom/arkivanov/essenty/backhandler/BackCallback;)V", "getStartEvent", "()Lcom/arkivanov/essenty/backhandler/BackEvent;", "getCallback", "()Lcom/arkivanov/essenty/backhandler/BackCallback;", "setCallback", "(Lcom/arkivanov/essenty/backhandler/BackCallback;)V", "back-handler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class ProgressData {
        private BackCallback callback;
        private final BackEvent startEvent;

        public ProgressData(BackEvent startEvent, BackCallback backCallback) {
            Intrinsics.checkNotNullParameter(startEvent, "startEvent");
            this.startEvent = startEvent;
            this.callback = backCallback;
        }

        public final BackEvent getStartEvent() {
            return this.startEvent;
        }

        public final BackCallback getCallback() {
            return this.callback;
        }

        public final void setCallback(BackCallback backCallback) {
            this.callback = backCallback;
        }
    }
}
