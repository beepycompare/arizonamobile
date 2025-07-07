package com.arkivanov.essenty.lifecycle;

import androidx.lifecycle.DefaultLifecycleObserver;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidExt.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0004\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/arkivanov/essenty/lifecycle/AndroidLifecycleObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "delegate", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$Callbacks;", "onDestroy", "Lkotlin/Function0;", "", "<init>", "(Lcom/arkivanov/essenty/lifecycle/Lifecycle$Callbacks;Lkotlin/jvm/functions/Function0;)V", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "onResume", "onPause", "onStop", "lifecycle_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AndroidLifecycleObserver implements DefaultLifecycleObserver {
    private final Lifecycle.Callbacks delegate;
    private final Function0<Unit> onDestroy;

    public AndroidLifecycleObserver(Lifecycle.Callbacks delegate, Function0<Unit> onDestroy) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(onDestroy, "onDestroy");
        this.delegate = delegate;
        this.onDestroy = onDestroy;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.delegate.onCreate();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.delegate.onStart();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.delegate.onResume();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.delegate.onPause();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.delegate.onStop();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.delegate.onDestroy();
        this.onDestroy.invoke();
    }
}
