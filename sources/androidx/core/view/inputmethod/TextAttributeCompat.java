package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.PersistableBundle;
import android.view.inputmethod.TextAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class TextAttributeCompat {
    private final TextAttributeCompatImpl mImpl;

    /* loaded from: classes2.dex */
    private interface TextAttributeCompatImpl {
        PersistableBundle getExtras();

        Object getTextAttribute();

        List<String> getTextConversionSuggestions();

        boolean isTextSuggestionSelected();
    }

    /* loaded from: classes2.dex */
    private static final class TextAttributeCompatBaseImpl implements TextAttributeCompatImpl {
        private final PersistableBundle mExtras;
        private final List<String> mTextConversionSuggestions;
        private final boolean mTextSuggestionSelected;

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public Object getTextAttribute() {
            return null;
        }

        TextAttributeCompatBaseImpl(List<String> list, PersistableBundle persistableBundle, boolean z) {
            this.mTextConversionSuggestions = Collections.unmodifiableList(list);
            this.mExtras = persistableBundle;
            this.mTextSuggestionSelected = z;
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public List<String> getTextConversionSuggestions() {
            return this.mTextConversionSuggestions;
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public boolean isTextSuggestionSelected() {
            return this.mTextSuggestionSelected;
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public PersistableBundle getExtras() {
            return this.mExtras;
        }
    }

    /* loaded from: classes2.dex */
    private static final class TextAttributeCompatApi33Impl implements TextAttributeCompatImpl {
        final TextAttribute mObject;
        private final boolean mTextSuggestionSelected;

        TextAttributeCompatApi33Impl(Object obj) {
            this.mObject = (TextAttribute) obj;
            this.mTextSuggestionSelected = false;
        }

        TextAttributeCompatApi33Impl(List<String> list, PersistableBundle persistableBundle, boolean z) {
            this.mObject = new TextAttribute.Builder().setTextConversionSuggestions(list).setExtras(persistableBundle).build();
            this.mTextSuggestionSelected = z;
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public List<String> getTextConversionSuggestions() {
            return this.mObject.getTextConversionSuggestions();
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public boolean isTextSuggestionSelected() {
            return this.mTextSuggestionSelected;
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public PersistableBundle getExtras() {
            return this.mObject.getExtras();
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public Object getTextAttribute() {
            return this.mObject;
        }
    }

    /* loaded from: classes2.dex */
    private static final class TextAttributeCompatApi37Impl implements TextAttributeCompatImpl {
        final TextAttribute mObject;

        TextAttributeCompatApi37Impl(Object obj) {
            this.mObject = (TextAttribute) obj;
        }

        TextAttributeCompatApi37Impl(List<String> list, PersistableBundle persistableBundle, boolean z) {
            this.mObject = new TextAttribute.Builder().setTextConversionSuggestions(list).setExtras(persistableBundle).setTextSuggestionSelected(z).build();
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public List<String> getTextConversionSuggestions() {
            return this.mObject.getTextConversionSuggestions();
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public boolean isTextSuggestionSelected() {
            return this.mObject.isTextSuggestionSelected();
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public PersistableBundle getExtras() {
            return this.mObject.getExtras();
        }

        @Override // androidx.core.view.inputmethod.TextAttributeCompat.TextAttributeCompatImpl
        public Object getTextAttribute() {
            return this.mObject;
        }
    }

    private TextAttributeCompat(List<String> list, PersistableBundle persistableBundle, boolean z) {
        if (Build.VERSION.SDK_INT >= 37) {
            this.mImpl = new TextAttributeCompatApi37Impl(list, persistableBundle, z);
        } else if (Build.VERSION.SDK_INT >= 33) {
            this.mImpl = new TextAttributeCompatApi33Impl(list, persistableBundle, z);
        } else {
            this.mImpl = new TextAttributeCompatBaseImpl(list, persistableBundle, z);
        }
    }

    private TextAttributeCompat(TextAttributeCompatImpl textAttributeCompatImpl) {
        this.mImpl = textAttributeCompatImpl;
    }

    public List<String> getTextConversionSuggestions() {
        return this.mImpl.getTextConversionSuggestions();
    }

    public boolean isTextSuggestionSelected() {
        return this.mImpl.isTextSuggestionSelected();
    }

    public PersistableBundle getExtras() {
        return this.mImpl.getExtras();
    }

    public static TextAttributeCompat wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 37) {
            return new TextAttributeCompat(new TextAttributeCompatApi37Impl(obj));
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return new TextAttributeCompat(new TextAttributeCompatApi33Impl(obj));
        }
        return null;
    }

    public Object unwrap() {
        return this.mImpl.getTextAttribute();
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private List<String> mTextConversionSuggestions = new ArrayList();
        private PersistableBundle mExtras = new PersistableBundle();
        private boolean mTextSuggestionSelected = false;

        public Builder setTextConversionSuggestions(List<String> list) {
            this.mTextConversionSuggestions = list;
            return this;
        }

        public Builder setTextSuggestionSelected(boolean z) {
            this.mTextSuggestionSelected = z;
            return this;
        }

        public Builder setExtras(PersistableBundle persistableBundle) {
            this.mExtras = persistableBundle;
            return this;
        }

        public TextAttributeCompat build() {
            return new TextAttributeCompat(this.mTextConversionSuggestions, this.mExtras, this.mTextSuggestionSelected);
        }
    }
}
