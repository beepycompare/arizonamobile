package com.arkivanov.essenty.statekeeper;

import kotlin.Metadata;
/* compiled from: StateKeeperDispatcher.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¨\u0006\u0004"}, d2 = {"StateKeeperDispatcher", "Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;", "savedState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StateKeeperDispatcherKt {
    public static /* synthetic */ StateKeeperDispatcher StateKeeperDispatcher$default(SerializableContainer serializableContainer, int i, Object obj) {
        if ((i & 1) != 0) {
            serializableContainer = null;
        }
        return StateKeeperDispatcher(serializableContainer);
    }

    public static final StateKeeperDispatcher StateKeeperDispatcher(SerializableContainer serializableContainer) {
        return new DefaultStateKeeperDispatcher(serializableContainer);
    }
}
