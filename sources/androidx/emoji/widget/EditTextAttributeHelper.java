package androidx.emoji.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.emoji.R;
/* loaded from: classes2.dex */
public class EditTextAttributeHelper {
    static final int MAX_EMOJI_COUNT = Integer.MAX_VALUE;
    private int mMaxEmojiCount;

    public EditTextAttributeHelper(View view, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.EmojiEditText, i, i2);
            this.mMaxEmojiCount = obtainStyledAttributes.getInteger(R.styleable.EmojiEditText_maxEmojiCount, Integer.MAX_VALUE);
            obtainStyledAttributes.recycle();
        }
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }
}
