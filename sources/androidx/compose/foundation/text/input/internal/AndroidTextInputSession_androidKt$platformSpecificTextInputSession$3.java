package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableSharedFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidTextInputSession.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3", f = "AndroidTextInputSession.android.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ ComposeInputMethodManager $composeImm;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ TextLayoutState $layoutState;
    final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
    final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
    final /* synthetic */ TransformedTextFieldState $state;
    final /* synthetic */ MutableSharedFlow<Unit> $stylusHandwritingTrigger;
    final /* synthetic */ PlatformTextInputSession $this_platformSpecificTextInputSession;
    final /* synthetic */ Function0<Unit> $updateSelectionState;
    final /* synthetic */ ViewConfiguration $viewConfiguration;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3(MutableSharedFlow<Unit> mutableSharedFlow, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, ComposeInputMethodManager composeInputMethodManager, PlatformTextInputSession platformTextInputSession, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, Function1<? super ImeAction, Unit> function1, Function0<Unit> function0, ViewConfiguration viewConfiguration, Continuation<? super AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3> continuation) {
        super(2, continuation);
        this.$stylusHandwritingTrigger = mutableSharedFlow;
        this.$state = transformedTextFieldState;
        this.$layoutState = textLayoutState;
        this.$composeImm = composeInputMethodManager;
        this.$this_platformSpecificTextInputSession = platformTextInputSession;
        this.$imeOptions = imeOptions;
        this.$receiveContentConfiguration = receiveContentConfiguration;
        this.$onImeAction = function1;
        this.$updateSelectionState = function0;
        this.$viewConfiguration = viewConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3 androidTextInputSession_androidKt$platformSpecificTextInputSession$3 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3(this.$stylusHandwritingTrigger, this.$state, this.$layoutState, this.$composeImm, this.$this_platformSpecificTextInputSession, this.$imeOptions, this.$receiveContentConfiguration, this.$onImeAction, this.$updateSelectionState, this.$viewConfiguration, continuation);
        androidTextInputSession_androidKt$platformSpecificTextInputSession$3.L$0 = obj;
        return androidTextInputSession_androidKt$platformSpecificTextInputSession$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        return ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AndroidTextInputSession.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1", f = "AndroidTextInputSession.android.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ComposeInputMethodManager $composeImm;
        final /* synthetic */ TransformedTextFieldState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = transformedTextFieldState;
            this.$composeImm = composeInputMethodManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.$composeImm, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TransformedTextFieldState transformedTextFieldState = this.$state;
                final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
                this.label = 1;
                if (transformedTextFieldState.collectImeNotifications(new TextFieldState.NotifyImeListener() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1$$ExternalSyntheticLambda0
                    @Override // androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener
                    public final void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
                        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3.AnonymousClass1.invokeSuspend$lambda$0(ComposeInputMethodManager.this, textFieldCharSequence, textFieldCharSequence2, z);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ComposeInputMethodManager composeInputMethodManager, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
            long m1203getSelectiond9O1mEE = textFieldCharSequence.m1203getSelectiond9O1mEE();
            TextRange m1202getCompositionMzsxiRA = textFieldCharSequence.m1202getCompositionMzsxiRA();
            long m1203getSelectiond9O1mEE2 = textFieldCharSequence2.m1203getSelectiond9O1mEE();
            TextRange m1202getCompositionMzsxiRA2 = textFieldCharSequence2.m1202getCompositionMzsxiRA();
            if (z) {
                composeInputMethodManager.restartInput();
            } else if (TextRange.m6140equalsimpl0(m1203getSelectiond9O1mEE, m1203getSelectiond9O1mEE2) && Intrinsics.areEqual(m1202getCompositionMzsxiRA, m1202getCompositionMzsxiRA2)) {
            } else {
                composeInputMethodManager.updateSelection(TextRange.m6145getMinimpl(m1203getSelectiond9O1mEE2), TextRange.m6144getMaximpl(m1203getSelectiond9O1mEE2), m1202getCompositionMzsxiRA2 != null ? TextRange.m6145getMinimpl(m1202getCompositionMzsxiRA2.m6151unboximpl()) : -1, m1202getCompositionMzsxiRA2 != null ? TextRange.m6144getMaximpl(m1202getCompositionMzsxiRA2.m6151unboximpl()) : -1);
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this.$state, this.$composeImm, null), 1, null);
            MutableSharedFlow<Unit> mutableSharedFlow = this.$stylusHandwritingTrigger;
            if (mutableSharedFlow != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$2$1(mutableSharedFlow, this.$composeImm, null), 3, null);
            }
            final CursorAnchorInfoController cursorAnchorInfoController = new CursorAnchorInfoController(this.$state, this.$layoutState, this.$composeImm, coroutineScope);
            PlatformTextInputSession platformTextInputSession = this.$this_platformSpecificTextInputSession;
            final TransformedTextFieldState transformedTextFieldState = this.$state;
            final ImeOptions imeOptions = this.$imeOptions;
            final ReceiveContentConfiguration receiveContentConfiguration = this.$receiveContentConfiguration;
            final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
            final Function1<ImeAction, Unit> function1 = this.$onImeAction;
            final TextLayoutState textLayoutState = this.$layoutState;
            final Function0<Unit> function0 = this.$updateSelectionState;
            final ViewConfiguration viewConfiguration = this.$viewConfiguration;
            this.label = 1;
            if (platformTextInputSession.startInputMethod(new PlatformTextInputMethodRequest() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
                public final InputConnection createInputConnection(EditorInfo editorInfo) {
                    InputConnection invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3.invokeSuspend$lambda$2(TransformedTextFieldState.this, imeOptions, receiveContentConfiguration, composeInputMethodManager, function1, cursorAnchorInfoController, textLayoutState, function0, viewConfiguration, editorInfo);
                    return invokeSuspend$lambda$2;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputConnection invokeSuspend$lambda$2(final TransformedTextFieldState transformedTextFieldState, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, ComposeInputMethodManager composeInputMethodManager, Function1 function1, CursorAnchorInfoController cursorAnchorInfoController, TextLayoutState textLayoutState, Function0 function0, ViewConfiguration viewConfiguration, EditorInfo editorInfo) {
        AndroidTextInputSession_androidKt.logDebug$default(null, new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "createInputConnection(value=\"" + ((Object) TransformedTextFieldState.this.getVisualText()) + "\")";
            }
        }, 1, null);
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1 androidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1(new DefaultImeEditCommandScope(transformedTextFieldState), transformedTextFieldState, composeInputMethodManager, function1, receiveContentConfiguration, cursorAnchorInfoController, textLayoutState, function0, viewConfiguration);
        EditorInfo_androidKt.m1247updatepLxbY9I(editorInfo, transformedTextFieldState.getVisualText(), transformedTextFieldState.getVisualText().m1203getSelectiond9O1mEE(), imeOptions, receiveContentConfiguration != null ? AndroidTextInputSession_androidKt.ALL_MIME_TYPES : null);
        return new StatelessInputConnection(androidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1, editorInfo);
    }
}
