package com.arizonagames.feature.arizona.bank;

import android.app.Activity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizonagames.feature.arizona.bank.BankScreen$requestHistory$1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.dialogs.DialogBankHistory;
import ru.mrlargha.commonui.utils.MapperKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen$requestHistory$1", f = "BankScreen.kt", i = {1}, l = {791, 792}, m = "invokeSuspend", n = {TtmlNode.TAG_BODY}, nl = {792, 813}, s = {"L$0"}, v = 2)
/* loaded from: classes3.dex */
public final class BankScreen$requestHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $addType;
    final /* synthetic */ Function1<Continuation<? super String>, Object> $loadBody;
    final /* synthetic */ String $title;
    Object L$0;
    int label;
    final /* synthetic */ BankScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BankScreen$requestHistory$1(Function1<? super Continuation<? super String>, ? extends Object> function1, BankScreen bankScreen, String str, int i, Continuation<? super BankScreen$requestHistory$1> continuation) {
        super(2, continuation);
        this.$loadBody = function1;
        this.this$0 = bankScreen;
        this.$title = str;
        this.$addType = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BankScreen$requestHistory$1(this.$loadBody, this.this$0, this.$title, this.$addType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BankScreen$requestHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r10 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.arizonagames.feature.arizona.bank.BankScreen$requestHistory$1.AnonymousClass1(r9.this$0, r9.$title, r9.$addType, r7, null), r9) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super String>, Object> function1 = this.$loadBody;
            this.label = 1;
            obj = function1.invoke(this);
        } else if (i != 1) {
            if (i == 2) {
                String str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        String str2 = (String) obj;
        this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BankScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen$requestHistory$1$1", f = "BankScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizonagames.feature.arizona.bank.BankScreen$requestHistory$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addType;
        final /* synthetic */ String $body;
        final /* synthetic */ String $title;
        int label;
        final /* synthetic */ BankScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BankScreen bankScreen, String str, int i, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = bankScreen;
            this.$title = str;
            this.$addType = i;
            this.$body = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$title, this.$addType, this.$body, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DialogBankHistory dialogBankHistory;
            Activity targetActivity;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                dialogBankHistory = this.this$0.historyDialog;
                if (dialogBankHistory != null) {
                    dialogBankHistory.closeSilently();
                }
                BankScreen bankScreen = this.this$0;
                targetActivity = this.this$0.getTargetActivity();
                int id = UIElementID.DIALOG.getId();
                String str = this.$title;
                String json = MapperKt.getGson().toJson(MapsKt.mapOf(TuplesKt.to("type", Boxing.boxInt(10)), TuplesKt.to("header", this.$title), TuplesKt.to("addType", Boxing.boxInt(this.$addType)), TuplesKt.to(TtmlNode.TAG_BODY, this.$body)));
                Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                final BankScreen bankScreen2 = this.this$0;
                bankScreen.historyDialog = new DialogBankHistory(targetActivity, id, str, json, 0, false, new Function0() { // from class: com.arizonagames.feature.arizona.bank.BankScreen$requestHistory$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BankScreen$requestHistory$1.AnonymousClass1.invokeSuspend$lambda$0(BankScreen.this);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit invokeSuspend$lambda$0(BankScreen bankScreen) {
            bankScreen.historyDialog = null;
            return Unit.INSTANCE;
        }
    }
}
