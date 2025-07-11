package ru.mrlargha.commonui.elements.donate.domain.usecases;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateGetItemUseCase.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase", f = "DonateGetItemUseCase.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {TsExtractor.TS_STREAM_TYPE_DTS, 122}, m = "updateItem", n = {"item", "this_$iv", "$this$lockAndReturn$iv", "$i$f$lockAndReturn", "item", "this_$iv", "$this$lockAndReturn$iv", "currentState", "currentList", "existing", "updated", "$i$f$lockAndReturn", "$i$a$-lockAndReturn-DonateGetItemUseCase$updateItem$2", "existingIndex"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"})
/* loaded from: classes5.dex */
public final class DonateGetItemUseCase$updateItem$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DonateGetItemUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateGetItemUseCase$updateItem$1(DonateGetItemUseCase donateGetItemUseCase, Continuation<? super DonateGetItemUseCase$updateItem$1> continuation) {
        super(continuation);
        this.this$0 = donateGetItemUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateItem(null, this);
    }
}
