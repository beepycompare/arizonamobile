package com.arkivanov.essenty.statekeeper;

import kotlin.Metadata;
/* compiled from: StateKeeperDispatcher.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "save", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface StateKeeperDispatcher extends StateKeeper {
    SerializableContainer save();
}
