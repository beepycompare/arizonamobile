package androidx.compose.foundation.text.selection;

import android.os.Build;
import android.os.LocaleList;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
/* compiled from: PlatformSelectionBehaviors.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "Landroid/view/textclassifier/TextClassifier;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 0, 0, 1}, l = {369, 159}, m = "invokeSuspend", n = {"suggestedSelection", "$this$withLock_u24default$iv", "newSelection", "newSelection"}, s = {"L$0", "L$1", "J$0", "J$0"}, v = 1)
/* loaded from: classes.dex */
final class PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 extends SuspendLambda implements Function2<TextClassifier, Continuation<? super TextRange>, Object> {

    /* renamed from: $$v$c$androidx-compose-ui-text-TextRange$-selection$0  reason: not valid java name */
    final /* synthetic */ long f59$$v$c$androidxcomposeuitextTextRange$selection$0;
    final /* synthetic */ CharSequence $text;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(CharSequence charSequence, long j, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Continuation<? super PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2> continuation) {
        super(2, continuation);
        this.$text = charSequence;
        this.f59$$v$c$androidxcomposeuitextTextRange$selection$0 = j;
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 = new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(this.$text, this.f59$$v$c$androidxcomposeuitextTextRange$selection$0, this.this$0, continuation);
        platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2.L$0 = obj;
        return platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TextClassifier textClassifier, Continuation<? super TextRange> continuation) {
        return ((PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2) create(textClassifier, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocaleList androidLocalList;
        Object m1595classifyTextM8tDOmk;
        long j;
        Mutex mutex;
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl;
        CharSequence charSequence;
        TextSelection textSelection;
        Mutex mutex2;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TextClassifier textClassifier = (TextClassifier) this.L$0;
            TextSelection.Request.Builder builder = new TextSelection.Request.Builder(this.$text, TextRange.m7001getMinimpl(this.f59$$v$c$androidxcomposeuitextTextRange$selection$0), TextRange.m7000getMaximpl(this.f59$$v$c$androidxcomposeuitextTextRange$selection$0));
            androidLocalList = this.this$0.getAndroidLocalList();
            TextSelection.Request.Builder defaultLocales = builder.setDefaultLocales(androidLocalList);
            if (Build.VERSION.SDK_INT >= 31) {
                defaultLocales.setIncludeTextClassification(true);
            }
            TextSelection suggestSelection = textClassifier.suggestSelection(defaultLocales.build());
            long TextRange = TextRangeKt.TextRange(suggestSelection.getSelectionStartIndex(), suggestSelection.getSelectionEndIndex());
            if (Build.VERSION.SDK_INT < 31 || suggestSelection.getTextClassification() == null) {
                this.J$0 = TextRange;
                this.label = 2;
                m1595classifyTextM8tDOmk = this.this$0.m1595classifyTextM8tDOmk(this.$text, TextRange, textClassifier, this);
                if (m1595classifyTextM8tDOmk != coroutine_suspended) {
                    j = TextRange;
                    j2 = j;
                }
            } else {
                mutex = this.this$0.mutex;
                platformSelectionBehaviorsImpl = this.this$0;
                charSequence = this.$text;
                this.L$0 = suggestSelection;
                this.L$1 = mutex;
                this.L$2 = platformSelectionBehaviorsImpl;
                this.L$3 = charSequence;
                this.J$0 = TextRange;
                this.label = 1;
                if (mutex.lock(null, this) != coroutine_suspended) {
                    textSelection = suggestSelection;
                    mutex2 = mutex;
                    j2 = TextRange;
                    CharSequence charSequence2 = charSequence;
                    TextClassification textClassification = textSelection.getTextClassification();
                    Intrinsics.checkNotNull(textClassification);
                    platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence2, j2, textClassification, null));
                    Unit unit = Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        } else if (i == 1) {
            long j3 = this.J$0;
            charSequence = (CharSequence) this.L$3;
            textSelection = (TextSelection) this.L$0;
            ResultKt.throwOnFailure(obj);
            mutex2 = (Mutex) this.L$1;
            j2 = j3;
            platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) this.L$2;
            CharSequence charSequence22 = charSequence;
            try {
                TextClassification textClassification2 = textSelection.getTextClassification();
                Intrinsics.checkNotNull(textClassification2);
                platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence22, j2, textClassification2, null));
                Unit unit2 = Unit.INSTANCE;
            } finally {
                mutex2.unlock(null);
            }
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            j2 = j;
        }
        return TextRange.m6991boximpl(j2);
    }
}
