package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
import ru.mrlargha.commonui.databinding.HudCaptBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HudCapt.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt$closeListAfterFiveSecond$1", f = "HudCapt.kt", i = {0, 1}, l = {148, BuiltInsProtoBuf.PROPERTY_SETTER_ANNOTATION_FIELD_NUMBER}, m = "invokeSuspend", n = {"pastTime", "pastTime"}, s = {"I$0", "I$0"})
/* loaded from: classes5.dex */
public final class HudCapt$closeListAfterFiveSecond$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HudCaptBinding $binding;
    final /* synthetic */ List<HudCaptItemModel> $itemList;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HudCapt$closeListAfterFiveSecond$1(HudCaptBinding hudCaptBinding, List<HudCaptItemModel> list, Continuation<? super HudCapt$closeListAfterFiveSecond$1> continuation) {
        super(2, continuation);
        this.$binding = hudCaptBinding;
        this.$itemList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HudCapt$closeListAfterFiveSecond$1(this.$binding, this.$itemList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HudCapt$closeListAfterFiveSecond$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt$closeListAfterFiveSecond$1.AnonymousClass1(r8.$binding, r8.$itemList, null), r8) == r0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r8) != r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005c -> B:7:0x0013). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            if (i > 5) {
            }
        } else if (i3 == 1) {
            i2 = this.I$0;
            ResultKt.throwOnFailure(obj);
            this.I$0 = i2;
            this.label = 2;
        } else if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i2 = this.I$0;
            ResultKt.throwOnFailure(obj);
            i = i2;
            if (i > 5) {
                return Unit.INSTANCE;
            }
            int i4 = i + 1;
            if (i4 == 5) {
                this.I$0 = i4;
                this.label = 1;
            }
            i2 = i4;
            this.I$0 = i2;
            this.label = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HudCapt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt$closeListAfterFiveSecond$1$1", f = "HudCapt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt$closeListAfterFiveSecond$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HudCaptBinding $binding;
        final /* synthetic */ List<HudCaptItemModel> $itemList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HudCaptBinding hudCaptBinding, List<HudCaptItemModel> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$binding = hudCaptBinding;
            this.$itemList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$binding, this.$itemList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            HudCapt hudCapt = HudCapt.INSTANCE;
            HudCapt.isOpenList = false;
            HudCapt.INSTANCE.checkOpenList(this.$binding, this.$itemList);
            return Unit.INSTANCE;
        }
    }
}
