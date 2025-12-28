package androidx.emoji.widget;

import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;
/* loaded from: classes2.dex */
public final class EmojiEditTextHelper {
    private final EditText mEditText;
    private final EmojiTextWatcher mTextWatcher;
    private int mMaxEmojiCount = Integer.MAX_VALUE;
    private int mEmojiReplaceStrategy = 0;

    public EmojiEditTextHelper(EditText editText) {
        Preconditions.checkNotNull(editText, "editText cannot be null");
        this.mEditText = editText;
        EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText);
        this.mTextWatcher = emojiTextWatcher;
        editText.addTextChangedListener(emojiTextWatcher);
        editText.setEditableFactory(EmojiEditableFactory.getInstance());
    }

    public void setMaxEmojiCount(int i) {
        Preconditions.checkArgumentNonnegative(i, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = i;
        this.mTextWatcher.setMaxEmojiCount(i);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public KeyListener getKeyListener(KeyListener keyListener) {
        Preconditions.checkNotNull(keyListener, "keyListener cannot be null");
        return keyListener instanceof EmojiKeyListener ? keyListener : new EmojiKeyListener(keyListener);
    }

    public InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.mEditText, inputConnection, editorInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEmojiReplaceStrategy(int i) {
        this.mEmojiReplaceStrategy = i;
        this.mTextWatcher.setEmojiReplaceStrategy(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }
}
