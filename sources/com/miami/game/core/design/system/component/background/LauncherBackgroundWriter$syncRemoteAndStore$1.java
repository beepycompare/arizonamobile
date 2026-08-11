package com.miami.game.core.design.system.component.background;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundManager.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.background.LauncherBackgroundWriter", f = "BackgroundManager.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {168, 246}, m = "syncRemoteAndStore", n = {UserMetadata.KEYDATA_FILENAME, "values", "pathValue", "hashValue", "remoteSpec", "dir", "currentFile", "currentHash", "preferredTarget", TypedValues.AttributesType.S_TARGET, "tmp", "remoteUrls", "remoteConfigFresh"}, nl = {169, 248}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0"}, v = 2)
/* loaded from: classes5.dex */
public final class LauncherBackgroundWriter$syncRemoteAndStore$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LauncherBackgroundWriter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherBackgroundWriter$syncRemoteAndStore$1(LauncherBackgroundWriter launcherBackgroundWriter, Continuation<? super LauncherBackgroundWriter$syncRemoteAndStore$1> continuation) {
        super(continuation);
        this.this$0 = launcherBackgroundWriter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object syncRemoteAndStore;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        syncRemoteAndStore = this.this$0.syncRemoteAndStore(this);
        return syncRemoteAndStore;
    }
}
