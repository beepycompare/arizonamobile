package androidx.compose.foundation.text;

import android.os.Build;
import androidx.compose.foundation.R;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ContextMenu.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/TextContextMenuItems;", "", "stringId", "", "(Ljava/lang/String;II)V", "resolvedString", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Cut", "Copy", "Paste", "SelectAll", "Autofill", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextContextMenuItems {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TextContextMenuItems[] $VALUES;
    public static final TextContextMenuItems Autofill;
    private final int stringId;
    public static final TextContextMenuItems Cut = new TextContextMenuItems("Cut", 0, 17039363);
    public static final TextContextMenuItems Copy = new TextContextMenuItems("Copy", 1, 17039361);
    public static final TextContextMenuItems Paste = new TextContextMenuItems("Paste", 2, 17039371);
    public static final TextContextMenuItems SelectAll = new TextContextMenuItems("SelectAll", 3, 17039373);

    private static final /* synthetic */ TextContextMenuItems[] $values() {
        return new TextContextMenuItems[]{Cut, Copy, Paste, SelectAll, Autofill};
    }

    public static EnumEntries<TextContextMenuItems> getEntries() {
        return $ENTRIES;
    }

    public static TextContextMenuItems valueOf(String str) {
        return (TextContextMenuItems) Enum.valueOf(TextContextMenuItems.class, str);
    }

    public static TextContextMenuItems[] values() {
        return (TextContextMenuItems[]) $VALUES.clone();
    }

    private TextContextMenuItems(String str, int i, int i2) {
        this.stringId = i2;
    }

    static {
        Autofill = new TextContextMenuItems("Autofill", 4, Build.VERSION.SDK_INT <= 26 ? R.string.autofill : 17039386);
        TextContextMenuItems[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public final String resolvedString(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -309609081, "C(resolvedString)131@5015L24:ContextMenu.android.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-309609081, i, -1, "androidx.compose.foundation.text.TextContextMenuItems.resolvedString (ContextMenu.android.kt:131)");
        }
        String stringResource = StringResources_androidKt.stringResource(this.stringId, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stringResource;
    }
}
