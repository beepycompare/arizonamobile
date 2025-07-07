package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
/* compiled from: AutofillUtils.android.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0013\n\u0002\u0010\r\n\u0002\b!\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J#\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001aH\u0007¢\u0006\u0002\u0010\u001bJ \u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0004H\u0007J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\tH\u0007J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\tH\u0007J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0018\u0010(\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000fH\u0007J\u0018\u0010*\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\tH\u0007J\u0018\u0010,\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0007J\u0018\u0010/\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00100\u001a\u00020\tH\u0007J@\u00101\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0007J\u0018\u00108\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00109\u001a\u00020\tH\u0007J\u0018\u0010:\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\tH\u0007J\u0018\u0010<\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\tH\u0007J6\u0010>\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010\u000f2\b\u0010A\u001a\u0004\u0018\u00010\u000f2\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0007J\u0018\u0010C\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0004H\u0007J\u0018\u0010D\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\tH\u0007J\u0018\u0010F\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\tH\u0007J\u0018\u0010H\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\tH\u0007J\u0018\u0010J\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010K\u001a\u00020.H\u0007J\u0018\u0010L\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u0004H\u0007J\u0010\u0010N\u001a\u00020.2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006O"}, d2 = {"Landroidx/compose/ui/autofill/AutofillApi26Helper;", "", "()V", "addChildCount", "", "structure", "Landroid/view/ViewStructure;", "num", "booleanValue", "", "value", "Landroid/view/autofill/AutofillValue;", "getAutofillId", "Landroid/view/autofill/AutofillId;", "getAutofillTextValue", "", "isDate", "isList", "isText", "isToggle", "listValue", "newChild", FirebaseAnalytics.Param.INDEX, "setAutofillHints", "", "hints", "", "(Landroid/view/ViewStructure;[Ljava/lang/String;)V", "setAutofillId", "parent", "virtualId", "setAutofillType", "type", "setAutofillValue", "setCheckable", "checkable", "setChecked", "checked", "setChildCount", "numChildren", "setClassName", "classname", "setClickable", "clickable", "setContentDescription", "contentDescription", "", "setDataIsSensitive", "isSensitive", "setDimens", TtmlNode.LEFT, "top", "scrollX", "scrollY", "width", "height", "setEnabled", "enabled", "setFocusable", "focusable", "setFocused", "focused", "setId", "id", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "typeName", "entryName", "setInputType", "setLongClickable", "longClickable", "setOpaque", "isOpaque", "setSelected", "isSelected", "setText", "text", "setVisibility", "visibility", "textValue", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AutofillApi26Helper {
    public static final int $stable = 0;
    public static final AutofillApi26Helper INSTANCE = new AutofillApi26Helper();

    private AutofillApi26Helper() {
    }

    public final ViewStructure newChild(ViewStructure viewStructure, int i) {
        return viewStructure.newChild(i);
    }

    public final int addChildCount(ViewStructure viewStructure, int i) {
        return viewStructure.addChildCount(i);
    }

    public final void setId(ViewStructure viewStructure, int i, String str, String str2, String str3) {
        viewStructure.setId(i, str, str2, str3);
    }

    public final void setDimens(ViewStructure viewStructure, int i, int i2, int i3, int i4, int i5, int i6) {
        viewStructure.setDimens(i, i2, i3, i4, i5, i6);
    }

    public final AutofillId getAutofillId(ViewStructure viewStructure) {
        return viewStructure.getAutofillId();
    }

    public final boolean isDate(AutofillValue autofillValue) {
        return autofillValue.isDate();
    }

    public final boolean isList(AutofillValue autofillValue) {
        return autofillValue.isList();
    }

    public final boolean isText(AutofillValue autofillValue) {
        return autofillValue.isText();
    }

    public final boolean isToggle(AutofillValue autofillValue) {
        return autofillValue.isToggle();
    }

    public final void setContentDescription(ViewStructure viewStructure, CharSequence charSequence) {
        viewStructure.setContentDescription(charSequence);
    }

    public final void setAutofillHints(ViewStructure viewStructure, String[] strArr) {
        viewStructure.setAutofillHints(strArr);
    }

    public final void setAutofillId(ViewStructure viewStructure, AutofillId autofillId, int i) {
        viewStructure.setAutofillId(autofillId, i);
    }

    public final void setAutofillType(ViewStructure viewStructure, int i) {
        viewStructure.setAutofillType(i);
    }

    public final void setAutofillValue(ViewStructure viewStructure, AutofillValue autofillValue) {
        viewStructure.setAutofillValue(autofillValue);
    }

    public final void setCheckable(ViewStructure viewStructure, boolean z) {
        viewStructure.setCheckable(z);
    }

    public final void setChecked(ViewStructure viewStructure, boolean z) {
        viewStructure.setChecked(z);
    }

    public final void setChildCount(ViewStructure viewStructure, int i) {
        viewStructure.setChildCount(i);
    }

    public final void setClassName(ViewStructure viewStructure, String str) {
        viewStructure.setClassName(str);
    }

    public final void setClickable(ViewStructure viewStructure, boolean z) {
        viewStructure.setClickable(z);
    }

    public final void setDataIsSensitive(ViewStructure viewStructure, boolean z) {
        viewStructure.setDataIsSensitive(z);
    }

    public final void setEnabled(ViewStructure viewStructure, boolean z) {
        viewStructure.setEnabled(z);
    }

    public final void setFocusable(ViewStructure viewStructure, boolean z) {
        viewStructure.setFocusable(z);
    }

    public final void setFocused(ViewStructure viewStructure, boolean z) {
        viewStructure.setFocused(z);
    }

    public final void setInputType(ViewStructure viewStructure, int i) {
        viewStructure.setInputType(i);
    }

    public final void setLongClickable(ViewStructure viewStructure, boolean z) {
        viewStructure.setLongClickable(z);
    }

    public final void setOpaque(ViewStructure viewStructure, boolean z) {
        viewStructure.setOpaque(z);
    }

    public final void setSelected(ViewStructure viewStructure, boolean z) {
        viewStructure.setSelected(z);
    }

    public final void setText(ViewStructure viewStructure, CharSequence charSequence) {
        viewStructure.setText(charSequence);
    }

    public final void setVisibility(ViewStructure viewStructure, int i) {
        viewStructure.setVisibility(i);
    }

    public final CharSequence textValue(AutofillValue autofillValue) {
        return autofillValue.getTextValue();
    }

    public final boolean booleanValue(AutofillValue autofillValue) {
        return autofillValue.getToggleValue();
    }

    public final int listValue(AutofillValue autofillValue) {
        return autofillValue.getListValue();
    }

    public final AutofillValue getAutofillTextValue(String str) {
        return AutofillValue.forText(str);
    }
}
