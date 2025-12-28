package androidx.emoji.widget;

import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
final class EmojiTextWatcher implements TextWatcher {
    private final EditText mEditText;
    private EmojiCompat.InitCallback mInitCallback;
    private int mMaxEmojiCount = Integer.MAX_VALUE;
    private int mStart = 0;
    private int mLength = 0;
    private int mEmojiReplaceStrategy = 0;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiTextWatcher(EditText editText) {
        this.mEditText = editText;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxEmojiCount(int i) {
        this.mMaxEmojiCount = i;
    }

    int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEmojiReplaceStrategy(int i) {
        this.mEmojiReplaceStrategy = i;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.mStart = i;
        if (i2 <= i3) {
            this.mLength = i3;
        } else {
            this.mLength = 0;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.mEditText.isInEditMode()) {
            return;
        }
        int i = this.mStart;
        int i2 = this.mLength;
        if (i2 > 0) {
            int loadState = EmojiCompat.get().getLoadState();
            if (loadState != 0) {
                if (loadState == 1) {
                    EmojiCompat.get().process(editable, i, i + i2, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
                    return;
                } else if (loadState != 3) {
                    return;
                }
            }
            EmojiCompat.get().registerInitCallback(getInitCallback());
        }
    }

    EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mEditText);
        }
        return this.mInitCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback implements Runnable {
        private final Reference<EditText> mViewRef;

        InitCallbackImpl(EditText editText) {
            this.mViewRef = new WeakReference(editText);
        }

        @Override // androidx.emoji.text.EmojiCompat.InitCallback
        public void onInitialized() {
            Handler handler;
            super.onInitialized();
            EditText editText = this.mViewRef.get();
            if (editText == null || (handler = editText.getHandler()) == null) {
                return;
            }
            handler.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            EditText editText = this.mViewRef.get();
            if (editText == null || !editText.isAttachedToWindow()) {
                return;
            }
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.get().process(editableText);
            EmojiInputFilter.updateSelection(editableText, selectionStart, selectionEnd);
        }
    }
}
