package androidx.emoji.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.inputmethodservice.InputMethodService;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.emoji.R;
import androidx.media3.common.C;
/* loaded from: classes2.dex */
public class EmojiExtractTextLayout extends LinearLayout {
    private View.OnClickListener mButtonOnClickListener;
    private ViewGroup mExtractAccessories;
    private ExtractButtonCompat mExtractAction;
    private EmojiExtractEditText mExtractEditText;
    private boolean mInitialized;

    public EmojiExtractTextLayout(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public EmojiExtractTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0, 0);
    }

    public EmojiExtractTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    public EmojiExtractTextLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i, i2);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        if (!this.mInitialized) {
            this.mInitialized = true;
            setOrientation(0);
            View inflate = LayoutInflater.from(context).inflate(R.layout.input_method_extract_view, (ViewGroup) this, true);
            this.mExtractAccessories = (ViewGroup) inflate.findViewById(R.id.inputExtractAccessories);
            this.mExtractAction = (ExtractButtonCompat) inflate.findViewById(R.id.inputExtractAction);
            this.mExtractEditText = (EmojiExtractEditText) inflate.findViewById(16908325);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmojiExtractTextLayout, i, i2);
                ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.EmojiExtractTextLayout, attributeSet, obtainStyledAttributes, i, i2);
                this.mExtractEditText.setEmojiReplaceStrategy(obtainStyledAttributes.getInteger(R.styleable.EmojiExtractTextLayout_emojiReplaceStrategy, 0));
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setEmojiReplaceStrategy(int i) {
        this.mExtractEditText.setEmojiReplaceStrategy(i);
    }

    public int getEmojiReplaceStrategy() {
        return this.mExtractEditText.getEmojiReplaceStrategy();
    }

    public void onUpdateExtractingViews(InputMethodService inputMethodService, EditorInfo editorInfo) {
        if (inputMethodService.isExtractViewShown() && this.mExtractAccessories != null) {
            if (editorInfo.actionLabel != null || ((editorInfo.imeOptions & 255) != 1 && (editorInfo.imeOptions & C.BUFFER_FLAG_LAST_SAMPLE) == 0 && editorInfo.inputType != 0)) {
                this.mExtractAccessories.setVisibility(0);
                if (this.mExtractAction != null) {
                    if (editorInfo.actionLabel != null) {
                        this.mExtractAction.setText(editorInfo.actionLabel);
                    } else {
                        this.mExtractAction.setText(inputMethodService.getTextForImeAction(editorInfo.imeOptions));
                    }
                    this.mExtractAction.setOnClickListener(getButtonClickListener(inputMethodService));
                    return;
                }
                return;
            }
            this.mExtractAccessories.setVisibility(8);
            ExtractButtonCompat extractButtonCompat = this.mExtractAction;
            if (extractButtonCompat != null) {
                extractButtonCompat.setOnClickListener(null);
            }
        }
    }

    private View.OnClickListener getButtonClickListener(InputMethodService inputMethodService) {
        if (this.mButtonOnClickListener == null) {
            this.mButtonOnClickListener = new ButtonOnclickListener(inputMethodService);
        }
        return this.mButtonOnClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ButtonOnclickListener implements View.OnClickListener {
        private final InputMethodService mInputMethodService;

        ButtonOnclickListener(InputMethodService inputMethodService) {
            this.mInputMethodService = inputMethodService;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditorInfo currentInputEditorInfo = this.mInputMethodService.getCurrentInputEditorInfo();
            InputConnection currentInputConnection = this.mInputMethodService.getCurrentInputConnection();
            if (currentInputEditorInfo == null || currentInputConnection == null) {
                return;
            }
            if (currentInputEditorInfo.actionId != 0) {
                currentInputConnection.performEditorAction(currentInputEditorInfo.actionId);
            } else if ((currentInputEditorInfo.imeOptions & 255) != 1) {
                currentInputConnection.performEditorAction(currentInputEditorInfo.imeOptions & 255);
            }
        }
    }
}
