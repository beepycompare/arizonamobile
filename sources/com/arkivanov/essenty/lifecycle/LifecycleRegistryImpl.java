package com.arkivanov.essenty.lifecycle;

import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LifecycleRegistryImpl.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/arkivanov/essenty/lifecycle/LifecycleRegistryImpl;", "Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "initialState", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "<init>", "(Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;)V", "callbacks", "", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$Callbacks;", "_state", RemoteConfigConstants.ResponseFieldKey.STATE, "getState", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "subscribe", "", "unsubscribe", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "checkState", "required", "lifecycle_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LifecycleRegistryImpl implements LifecycleRegistry {
    private Lifecycle.State _state;
    private Set<? extends Lifecycle.Callbacks> callbacks;

    public LifecycleRegistryImpl(Lifecycle.State initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        this.callbacks = SetsKt.emptySet();
        this._state = initialState;
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle
    public Lifecycle.State getState() {
        return this._state;
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle
    public void subscribe(Lifecycle.Callbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        if (this.callbacks.contains(callbacks)) {
            throw new IllegalStateException("Already subscribed".toString());
        }
        this.callbacks = SetsKt.plus(this.callbacks, callbacks);
        Lifecycle.State state = this._state;
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            callbacks.onCreate();
        }
        if (state.compareTo(Lifecycle.State.STARTED) >= 0) {
            callbacks.onStart();
        }
        if (state.compareTo(Lifecycle.State.RESUMED) >= 0) {
            callbacks.onResume();
        }
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle
    public void unsubscribe(Lifecycle.Callbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.callbacks = SetsKt.minus(this.callbacks, callbacks);
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onCreate() {
        checkState(Lifecycle.State.INITIALIZED);
        this._state = Lifecycle.State.CREATED;
        for (Lifecycle.Callbacks callbacks : this.callbacks) {
            callbacks.onCreate();
        }
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onStart() {
        checkState(Lifecycle.State.CREATED);
        this._state = Lifecycle.State.STARTED;
        for (Lifecycle.Callbacks callbacks : this.callbacks) {
            callbacks.onStart();
        }
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onResume() {
        checkState(Lifecycle.State.STARTED);
        this._state = Lifecycle.State.RESUMED;
        for (Lifecycle.Callbacks callbacks : this.callbacks) {
            callbacks.onResume();
        }
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onPause() {
        checkState(Lifecycle.State.RESUMED);
        this._state = Lifecycle.State.STARTED;
        for (Lifecycle.Callbacks callbacks : CollectionsKt.reversed(this.callbacks)) {
            callbacks.onPause();
        }
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onStop() {
        checkState(Lifecycle.State.STARTED);
        this._state = Lifecycle.State.CREATED;
        for (Lifecycle.Callbacks callbacks : CollectionsKt.reversed(this.callbacks)) {
            callbacks.onStop();
        }
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onDestroy() {
        checkState(Lifecycle.State.CREATED);
        this._state = Lifecycle.State.DESTROYED;
        for (Lifecycle.Callbacks callbacks : CollectionsKt.reversed(this.callbacks)) {
            callbacks.onDestroy();
        }
        this.callbacks = SetsKt.emptySet();
    }

    private final void checkState(Lifecycle.State state) {
        if (this._state != state) {
            throw new IllegalStateException(("Expected state " + state + " but was " + this._state).toString());
        }
    }
}
