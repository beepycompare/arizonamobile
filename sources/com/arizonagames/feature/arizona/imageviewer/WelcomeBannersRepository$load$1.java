package com.arizonagames.feature.arizona.imageviewer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WelcomeBannersRepository.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.imageviewer.WelcomeBannersRepository", f = "WelcomeBannersRepository.kt", i = {0}, l = {12}, m = "load", n = {"projectResourceUrl"}, nl = {13}, s = {"L$0"}, v = 2)
/* loaded from: classes3.dex */
public final class WelcomeBannersRepository$load$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WelcomeBannersRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WelcomeBannersRepository$load$1(WelcomeBannersRepository welcomeBannersRepository, Continuation<? super WelcomeBannersRepository$load$1> continuation) {
        super(continuation);
        this.this$0 = welcomeBannersRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.load(this);
    }
}
