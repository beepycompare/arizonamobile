package com.arkivanov.essenty.lifecycle;

import androidx.lifecycle.LifecycleObserver;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidExt.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/arkivanov/essenty/lifecycle/EssentyLifecycleInterop;", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "delegate", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "observerMap", "Ljava/util/HashMap;", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$Callbacks;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/collections/HashMap;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "getState", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "subscribe", "", "callbacks", "unsubscribe", "lifecycle_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EssentyLifecycleInterop implements Lifecycle {
    private final androidx.lifecycle.Lifecycle delegate;
    private final HashMap<Lifecycle.Callbacks, LifecycleObserver> observerMap;

    public EssentyLifecycleInterop(androidx.lifecycle.Lifecycle delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.observerMap = new HashMap<>();
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle
    public Lifecycle.State getState() {
        Lifecycle.State essentyLifecycleState;
        essentyLifecycleState = AndroidExtKt.toEssentyLifecycleState(this.delegate.getCurrentState());
        return essentyLifecycleState;
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle
    public void subscribe(final Lifecycle.Callbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        if (this.observerMap.containsKey(callbacks)) {
            throw new IllegalStateException("Already subscribed".toString());
        }
        AndroidLifecycleObserver androidLifecycleObserver = new AndroidLifecycleObserver(callbacks, new Function0() { // from class: com.arkivanov.essenty.lifecycle.EssentyLifecycleInterop$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit subscribe$lambda$1;
                subscribe$lambda$1 = EssentyLifecycleInterop.subscribe$lambda$1(EssentyLifecycleInterop.this, callbacks);
                return subscribe$lambda$1;
            }
        });
        this.observerMap.put(callbacks, androidLifecycleObserver);
        this.delegate.addObserver(androidLifecycleObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subscribe$lambda$1(EssentyLifecycleInterop essentyLifecycleInterop, Lifecycle.Callbacks callbacks) {
        essentyLifecycleInterop.observerMap.remove(callbacks);
        return Unit.INSTANCE;
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle
    public void unsubscribe(Lifecycle.Callbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        LifecycleObserver remove = this.observerMap.remove(callbacks);
        if (remove != null) {
            this.delegate.removeObserver(remove);
        }
    }
}
