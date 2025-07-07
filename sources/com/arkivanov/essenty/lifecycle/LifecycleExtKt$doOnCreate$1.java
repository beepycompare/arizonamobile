package com.arkivanov.essenty.lifecycle;

import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* compiled from: LifecycleExt.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/arkivanov/essenty/lifecycle/LifecycleExtKt$doOnCreate$1", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$Callbacks;", "onCreate", "", "lifecycle_release"}, k = 1, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class LifecycleExtKt$doOnCreate$1 implements Lifecycle.Callbacks {
    final /* synthetic */ Function0<Unit> $block;
    final /* synthetic */ Lifecycle $this_doOnCreate;

    public LifecycleExtKt$doOnCreate$1(Lifecycle lifecycle, Function0<Unit> function0) {
        this.$this_doOnCreate = lifecycle;
        this.$block = function0;
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onDestroy() {
        Lifecycle.Callbacks.DefaultImpls.onDestroy(this);
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onPause() {
        Lifecycle.Callbacks.DefaultImpls.onPause(this);
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onResume() {
        Lifecycle.Callbacks.DefaultImpls.onResume(this);
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onStart() {
        Lifecycle.Callbacks.DefaultImpls.onStart(this);
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onStop() {
        Lifecycle.Callbacks.DefaultImpls.onStop(this);
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
    public void onCreate() {
        this.$this_doOnCreate.unsubscribe(this);
        this.$block.invoke();
    }
}
