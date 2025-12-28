package androidx.emoji.widget;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.core.util.Preconditions;
/* loaded from: classes2.dex */
public final class EmojiTextViewHelper {
    private final HelperInternal mHelper;

    public EmojiTextViewHelper(TextView textView) {
        Preconditions.checkNotNull(textView, "textView cannot be null");
        this.mHelper = new HelperInternal(textView);
    }

    public void updateTransformationMethod() {
        this.mHelper.updateTransformationMethod();
    }

    public InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        return this.mHelper.getFilters(inputFilterArr);
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
        return this.mHelper.wrapTransformationMethod(transformationMethod);
    }

    public void setAllCaps(boolean z) {
        this.mHelper.setAllCaps(z);
    }

    /* loaded from: classes2.dex */
    private static class HelperInternal {
        private final EmojiInputFilter mEmojiInputFilter;
        private final TextView mTextView;

        HelperInternal(TextView textView) {
            this.mTextView = textView;
            this.mEmojiInputFilter = new EmojiInputFilter(textView);
        }

        void updateTransformationMethod() {
            TransformationMethod transformationMethod = this.mTextView.getTransformationMethod();
            if (transformationMethod == null || (transformationMethod instanceof PasswordTransformationMethod)) {
                return;
            }
            this.mTextView.setTransformationMethod(wrapTransformationMethod(transformationMethod));
        }

        InputFilter[] getFilters(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter instanceof EmojiInputFilter) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.mEmojiInputFilter;
            return inputFilterArr2;
        }

        TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
            return transformationMethod instanceof EmojiTransformationMethod ? transformationMethod : new EmojiTransformationMethod(transformationMethod);
        }

        void setAllCaps(boolean z) {
            if (z) {
                updateTransformationMethod();
            }
        }
    }
}
