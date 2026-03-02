package androidx.compose.foundation.text.selection;

import android.app.RemoteAction;
import android.content.Context;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: PlatformSelectionBehaviors.android.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b\"\u0010#J \u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b&\u0010#J*\u0010'\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096@¢\u0006\u0004\b*\u0010+J \u0010,\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b-\u0010#J(\u0010.\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b0\u00101J<\u00104\u001a\u00020%*\u0002052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020%07¢\u0006\u0002\b8H\u0000¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b=\u0010>J?\u0010?\u001a\u0004\u0018\u0001H@\"\u0004\b\u0000\u0010@2'\u0010A\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H@0C\u0012\u0006\u0012\u0004\u0018\u0001030B¢\u0006\u0002\b8H\u0082@¢\u0006\u0002\u0010DR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviorsImpl;", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "context", "Landroid/content/Context;", "selectedTextType", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroid/content/Context;Landroidx/compose/foundation/text/selection/SelectedTextType;Landroidx/compose/ui/text/intl/LocaleList;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "textClassificationSession", "Landroid/view/textclassifier/TextClassifier;", "<set-?>", "Landroidx/compose/foundation/text/selection/TextClassificationResult;", "textClassificationResult", "getTextClassificationResult", "()Landroidx/compose/foundation/text/selection/TextClassificationResult;", "setTextClassificationResult", "(Landroidx/compose/foundation/text/selection/TextClassificationResult;)V", "textClassificationResult$delegate", "Landroidx/compose/runtime/MutableState;", "androidLocalList", "Landroid/os/LocaleList;", "getAndroidLocalList", "()Landroid/os/LocaleList;", "suggestSelectionForLongPressOrDoubleClick", "Landroidx/compose/ui/text/TextRange;", "text", "", "selection", "suggestSelectionForLongPressOrDoubleClick-pYaCw-w", "(Ljava/lang/CharSequence;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowContextMenuOrSelectionToolbar", "", "onShowContextMenuOrSelectionToolbar-Sb-Bc2M", "onShowContextMenu", "secondaryClickLocation", "Landroidx/compose/ui/geometry/Offset;", "onShowContextMenu-_2OEclM", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/geometry/Offset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowSelectionToolbar", "onShowSelectionToolbar-Sb-Bc2M", "classifyText", "textClassifier", "classifyText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AssistantItemKey", "", "addSmartSelectionTextContextMenuItems", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "child", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation", "(Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;Ljava/lang/CharSequence;JLkotlin/jvm/functions/Function1;)V", "tryGetTextClassification", "Landroid/view/textclassifier/TextClassification;", "tryGetTextClassification-FDrldGo", "(Ljava/lang/CharSequence;J)Landroid/view/textclassifier/TextClassification;", "requireTextClassificationSession", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformSelectionBehaviorsImpl implements PlatformSelectionBehaviors {
    public static final int $stable = 8;
    private final Object AssistantItemKey;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final LocaleList localeList;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);
    private final SelectedTextType selectedTextType;
    private final MutableState textClassificationResult$delegate;
    private TextClassifier textClassificationSession;

    public PlatformSelectionBehaviorsImpl(CoroutineContext coroutineContext, Context context, SelectedTextType selectedTextType, LocaleList localeList) {
        MutableState mutableStateOf$default;
        this.coroutineContext = coroutineContext;
        this.context = context;
        this.selectedTextType = selectedTextType;
        this.localeList = localeList;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.textClassificationResult$delegate = mutableStateOf$default;
        this.AssistantItemKey = new Object();
    }

    private final TextClassificationResult getTextClassificationResult() {
        return (TextClassificationResult) this.textClassificationResult$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextClassificationResult(TextClassificationResult textClassificationResult) {
        this.textClassificationResult$delegate.setValue(textClassificationResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.os.LocaleList getAndroidLocalList() {
        android.os.LocaleList androidLocaleList;
        LocaleList localeList = this.localeList;
        return (localeList == null || (androidLocaleList = TextClassifierHelperMethods.INSTANCE.toAndroidLocaleList(localeList)) == null) ? new android.os.LocaleList(Locale.Companion.getCurrent().getPlatformLocale()) : androidLocaleList;
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* renamed from: suggestSelectionForLongPressOrDoubleClick-pYaCw-w */
    public Object mo1592suggestSelectionForLongPressOrDoubleClickpYaCww(CharSequence charSequence, long j, Continuation<? super TextRange> continuation) {
        if (charSequence.length() == 0 || TextRange.m6997getCollapsedimpl(j)) {
            return null;
        }
        return requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(charSequence, j, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onShowContextMenuOrSelectionToolbar-Sb-Bc2M  reason: not valid java name */
    public final Object m1596onShowContextMenuOrSelectionToolbarSbBc2M(CharSequence charSequence, long j, Continuation<? super Unit> continuation) {
        if (charSequence.length() == 0 || TextRange.m6997getCollapsedimpl(j)) {
            return Unit.INSTANCE;
        }
        return requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$onShowContextMenuOrSelectionToolbar$2(this, charSequence, j, null), continuation);
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* renamed from: onShowContextMenu-_2OEclM */
    public Object mo1590onShowContextMenu_2OEclM(CharSequence charSequence, long j, Offset offset, Continuation<? super Unit> continuation) {
        Object m1596onShowContextMenuOrSelectionToolbarSbBc2M = m1596onShowContextMenuOrSelectionToolbarSbBc2M(charSequence, j, continuation);
        return m1596onShowContextMenuOrSelectionToolbarSbBc2M == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1596onShowContextMenuOrSelectionToolbarSbBc2M : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* renamed from: onShowSelectionToolbar-Sb-Bc2M */
    public Object mo1591onShowSelectionToolbarSbBc2M(CharSequence charSequence, long j, Continuation<? super Unit> continuation) {
        Object m1596onShowContextMenuOrSelectionToolbarSbBc2M = m1596onShowContextMenuOrSelectionToolbarSbBc2M(charSequence, j, continuation);
        return m1596onShowContextMenuOrSelectionToolbarSbBc2M == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1596onShowContextMenuOrSelectionToolbarSbBc2M : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087 A[Catch: all -> 0x00e4, TryCatch #0 {all -> 0x00e4, blocks: (B:21:0x0081, B:23:0x0087, B:25:0x008d, B:28:0x0093), top: B:42:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c8  */
    /* renamed from: classifyText-M8tDOmk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1595classifyTextM8tDOmk(CharSequence charSequence, long j, TextClassifier textClassifier, Continuation<? super Unit> continuation) {
        PlatformSelectionBehaviorsImpl$classifyText$1 platformSelectionBehaviorsImpl$classifyText$1;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        TextClassifier textClassifier2;
        long j2;
        CharSequence charSequence2;
        TextClassificationResult textClassificationResult;
        TextClassification classifyText;
        Mutex mutex2;
        Mutex mutex3;
        long j3;
        CharSequence charSequence3;
        boolean m1601canReuseh5sm0ck;
        try {
            if (continuation instanceof PlatformSelectionBehaviorsImpl$classifyText$1) {
                platformSelectionBehaviorsImpl$classifyText$1 = (PlatformSelectionBehaviorsImpl$classifyText$1) continuation;
                if ((platformSelectionBehaviorsImpl$classifyText$1.label & Integer.MIN_VALUE) != 0) {
                    platformSelectionBehaviorsImpl$classifyText$1.label -= Integer.MIN_VALUE;
                    Object obj = platformSelectionBehaviorsImpl$classifyText$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = platformSelectionBehaviorsImpl$classifyText$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        platformSelectionBehaviorsImpl$classifyText$1.L$0 = charSequence;
                        platformSelectionBehaviorsImpl$classifyText$1.L$1 = textClassifier;
                        platformSelectionBehaviorsImpl$classifyText$1.L$2 = mutex;
                        platformSelectionBehaviorsImpl$classifyText$1.J$0 = j;
                        platformSelectionBehaviorsImpl$classifyText$1.label = 1;
                        if (mutex.lock(null, platformSelectionBehaviorsImpl$classifyText$1) != coroutine_suspended) {
                            textClassifier2 = textClassifier;
                            j2 = j;
                            charSequence2 = charSequence;
                        }
                        return coroutine_suspended;
                    } else if (i != 1) {
                        if (i == 2) {
                            long j4 = platformSelectionBehaviorsImpl$classifyText$1.J$0;
                            mutex3 = (Mutex) platformSelectionBehaviorsImpl$classifyText$1.L$2;
                            classifyText = (TextClassification) platformSelectionBehaviorsImpl$classifyText$1.L$1;
                            ResultKt.throwOnFailure(obj);
                            charSequence3 = (CharSequence) platformSelectionBehaviorsImpl$classifyText$1.L$0;
                            j3 = j4;
                            try {
                                setTextClassificationResult(new TextClassificationResult(charSequence3, j3, classifyText, null));
                                Unit unit = Unit.INSTANCE;
                                mutex.unlock(null);
                                return Unit.INSTANCE;
                            } finally {
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        j2 = platformSelectionBehaviorsImpl$classifyText$1.J$0;
                        mutex = (Mutex) platformSelectionBehaviorsImpl$classifyText$1.L$2;
                        textClassifier2 = (TextClassifier) platformSelectionBehaviorsImpl$classifyText$1.L$1;
                        charSequence2 = (CharSequence) platformSelectionBehaviorsImpl$classifyText$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    textClassificationResult = getTextClassificationResult();
                    if (textClassificationResult != null) {
                        m1601canReuseh5sm0ck = PlatformSelectionBehaviors_androidKt.m1601canReuseh5sm0ck(textClassificationResult, charSequence2, j2);
                        if (m1601canReuseh5sm0ck) {
                            return Unit.INSTANCE;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    mutex.unlock(null);
                    classifyText = textClassifier2.classifyText(new TextClassification.Request.Builder(charSequence2, TextRange.m7001getMinimpl(j2), TextRange.m7000getMaximpl(j2)).setDefaultLocales(getAndroidLocalList()).build());
                    mutex2 = this.mutex;
                    platformSelectionBehaviorsImpl$classifyText$1.L$0 = charSequence2;
                    platformSelectionBehaviorsImpl$classifyText$1.L$1 = classifyText;
                    platformSelectionBehaviorsImpl$classifyText$1.L$2 = mutex2;
                    platformSelectionBehaviorsImpl$classifyText$1.J$0 = j2;
                    platformSelectionBehaviorsImpl$classifyText$1.label = 2;
                    if (mutex2.lock(null, platformSelectionBehaviorsImpl$classifyText$1) != coroutine_suspended) {
                        mutex3 = mutex2;
                        j3 = j2;
                        charSequence3 = charSequence2;
                        setTextClassificationResult(new TextClassificationResult(charSequence3, j3, classifyText, null));
                        Unit unit3 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
            }
            textClassificationResult = getTextClassificationResult();
            if (textClassificationResult != null) {
            }
            Unit unit22 = Unit.INSTANCE;
            mutex.unlock(null);
            classifyText = textClassifier2.classifyText(new TextClassification.Request.Builder(charSequence2, TextRange.m7001getMinimpl(j2), TextRange.m7000getMaximpl(j2)).setDefaultLocales(getAndroidLocalList()).build());
            mutex2 = this.mutex;
            platformSelectionBehaviorsImpl$classifyText$1.L$0 = charSequence2;
            platformSelectionBehaviorsImpl$classifyText$1.L$1 = classifyText;
            platformSelectionBehaviorsImpl$classifyText$1.L$2 = mutex2;
            platformSelectionBehaviorsImpl$classifyText$1.J$0 = j2;
            platformSelectionBehaviorsImpl$classifyText$1.label = 2;
            if (mutex2.lock(null, platformSelectionBehaviorsImpl$classifyText$1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        } finally {
        }
        platformSelectionBehaviorsImpl$classifyText$1 = new PlatformSelectionBehaviorsImpl$classifyText$1(this, continuation);
        Object obj2 = platformSelectionBehaviorsImpl$classifyText$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = platformSelectionBehaviorsImpl$classifyText$1.label;
        if (i != 0) {
        }
    }

    /* renamed from: addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation  reason: not valid java name */
    public final void m1597addSmartSelectionTextContextMenuItemsYmzfRxQ$foundation(TextContextMenuBuilderScope textContextMenuBuilderScope, CharSequence charSequence, long j, Function1<? super TextContextMenuBuilderScope, Unit> function1) {
        TextClassification m1598tryGetTextClassificationFDrldGo = m1598tryGetTextClassificationFDrldGo(charSequence, j);
        if (m1598tryGetTextClassificationFDrldGo == null) {
            function1.invoke(textContextMenuBuilderScope);
            return;
        }
        if (!m1598tryGetTextClassificationFDrldGo.getActions().isEmpty()) {
            TextContextMenuBuilderScope_androidKt.textClassificationItem(textContextMenuBuilderScope, this.AssistantItemKey, m1598tryGetTextClassificationFDrldGo, 0);
        } else if (TextClassifierHelperMethods.INSTANCE.hasLegacyAssistItem$foundation(m1598tryGetTextClassificationFDrldGo)) {
            TextContextMenuBuilderScope_androidKt.textClassificationItem(textContextMenuBuilderScope, this.AssistantItemKey, m1598tryGetTextClassificationFDrldGo, -1);
        }
        function1.invoke(textContextMenuBuilderScope);
        List<RemoteAction> actions = m1598tryGetTextClassificationFDrldGo.getActions();
        int size = actions.size();
        for (int i = 0; i < size; i++) {
            actions.get(i);
            if (i > 0) {
                TextContextMenuBuilderScope_androidKt.textClassificationItem(textContextMenuBuilderScope, this.AssistantItemKey, m1598tryGetTextClassificationFDrldGo, i);
            }
        }
    }

    /* renamed from: tryGetTextClassification-FDrldGo  reason: not valid java name */
    public final TextClassification m1598tryGetTextClassificationFDrldGo(CharSequence charSequence, long j) {
        TextClassification textClassification;
        boolean m1601canReuseh5sm0ck;
        if (Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            TextClassificationResult textClassificationResult = getTextClassificationResult();
            if (textClassificationResult != null) {
                m1601canReuseh5sm0ck = PlatformSelectionBehaviors_androidKt.m1601canReuseh5sm0ck(textClassificationResult, charSequence, j);
                if (m1601canReuseh5sm0ck) {
                    textClassification = textClassificationResult.getTextClassification();
                    Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
                    return textClassification;
                }
            }
            textClassification = null;
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
            return textClassification;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object requireTextClassificationSession(Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt.withContext(this.coroutineContext, new PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2(this, function2, null), continuation);
    }
}
