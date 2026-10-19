package ru.mrlargha.commonui.elements.keyboard;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.textfield.TextInputEditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
/* compiled from: Backspace.kt */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0019\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007J\u0014\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010\u001b\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\b\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/HoldBackspaceController;", "", "editText", "Lcom/google/android/material/textfield/TextInputEditText;", "<init>", "(Lcom/google/android/material/textfield/TextInputEditText;)V", "isEnabledType", "", "onTextRemove", "Lkotlin/Function0;", "", "setIsEnableType", "enableType", "setOnRemove", "onRemove", "handler", "Landroid/os/Handler;", "holding", "holdStart", "", "initialDelayMs", "repeatCharMs", "switchToWordAfterMs", "repeatWordMs", "repeater", "ru/mrlargha/commonui/elements/keyboard/HoldBackspaceController$repeater$1", "Lru/mrlargha/commonui/elements/keyboard/HoldBackspaceController$repeater$1;", "attachTo", "backspaceButtonList", "", "Landroid/view/View;", TtmlNode.START, "stop", "deleteOneChar", "deleteOneWord", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HoldBackspaceController {
    private final TextInputEditText editText;
    private final Handler handler;
    private long holdStart;
    private boolean holding;
    private final long initialDelayMs;
    private boolean isEnabledType;
    private Function0<Unit> onTextRemove;
    private final long repeatCharMs;
    private final long repeatWordMs;
    private final HoldBackspaceController$repeater$1 repeater;
    private final long switchToWordAfterMs;

    /* JADX WARN: Type inference failed for: r3v4, types: [ru.mrlargha.commonui.elements.keyboard.HoldBackspaceController$repeater$1] */
    public HoldBackspaceController(TextInputEditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.editText = editText;
        this.isEnabledType = true;
        this.onTextRemove = new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.HoldBackspaceController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        this.handler = new Handler(Looper.getMainLooper());
        this.initialDelayMs = 180L;
        this.repeatCharMs = 35L;
        this.switchToWordAfterMs = 900L;
        this.repeatWordMs = 90L;
        this.repeater = new Runnable() { // from class: ru.mrlargha.commonui.elements.keyboard.HoldBackspaceController$repeater$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                long j;
                long j2;
                Handler handler;
                long j3;
                Handler handler2;
                long j4;
                z = HoldBackspaceController.this.holding;
                if (z) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = HoldBackspaceController.this.holdStart;
                    long j5 = currentTimeMillis - j;
                    j2 = HoldBackspaceController.this.switchToWordAfterMs;
                    int i = (j5 > j2 ? 1 : (j5 == j2 ? 0 : -1));
                    HoldBackspaceController holdBackspaceController = HoldBackspaceController.this;
                    if (i < 0) {
                        holdBackspaceController.deleteOneChar();
                        handler2 = HoldBackspaceController.this.handler;
                        j4 = HoldBackspaceController.this.repeatCharMs;
                        handler2.postDelayed(this, j4);
                        return;
                    }
                    holdBackspaceController.deleteOneWord();
                    handler = HoldBackspaceController.this.handler;
                    j3 = HoldBackspaceController.this.repeatWordMs;
                    handler.postDelayed(this, j3);
                }
            }
        };
    }

    public final void setIsEnableType(boolean z) {
        this.isEnabledType = z;
    }

    public final void setOnRemove(Function0<Unit> onRemove) {
        Intrinsics.checkNotNullParameter(onRemove, "onRemove");
        this.onTextRemove = onRemove;
    }

    public final void attachTo(List<? extends View> backspaceButtonList) {
        Intrinsics.checkNotNullParameter(backspaceButtonList, "backspaceButtonList");
        for (View view : backspaceButtonList) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.HoldBackspaceController$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return HoldBackspaceController.attachTo$lambda$0(HoldBackspaceController.this, view2, motionEvent);
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.HoldBackspaceController$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HoldBackspaceController.this.deleteOneChar();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean attachTo$lambda$0(HoldBackspaceController holdBackspaceController, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            view.setPressed(true);
            holdBackspaceController.start();
            return true;
        } else if (actionMasked == 1 || actionMasked == 3) {
            view.setPressed(false);
            holdBackspaceController.stop();
            return true;
        } else {
            return false;
        }
    }

    private final void start() {
        if (!this.isEnabledType) {
            this.onTextRemove.invoke();
        } else if (this.holding) {
            return;
        }
        this.holding = true;
        this.holdStart = System.currentTimeMillis();
        deleteOneChar();
        this.handler.postDelayed(this.repeater, this.initialDelayMs);
    }

    private final void stop() {
        this.holding = false;
        this.handler.removeCallbacks(this.repeater);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteOneChar() {
        Editable text = this.editText.getText();
        if (text == null) {
            return;
        }
        int selectionStart = this.editText.getSelectionStart();
        int selectionEnd = this.editText.getSelectionEnd();
        if (selectionStart < 0 || selectionEnd < 0) {
            return;
        }
        if (selectionStart != selectionEnd) {
            text.delete(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd));
            this.editText.setSelection(Math.min(selectionStart, selectionEnd));
        } else if (selectionStart > 0) {
            int i = selectionStart - 1;
            text.delete(i, selectionStart);
            this.editText.setSelection(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteOneWord() {
        Editable text = this.editText.getText();
        if (text == null) {
            return;
        }
        int selectionStart = this.editText.getSelectionStart();
        int selectionEnd = this.editText.getSelectionEnd();
        if (selectionStart < 0 || selectionEnd < 0) {
            return;
        }
        if (selectionStart != selectionEnd) {
            text.delete(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd));
            this.editText.setSelection(Math.min(selectionStart, selectionEnd));
        } else if (selectionStart == 0) {
        } else {
            int i = selectionStart;
            while (i > 0 && CharsKt.isWhitespace(text.charAt(i - 1))) {
                i--;
            }
            while (i > 0 && !CharsKt.isWhitespace(text.charAt(i - 1))) {
                i--;
            }
            text.delete(i, selectionStart);
            this.editText.setSelection(i);
        }
    }
}
