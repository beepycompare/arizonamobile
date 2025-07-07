package com.arkivanov.decompose.statekeeper;

import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: ChildStateKeeper.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ChildStateKeeperKt$child$3 extends FunctionReferenceImpl implements Function0<SerializableContainer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildStateKeeperKt$child$3(Object obj) {
        super(0, obj, StateKeeperDispatcher.class, "save", "save()Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SerializableContainer invoke() {
        return ((StateKeeperDispatcher) this.receiver).save();
    }
}
