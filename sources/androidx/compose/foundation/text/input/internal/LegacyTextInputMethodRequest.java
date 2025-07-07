package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
/* compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u000203H\u0016J\u000e\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u000206J\b\u00107\u001a\u00020\u0007H\u0002JN\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070\u0005J\u0018\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010'2\u0006\u0010>\u001a\u00020'J.\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002062\u0006\u0010F\u001a\u000206R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020'@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "view", "Landroid/view/View;", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "cursorAnchorInfoController", "Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "focusedRect", "Landroid/graphics/Rect;", "getFocusedRect$foundation_release", "()Landroid/graphics/Rect;", "setFocusedRect$foundation_release", "(Landroid/graphics/Rect;)V", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "onEditCommand", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", RemoteConfigConstants.ResponseFieldKey.STATE, "getState", "()Landroidx/compose/ui/text/input/TextFieldValue;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "createInputConnection", "outAttributes", "Landroid/view/inputmethod/EditorInfo;", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "restartInputImmediately", "startInput", "value", "textInputNode", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;", "updateState", "oldValue", "newValue", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "decorationBoxBounds", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LegacyTextInputMethodRequest implements PlatformTextInputMethodRequest {
    public static final int $stable = 8;
    private final LegacyCursorAnchorInfoController cursorAnchorInfoController;
    private Rect focusedRect;
    private final InputMethodManager inputMethodManager;
    private LegacyTextFieldState legacyTextFieldState;
    private TextFieldSelectionManager textFieldSelectionManager;
    private final View view;
    private ViewConfiguration viewConfiguration;
    private Function1<? super List<? extends EditCommand>, Unit> onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$onEditCommand$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends EditCommand> list) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends EditCommand> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }
    };
    private Function1<? super ImeAction, Unit> onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$onImeActionPerformed$1
        /* renamed from: invoke-KlQnJC8  reason: not valid java name */
        public final void m1276invokeKlQnJC8(int i) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
            m1276invokeKlQnJC8(imeAction.m6317unboximpl());
            return Unit.INSTANCE;
        }
    };
    private TextFieldValue state = new TextFieldValue("", TextRange.Companion.m6152getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
    private ImeOptions imeOptions = ImeOptions.Companion.getDefault();
    private List<WeakReference<RecordingInputConnection>> ics = new ArrayList();
    private final Lazy baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<BaseInputConnection>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$baseInputConnection$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BaseInputConnection invoke() {
            return new BaseInputConnection(LegacyTextInputMethodRequest.this.getView(), false);
        }
    });

    public LegacyTextInputMethodRequest(View view, Function1<? super Matrix, Unit> function1, InputMethodManager inputMethodManager) {
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.cursorAnchorInfoController = new LegacyCursorAnchorInfoController(function1, inputMethodManager);
    }

    public final View getView() {
        return this.view;
    }

    public final TextFieldValue getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    public final Rect getFocusedRect$foundation_release() {
        return this.focusedRect;
    }

    public final void setFocusedRect$foundation_release(Rect rect) {
        this.focusedRect = rect;
    }

    public final void startInput(TextFieldValue textFieldValue, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, ImeOptions imeOptions, Function1<? super List<? extends EditCommand>, Unit> function1, Function1<? super ImeAction, Unit> function12) {
        this.state = textFieldValue;
        this.imeOptions = imeOptions;
        this.onEditCommand = function1;
        this.onImeActionPerformed = function12;
        this.legacyTextFieldState = legacyPlatformTextInputNode != null ? legacyPlatformTextInputNode.getLegacyTextFieldState() : null;
        this.textFieldSelectionManager = legacyPlatformTextInputNode != null ? legacyPlatformTextInputNode.getTextFieldSelectionManager() : null;
        this.viewConfiguration = legacyPlatformTextInputNode != null ? legacyPlatformTextInputNode.getViewConfiguration() : null;
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public RecordingInputConnection createInputConnection(EditorInfo editorInfo) {
        EditorInfo_androidKt.m1248updatepLxbY9I$default(editorInfo, this.state.getText(), this.state.m6396getSelectiond9O1mEE(), this.imeOptions, null, 8, null);
        LegacyPlatformTextInputServiceAdapter_androidKt.access$updateWithEmojiCompat(editorInfo);
        TextFieldValue textFieldValue = this.state;
        boolean autoCorrect = this.imeOptions.getAutoCorrect();
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(textFieldValue, new InputEventCallback2() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$createInputConnection$1
            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onEditCommands(List<? extends EditCommand> list) {
                Function1 function1;
                function1 = LegacyTextInputMethodRequest.this.onEditCommand;
                function1.invoke(list);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            /* renamed from: onImeAction-KlQnJC8 */
            public void mo1275onImeActionKlQnJC8(int i) {
                Function1 function1;
                function1 = LegacyTextInputMethodRequest.this.onImeActionPerformed;
                function1.invoke(ImeAction.m6311boximpl(i));
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onKeyEvent(KeyEvent keyEvent) {
                BaseInputConnection baseInputConnection;
                baseInputConnection = LegacyTextInputMethodRequest.this.getBaseInputConnection();
                baseInputConnection.sendKeyEvent(keyEvent);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onRequestCursorAnchorInfo(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
                LegacyCursorAnchorInfoController legacyCursorAnchorInfoController;
                legacyCursorAnchorInfoController = LegacyTextInputMethodRequest.this.cursorAnchorInfoController;
                legacyCursorAnchorInfoController.requestUpdate(z, z2, z3, z4, z5, z6);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onConnectionClosed(RecordingInputConnection recordingInputConnection2) {
                List list;
                List list2;
                List list3;
                list = LegacyTextInputMethodRequest.this.ics;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list2 = LegacyTextInputMethodRequest.this.ics;
                    if (Intrinsics.areEqual(((WeakReference) list2.get(i)).get(), recordingInputConnection2)) {
                        list3 = LegacyTextInputMethodRequest.this.ics;
                        list3.remove(i);
                        return;
                    }
                }
            }
        }, autoCorrect, this.legacyTextFieldState, this.textFieldSelectionManager, this.viewConfiguration);
        this.ics.add(new WeakReference<>(recordingInputConnection));
        return recordingInputConnection;
    }

    public final void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        boolean z = (TextRange.m6140equalsimpl0(this.state.m6396getSelectiond9O1mEE(), textFieldValue2.m6396getSelectiond9O1mEE()) && Intrinsics.areEqual(this.state.m6395getCompositionMzsxiRA(), textFieldValue2.m6395getCompositionMzsxiRA())) ? false : true;
        this.state = textFieldValue2;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = this.ics.get(i).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setTextFieldValue$foundation_release(textFieldValue2);
            }
        }
        this.cursorAnchorInfoController.invalidate();
        if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
            if (z) {
                InputMethodManager inputMethodManager = this.inputMethodManager;
                int m6145getMinimpl = TextRange.m6145getMinimpl(textFieldValue2.m6396getSelectiond9O1mEE());
                int m6144getMaximpl = TextRange.m6144getMaximpl(textFieldValue2.m6396getSelectiond9O1mEE());
                TextRange m6395getCompositionMzsxiRA = this.state.m6395getCompositionMzsxiRA();
                int m6145getMinimpl2 = m6395getCompositionMzsxiRA != null ? TextRange.m6145getMinimpl(m6395getCompositionMzsxiRA.m6151unboximpl()) : -1;
                TextRange m6395getCompositionMzsxiRA2 = this.state.m6395getCompositionMzsxiRA();
                inputMethodManager.updateSelection(m6145getMinimpl, m6144getMaximpl, m6145getMinimpl2, m6395getCompositionMzsxiRA2 != null ? TextRange.m6144getMaximpl(m6395getCompositionMzsxiRA2.m6151unboximpl()) : -1);
            }
        } else if (textFieldValue != null && (!Intrinsics.areEqual(textFieldValue.getText(), textFieldValue2.getText()) || (TextRange.m6140equalsimpl0(textFieldValue.m6396getSelectiond9O1mEE(), textFieldValue2.m6396getSelectiond9O1mEE()) && !Intrinsics.areEqual(textFieldValue.m6395getCompositionMzsxiRA(), textFieldValue2.m6395getCompositionMzsxiRA())))) {
            restartInputImmediately();
        } else {
            int size2 = this.ics.size();
            for (int i2 = 0; i2 < size2; i2++) {
                RecordingInputConnection recordingInputConnection2 = this.ics.get(i2).get();
                if (recordingInputConnection2 != null) {
                    recordingInputConnection2.updateInputState(this.state, this.inputMethodManager);
                }
            }
        }
    }

    public final void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        this.focusedRect = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        if (!this.ics.isEmpty() || (rect2 = this.focusedRect) == null) {
            return;
        }
        this.view.requestRectangleOnScreen(new Rect(rect2));
    }

    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, androidx.compose.ui.geometry.Rect rect, androidx.compose.ui.geometry.Rect rect2) {
        this.cursorAnchorInfoController.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, rect, rect2);
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }
}
