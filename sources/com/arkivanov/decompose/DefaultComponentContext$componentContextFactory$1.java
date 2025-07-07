package com.arkivanov.decompose;

import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultComponentContext.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class DefaultComponentContext$componentContextFactory$1 implements ComponentContextFactory, FunctionAdapter {
    public static final DefaultComponentContext$componentContextFactory$1 INSTANCE = new DefaultComponentContext$componentContextFactory$1();

    DefaultComponentContext$componentContextFactory$1() {
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ComponentContextFactory) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(4, DefaultComponentContext.class, "<init>", "<init>(Lcom/arkivanov/essenty/lifecycle/Lifecycle;Lcom/arkivanov/essenty/statekeeper/StateKeeper;Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;Lcom/arkivanov/essenty/backhandler/BackHandler;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.arkivanov.decompose.ComponentContextFactory
    public final DefaultComponentContext invoke(Lifecycle p0, StateKeeper stateKeeper, InstanceKeeper instanceKeeper, BackHandler backHandler) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DefaultComponentContext(p0, stateKeeper, instanceKeeper, backHandler);
    }
}
