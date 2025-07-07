package com.arkivanov.decompose;

import com.arkivanov.decompose.backhandler.ChildBackHandlerKt;
import com.arkivanov.decompose.instancekeeper.ChildInstanceKeeperKt;
import com.arkivanov.decompose.lifecycle.MergedLifecycle;
import com.arkivanov.decompose.statekeeper.ChildStateKeeperKt;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComponentContextExt.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"childContext", "Ctx", "Lcom/arkivanov/decompose/GenericComponentContext;", "key", "", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "(Lcom/arkivanov/decompose/GenericComponentContext;Ljava/lang/String;Lcom/arkivanov/essenty/lifecycle/Lifecycle;)Lcom/arkivanov/decompose/GenericComponentContext;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ComponentContextExtKt {
    public static /* synthetic */ GenericComponentContext childContext$default(GenericComponentContext genericComponentContext, String str, Lifecycle lifecycle, int i, Object obj) {
        if ((i & 2) != 0) {
            lifecycle = null;
        }
        return childContext(genericComponentContext, str, lifecycle);
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>> Ctx childContext(Ctx ctx, String key, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (lifecycle != null) {
            if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
                throw new IllegalStateException("The lifecycle of a child ComponentContext must never be destroyed manually.".toString());
            }
            lifecycle.subscribe(new Lifecycle.Callbacks() { // from class: com.arkivanov.decompose.ComponentContextExtKt$childContext$$inlined$doOnDestroy$1
                @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
                public void onCreate() {
                    Lifecycle.Callbacks.DefaultImpls.onCreate(this);
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
                public void onDestroy() {
                    throw new IllegalStateException("The lifecycle of a child ComponentContext must never be destroyed manually.".toString());
                }
            });
        }
        return (Ctx) ctx.getComponentContextFactory().invoke(lifecycle == null ? ctx.getLifecycle() : new MergedLifecycle(ctx.getLifecycle(), lifecycle), ChildStateKeeperKt.child(ctx.getStateKeeper(), key, lifecycle), ChildInstanceKeeperKt.child(ctx.getInstanceKeeper(), key, lifecycle), ChildBackHandlerKt.child$default(ctx.getBackHandler(), lifecycle, 0, 2, null));
    }
}
