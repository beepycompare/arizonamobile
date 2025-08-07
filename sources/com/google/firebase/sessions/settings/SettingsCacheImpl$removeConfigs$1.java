package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCacheImpl", f = "SettingsCache.kt", i = {}, l = {107}, m = "removeConfigs$com_google_firebase_firebase_sessions", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SettingsCacheImpl$removeConfigs$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCacheImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCacheImpl$removeConfigs$1(SettingsCacheImpl settingsCacheImpl, Continuation<? super SettingsCacheImpl$removeConfigs$1> continuation) {
        super(continuation);
        this.this$0 = settingsCacheImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeConfigs$com_google_firebase_firebase_sessions(this);
    }
}
