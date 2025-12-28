package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import com.google.common.base.Predicate;
import com.google.common.collect.UnmodifiableIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class GaplessInfoHolder {
    private static final Pattern GAPLESS_COMMENT_PATTERN = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    private static final String GAPLESS_DESCRIPTION = "iTunSMPB";
    private static final String GAPLESS_DOMAIN = "com.apple.iTunes";
    public int encoderDelay = -1;
    public int encoderPadding = -1;

    public boolean setFromMetadata(Metadata metadata) {
        UnmodifiableIterator it = metadata.getMatchingEntries(CommentFrame.class, new Predicate() { // from class: androidx.media3.extractor.GaplessInfoHolder$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                boolean equals;
                equals = ((CommentFrame) obj).description.equals(GaplessInfoHolder.GAPLESS_DESCRIPTION);
                return equals;
            }
        }).iterator();
        while (it.hasNext()) {
            if (setFromComment(((CommentFrame) it.next()).text)) {
                return true;
            }
        }
        UnmodifiableIterator it2 = metadata.getMatchingEntries(InternalFrame.class, new Predicate() { // from class: androidx.media3.extractor.GaplessInfoHolder$$ExternalSyntheticLambda1
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return GaplessInfoHolder.lambda$setFromMetadata$1((InternalFrame) obj);
            }
        }).iterator();
        while (it2.hasNext()) {
            if (setFromComment(((InternalFrame) it2.next()).text)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$setFromMetadata$1(InternalFrame internalFrame) {
        return internalFrame.domain.equals(GAPLESS_DOMAIN) && internalFrame.description.equals(GAPLESS_DESCRIPTION);
    }

    private boolean setFromComment(String str) {
        Matcher matcher = GAPLESS_COMMENT_PATTERN.matcher(str);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt((String) Util.castNonNull(matcher.group(1)), 16);
                int parseInt2 = Integer.parseInt((String) Util.castNonNull(matcher.group(2)), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.encoderDelay = parseInt;
                    this.encoderPadding = parseInt2;
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean hasGaplessInfo() {
        return (this.encoderDelay == -1 || this.encoderPadding == -1) ? false : true;
    }
}
